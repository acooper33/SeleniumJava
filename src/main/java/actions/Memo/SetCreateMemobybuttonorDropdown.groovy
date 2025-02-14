//this is deprecated. old code
package actions.Memo;

import actions.selenium.Click
import actions.selenium.MouseOver

class SetCreateMemobybuttonorDropdown{
    public void run(def params){
        
        if(params."Click on Button or Dropdown" =="Button"){
            Click.run(ID:"//*[@class='f-dropdown-create-memo-wrapper']//BUTTON")
        } else {
             Click.run(ID:"//*[@class='f-dropdown-create-memo-wrapper']//*[contains(@class,'f-create-memo-dropdown')]/DIV/I")
            if(params."Menu Item"){
                Click.run(ID:"//*[@class='f-menu-item' and descendant::span[.='${params."Menu Item"}']]", "Type of Click":"Javascript")
                //sleep(1000)
            }
            if(params."Sub Menu Item"){
                MouseOver.run(ID:"//*[contains(@class, 'f-dropdown-options')]//*[.='${params."Sub Menu Item"}']")
                Click.run(ID:"//*[contains(@class, 'f-dropdown-options')]//*[.='${params."Sub Menu Item"}']")
            }
        }
        sleep(5000)
    }
}