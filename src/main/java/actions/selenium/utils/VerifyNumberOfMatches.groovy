package actions.selenium.utils;

import actions.selenium.Exists

class VerifyNumberOfMatches{
    public static void run(def params){
        //Verifies number of matches of a specific element that exists
        //ID = xpath of an element (considered as parent element)
        //IDChildren (array)(optional) = xpaths of children that are associated with the parent (ID) to see if this whole object exists
        //Number of Matches (integer)(optional) = how many instances of that object is expected, if null this means any amount
        //Timeout (optional, integer) = How long to wait for before giving up, default timeout is 50 seconds
        //Is Displayed (optional) = false by default
        if(params.Timeout==null){params.Timeout=30}
        if(params."Is Displayed"){params."Is Displayed"=true}
        else{params."Is Displayed"=false}
        def instancesFound = Exists.run(params)
        //If number matches is not null, this means we expect specific number of matches found
        if(params."Number of Matches"!=null){
            assert instancesFound==params."Number of Matches","Error - Expected number of matches ${params."Number of Matches"} not found, actual amount found is ${instancesFound}"
        }
        //else any number as long as it is higher than 0 will do
        else{
            assert instancesFound>0,"Error - Expected instance not found"
        }
        
        
    }
}