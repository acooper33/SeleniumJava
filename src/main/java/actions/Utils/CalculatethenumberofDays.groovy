package actions.Utils;
import java.time.temporal.ChronoUnit
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import actions.Utils.ReturnTodaysDateintheRequestedFormat

class CalculatethenumberofDays{
    public static run(def params){
        
        def endDate
        def givenDate = LocalDate.parse(params."Start Date", DateTimeFormatter.ofPattern("MM-dd-yyyy"))
        if(params."End Date"){
            if(params."End Date"=="today"){
                params."End Date" = ReturnTodaysDateintheRequestedFormat.run("Format":"MM-dd-yyyy")
            }
            println("Start date: ${params."Start Date"}")
            println("End date: ${params."End Date"}")
            endDate = LocalDate.parse(params."End Date", DateTimeFormatter.ofPattern("MM-dd-yyyy"))            
        } else {
           endDate = LocalDate.now() 
        }
        
        def days = ChronoUnit.DAYS.between(givenDate,endDate)
        def daysString = days.toString()
        println("Days between start and end date: ${daysString}")
        return daysString
        
    }
}