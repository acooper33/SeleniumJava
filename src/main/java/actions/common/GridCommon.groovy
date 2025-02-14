package actions.common;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Exists

class GridCommon{
    public static def RowNumberForValues(def params){
        //Table = Xpath to the table itself
        //ID = parent or only element we are looking for
        //IDChildren (optional)
        //RETURNS (integer) = Row number where data was found
        
        //Get amount of TR's
        def i = Elements.findAll(ID:params.Table+"//TR[.]/TD[1]",Browser.Driver).size()
        
        //Find a row
        def rowNum = 0
        params.ID = params.Table+"//TR[1]"+params.ID
        params.Timeout = 1
        for(int x = 1;x<=i;x++){
            params.ID=params.ID.replaceFirst(/TR\[(.{1,5})\]/,"TR[${x.toString()}]")
            if(Exists.run(params) > 0){
                rowNum = x
                break
            }
        }

        println("Row Number: "+rowNum)
        return rowNum
    }
}
