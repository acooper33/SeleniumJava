package actions.Rules;

import actions.selenium.*
import actions.selenium.utils.Elements

class SetRuleMeettheFollowingConditions{
    public void run(def params){
        SelectItem.run(ID:"//*[@id='condition-operator']","Visible Text":params."All or Any")
        
        if(params."Add, Delete or Modify"=="Delete"){Click.run(ID:"(//*[@id='condition-list']//DIV[@class='remove-element'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]/I")}
        
        else{
            if(params."Add, Delete or Modify"=="Add"){
                params."Row Number to be Added, Delete or Modify existing" = Elements.findAll(ID:"//*[@id='condition-list']/DIV[@class='element-object']",Browser.Driver).size()+1
                Click.run(ID:"//*[@id='add-condition']")
            }

            SelectItem.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[@class='element-select']","Visible Text":params."Condition")
            SelectItem.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[@class='operator']","Visible Text":params."Operator value")
            if(params."Condition value"){
                if(Exists.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[2]")>0){
                    SelectItem.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[2]","Visible Text":params."Condition value")
                }
                else if(Exists.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//INPUT")>0){
                    SetText.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//INPUT",Text:params."Condition value")
                }
                else{
                    SetText.run(ID:"(//*[@id='condition-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//*[@id='member_search_input']",Text:params."Condition value")
                    Click.run(ID:"//*[contains(text(),'(${params."Condition value"})')]")
                }
            }
        }
    }
}