package actions.Utils;

import java.text.SimpleDateFormat 
import java.time.LocalDateTime   

class ReturnTodaysDateintheRequestedFormat{
    public static run(def params){
        
         SimpleDateFormat dateFormat = new SimpleDateFormat("${params."Format"}")
         String todayDate = dateFormat.format(new Date())
         println("Todays date: ${todayDate}")
         return todayDate
        
    }
}