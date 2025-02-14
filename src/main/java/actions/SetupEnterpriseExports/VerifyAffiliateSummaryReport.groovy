package actions.SetupEnterpriseExports;


import groovy.io.FileType
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.support.ui.FluentWait
import java.lang.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.time.Duration
import com.google.common.base.Function

class VerifyAffiliateSummaryReport{
    public Boolean run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        //What folder we should use
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            //params."File Location"=System.getProperty("user.home")
            params."File Location"=System.getProperty("user.home")+"/Downloads"
        }else{
            if(params."File Location"=="Downloads"){params."File Location"=System.getProperty("user.home")+"\\Downloads"}
        }
        //if(params."File Location"=="Downloads"){params."File Location"=System.getProperty("user.home")+"\\Downloads"}
        //If File name has a * then find it
        def bFound = false
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
        int rowSize = 0
        
        
        //If its an excel file, then parse it as such
        if(params."File Name".contains("xls")) {
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
            
            Sheet firstSheet = workbook.getSheetAt(0)
            Iterator<Row> iterator = firstSheet.iterator()
            int i = 0
            
            while (iterator.hasNext()){
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
            //rowSize = i
        }
        
        //Else, just get every row since CSV already assumed its comma delimeted and other ones we don't care how they are
        else{
            def csvFile
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                csvFile = new File(params."File Location"+"/${params."File Name"}")
            }else{
                csvFile = new File(params."File Location"+"\\${params."File Name"}")
            }
            //def csvFile = new File(params."File Location"+"\\${params."File Name"}")
            int i = 0
            csvFile.eachLine{ line ->
                println(line)
                rows[i] = line
                i++
            }
            //rowSize = i
        }
        
               
        //Delete file now that we are done with it
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
             assert new File(params."File Location"+"/${params."File Name"}").delete(),"Error - Failed to delete the file"
        }else{
            assert new File(params."File Location"+"\\${params."File Name"}").delete(),"Error - Failed to delete the file"
        }
        //assert new File(params."File Location"+"\\${params."File Name"}").delete(),"Error - Failed to delete the file"
        
        //declare variable to save the expected and actual values         
        def expectedValues = []
        expectedValues = params."Row Values".split(",")
        def cellValues = []
        
        //need to extract actual values with RegEx if working with xml file
        if(params."File Name".endsWith("xml")){
            Pattern pattern = Pattern.compile("(\\[CDATA\\[)(.*?)(\\]\\])");
            for(int i=2;i<rows.size()-2;i++){//skip first and last two rows due to xml formatting
            //for(int i=2;i<rowSize-2;i++){
                Matcher matcher = pattern.matcher(rows[i])
                while(matcher.find()){ //check if IF would work too
                    cellValues[i-2]=matcher.group(2)
                    print("another match: ")
                	println(cellValues[i-2])
                	println(matcher.group(2))
                }
            }
        }
        //if not xml file and all the data saved in one row, extracting actual values splitting by coma
        else{
        	cellValues = rows[1].split(",")
        }
            
        //verify matches
        def valueFound = true
        def i = 2 //skipping first two columns from the report
        print("expectedValues.length: ")
        println(expectedValues.length)
        println(expectedValues.getClass().getName());
        println(rows.getClass().getName());
        
        
        while(valueFound & i-2 < expectedValues.length){
            //converting both actual and expected values into doubles, as xls format has it set as double
            Double cellValueDouble = Double.parseDouble(cellValues[i])
            Double expectedValueDouble = Double.parseDouble(expectedValues[i-2])
            
            print("cellValueDouble")
            print(i)
            print(" ")
            println(cellValueDouble)
            print("Expected Value: ")
            println(expectedValueDouble)
            
            if (!cellValueDouble.equals(expectedValueDouble)){valueFound = false}
            i++
            
            print("ValueFound: ")
            println(valueFound)    
        }  
             
        assert valueFound==true,"Error - One or more row with expected values not found"

        if(params."Total Number of Rows"){assert params."Total Number of Rows".toInteger()==rows.size(),"Error - Expected ${params."Total Number of Rows"} Total Number of Rows does not match actual ${rows.size()}"}
    }
    
}