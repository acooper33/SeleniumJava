package actions.ProjectRoom;

import actions.selenium.*

class SelectAllorMultipleTasksinProjectRoom{
    public void run(def params){
        
        if(params."Tasks to Select"=="All"){
            if(params."Select the Checbox"=="TRUE"){
                Click.run(ID:"//*[contains(@class,'f-table-header')]/*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked'))]//input/..")
            } else {
                Click.run(ID:"//*[contains(@class,'f-table-header')]/*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked')]//input/..")
            }
        } else {
            params."Tasks to Select".split(",").eachWithIndex{ tasks, x ->
                if(params."Select the Checbox".split(",")[x]=="TRUE"){
                    Click.run(ID:"//*[contains(@class,'fractal-input')]/*[@value='${tasks}']/../../../..//*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked')) and contains(@class,'f-checkbox-wrapper')]//*[@class='f-checkbox-inner']")
                } else {
                    Click.run(ID:"//*[contains(@class,'fractal-input')]/*[@value='${tasks}']/../../../..//*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]//*[@class='f-checkbox-inner']")
                }
            }
        }
    }
}