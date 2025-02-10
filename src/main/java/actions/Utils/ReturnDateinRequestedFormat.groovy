package actions.Utils;

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class ReturnDateinRequestedFormat{
    public static run(def params) {
        
        // Parse the format parameter
        SimpleDateFormat dateFormat = new SimpleDateFormat("${params."Format"}")
        
        // Get the number of days to add (can be positive or negative)
        int daysToAdd = Integer.parseInt(params.Days)
        
        // Create a Calendar instance and set it to today's date
        Calendar calendar = Calendar.getInstance()
        
        // Add the specified number of days to the calendar
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)
        
        // Get the new date after adding/subtracting days
        Date adjustedDate = calendar.getTime()
        
        // Format the adjusted date into the requested format
        String formattedDate = dateFormat.format(adjustedDate)
        
        // Print and return the formatted date
        println("Adjusted date: ${formattedDate}")
        return formattedDate;
    }
}