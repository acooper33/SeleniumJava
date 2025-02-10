package actions.selenium.utils;

class VerifyMatchingItems{
    public static String run(def params) {
        // Iterate through items in the array and check if they exist in the list
        //Contains=true: not all expected items will be among the actual items; contains =false: match exactly
        // returns the first unmatched actual item
        
        if(params."contains"==true){
            for (String actualItem : params.actual) {
                println("Verifying match with actual ${actualItem}")
            	if (!Arrays.asList(params.expected).contains(actualItem)) {
                	return "Unexpected: ${actualItem}";
            	}
        	}
        }
        else{
            if (params.actual.length != params.expected.length){return "Actual Number of Items is Differnt from Expected!"}
        	for (String actualItem : params.actual) {
            	boolean found = false;
            	for (String expectedItem : params.expected) {
                    println("Expected: ${expectedItem}")
                    println("Actual: ${actualItem}")
                	if (actualItem.equals(expectedItem)) {
                    	found = true;
                    	break;
                	}
            	}
            if (!found) {return "Unexpected: ${actualItem}"} // Return the first unmatched item
        	}
        }
        return null; // All items in the actual array match at least one item in the expected array  
    } 
}

