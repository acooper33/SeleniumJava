package actions.general

//import java.io.File
import groovy.io.FileType
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.support.ui.FluentWait;
import actions.selenium.Browser
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import com.google.common.base.Function
//import java.util.concurrent.TimeoutException
//import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.FileNotFoundException

class VerifyFileData{
    def bFound = false
    public Boolean run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        //if linux, Dowloads is the default folder
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ 
            println("We are on linux")
            params."File Location"=System.getProperty("user.home")+"/Downloads"
            println("Expecting to download into: ${params."File Location"}")
        }else{																
           if(params."File Location"=="Downloads"){params."File Location"=System.getProperty("user.home")+"\\Downloads"} 
        }
        
        if(params."File Name".contains("*")){            
            //setting up wait until the file is downloaded; max wait 30 sec, polling every 3 sec
            String downloadFolderPath = params."File Location";
            FluentWait<String> wait = new FluentWait<>(downloadFolderPath)
            int timer = 0
            wait.pollingEvery(Duration.ofSeconds(3)); 
            wait.withTimeout(Duration.ofSeconds(30));
            wait.until(new Function<String, Boolean>() {
                public Boolean apply(String path) {
                File[] listFiles = new File(path).listFiles();
                timer ++
                for (File file : listFiles){
                    if(file.name.startsWith(params."File Name".split("\\*")[0])){
                        println("Partial name match! Checking if its a full match ${file.name} ${file.getAbsolutePath()}")
                        if(file.name.split("\\.")[1]==params."File Name".split("\\.")[1]){ //verify extension
                            println("File confirmed! ${file.name}")
                        	params."File Name"=file.name
                            bFound = true
                            return true
                        }
                    }
                }
                println("File not downloaded... Attempting ${timer} of 10")
                if(params."Should file exist"==false && timer == 10) return true  //if we are not expecting file to exist
                else return false
                }
            });
            
            /*dir.eachFileRecurse (FileType.FILES) { file ->
                if(bFound){return}
                if(file.name.startsWith(params."File Name".split("\\*")[0])){
                    println("Going through file ${file.name} ${file.getAbsolutePath()}")
                    if(file.name.split("\\.")[1]==params."File Name".split("\\.")[1]){
                        println("Found file name: ${file.name}")
                        params."File Name"=file.name
                        bFound = true
                    }
                }
            }
            */
            
        }
        if(params."Should file exist"==false){
            assert bFound==false,"Error - File Exists"
        	return true
        }
        else{
            assert bFound,"Error - File not found"
        }
        def rows = []
        
        //If its an excel file, then parse it as such
        if(params."File Name".contains("xls")){
            
            FileInputStream inputStream
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                println("File to read on Linux: ${params."File Location"}"+"/${params."File Name"}")
                inputStream = new FileInputStream(new File(params."File Location"+"/${params."File Name"}"))
            }else{
                inputStream = new FileInputStream(new File(params."File Location"+"\\${params."File Name"}"))
            }
            Workbook workbook = null
            if (params."File Name".endsWith("xls")) {workbook = new HSSFWorkbook(inputStream)} 
            else{workbook = new XSSFWorkbook(inputStream)}
            
            Sheet firstSheet
            if (params."Sheet Number (for Excel only)"){firstSheet = workbook.getSheetAt(params."Sheet Number (for Excel only)".toInteger()-1)}
            else{firstSheet = workbook.getSheetAt(0)}
            Iterator<Row> iterator = firstSheet.iterator()
            int i = 0
            while (iterator.hasNext()) {
                Row nextRow = iterator.next()
                Iterator<Cell> cellIterator = nextRow.cellIterator()
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next()
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                        	print(cell.getStringCellValue())
                        	rows[i] = rows[i]+cell.getStringCellValue()
                        	break
                        case Cell.CELL_TYPE_NUMERIC:
                        	try{	
	                            if(DateUtil.isCellDateFormatted(cell)){
	                                print(cell.getDateCellValue())
	                                rows[i] = rows[i]+cell.getDateCellValue()
	                            }
	                            else{
	                                print(cell.getNumericCellValue())
	                                rows[i] = rows[i]+cell.getNumericCellValue()
	                            }
	                        }
	                        catch(Exception | Error e){
	                            print("AUTOMATION FAILED TO READ")
	                            rows[i] = rows[i]+"AUTOMATION FAILED TO READ"
	                        }
	                        break
                        case Cell.CELL_TYPE_BOOLEAN:
    	                    print(cell.getBooleanCellValue())
	                        rows[i] = rows[i]+cell.getBooleanCellValue()
	                        break
                        default:
                            break
                    }
                    print(",")
                    rows[i] = rows[i]+","
                }
                println()
                i++
            }
            workbook.close()
            inputStream.close()
        }
        
        
        
        //Else, just get every row since CSV already assumed its comma delimeted and other ones we don't care how they are
        else{
            def csvFile
            println("Reading CSV Starting")
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                csvFile = new File(params."File Location"+"/${params."File Name"}")
            }else{
                csvFile = new File(params."File Location"+"\\${params."File Name"}")
            }
            int i = 0
            csvFile.eachLine{ line ->
                println(line)
                rows[i] = line
                i++
            }
            println("Reading CSV Completed")

        }
        
        //Delete file now that we are done with it
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            assert new File(params."File Location"+"/${params."File Name"}").delete(),"Error - Failed to delete the file"
        }else{
            assert new File(params."File Location"+"\\${params."File Name"}").delete(),"Error - Failed to delete the file"
        }
        //Now find number of matches where values exist for a row
        def numberOfMatches = 0
        
       rows.each{ currentrow ->
            println("Current row: ${currentrow}")	
           currentrow = currentrow.replaceAll("\"","")
           	println("Current row cleaned: ${currentrow}")
           	def valueFound = true
       		params."Row Values".each{ currentvalue ->
                if(!valueFound){
                    return
                }
                if(!currentrow.contains(currentvalue)){
                    valueFound = false
                	println("Not Found in the above row: ${currentvalue}")
                }
            }
       		if(valueFound){
                numberOfMatches++
                println("# of matches is: ${numberOfMatches}")
            }
        }
        
        //Assert on number of matches
        if(params."Number of Matches"){assert params."Number of Matches".toInteger()==numberOfMatches,"Error - Expected ${params."Number of Matches"} number of row(s) with expected values not found, actual count is ${numberOfMatches}"}
        else{assert numberOfMatches>0,"Error - One or more row with expected values not found"}
        
        //Assert on number of Rows
        if(params."Total Number of Rows"){assert params."Total Number of Rows".toInteger()==rows.size(),"Error - Expected ${params."Total Number of Rows"} Total Number of Rows does not match actual ${rows.size()}"}
        sleep(7000)
    }
    private boolean fileSearch(def params){
    	File dir = new File(params."File Location");
        dir.eachFileRecurse (FileType.FILES) { file -> 
        	if(file.name.startsWith(params."File Name".split("\\*")[0])){
             	println("Partial name match! Checking if its a full match ${file.name} ${file.getAbsolutePath()}")
                if(file.name.split("\\.")[1] == params."File Name".split("\\.")[1]){
                	println("File confirmed! ${file.name}")
                    params."File Name" = file.name
                    return true
                }
            }
        }
        return false
    }   
}