package actions.Memo;

import actions.selenium.MouseOver
import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class ColabEditorSetTopBarDropdown{
    public static void run(def params){
        if(params."Click on the Bar?"){
            Click.run(ID:"//DIV[contains(@data-test,'menu-dropdown')]")
            sleep(1000)
            if(params."Main Option" && params."Sub Option"){
                MouseOver.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI//*[starts-with(text(),'${params."Main Option"}')]")
                Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI//*[starts-with(text(),'${params."Main Option"}')]/..//UL[contains(@class,'f-dropdown-options-nested') and contains(@style,'block')]//LI//*[starts-with(.,'${params."Sub Option"}')]")
            }else if(params."Main Option"){
                Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI//*[contains(text(),'${params."Main Option"}')]")
            }
        }
    }
}