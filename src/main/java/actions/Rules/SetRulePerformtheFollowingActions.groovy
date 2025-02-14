package actions.Rules;

import actions.selenium.*
import actions.selenium.utils.Elements

class SetRulePerformtheFollowingActions{
    public void run(def params){
        if(params."Add, Delete or Modify"=="Delete"){Click.run(ID:"(//*[@id='action-list']//DIV[@class='remove-element'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]/I")}
        
        else{
            if(params."Add, Delete or Modify"=="Add"){
                params."Row Number to be Added, Delete or Modify existing" = Elements.findAll(ID:"//*[@id='action-list']/DIV[@class='element-object']",Browser.Driver).size()+1
                Click.run(ID:"//*[@id='add-action']")
            }

            SelectItem.run(ID:"(//*[@id='action-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[@class='element-select']","Visible Text":params."Perform Following Action")
            SelectItem.run(ID:"(//*[@id='action-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[@class='action-value']","Visible Text":params."Action Value")
            if(params."Perform Following Action"=="Send Email"){
                if(params."Select Recipient"){
                   SetText.run(ID:"//*[@id='member_search_input']",Text:params."Select Recipient")
                    Click.run(ID:"//DIV[contains(@style,'display:none') or starts-with(@style,'display: block')]/UL/LI[starts-with(@data-value,'${params."Select Recipient"}') or contains(@email,'${params."Select Recipent"}') and contains(@class,'cur')]/DIV/DIV","Type of Click":"Javascript")
                }
                SelectItem.run(ID:"(//*[@id='action-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//SELECT[@class='email-template']","Visible Text":params."Send Email Template")
                SetText.run(ID:"(//*[@id='action-list']/DIV[@class='element-object'])[${params."Row Number to be Added, Delete or Modify existing".toInteger()}]//INPUT[@class='subject']",Text:params."Send Email Enter Subject")
                if(params."Send Email Text"){
                Click.run(ID:"//*[@id='bivalidate-ignore-this']/DIV[1]/DIV[2]/DIV[6]") // replace with 
                SetText.run(ID:"//*[@id='bivalidate-ignore-this']//textarea", Text:params."Send Email Text", "Type of Clear":"None") //replace with line 28
                //SetText.run(ID:"//*[@id='idea-form-description']//DIV[starts-with(@class,'redactor-styles redactor-in redactor-in')]", Text:params."Send Email Text", "Type of Clear":"Cut")

                }
            }
                if(params."Commenter"){
                SetText.run(ID:"//*[@id='member_search_input']", Text:params."Commenter", "Type of Clear":"None")
                sleep(3000)
                Click.run(ID:"//DIV[contains(@style,'display:none') or starts-with(@style,'display: block')]/UL/LI[starts-with(@data-value,'${params."Commenter"}') or starts-with(@email,'${params."Commenter"}') and contains(@class,'cur')]/DIV/DIV","Type of Click":"Javascript") 
                }  
                SetText.run(ID:"//*[@id='comment']", Text:params."Comment", "Type of Clear":"None")
            if(params."Configure Action (Move or Copy to Pipeline Only)"){
                sleep(3000)
                Click.run(ID:"//*[@id='rule-modal']//BUTTON[contains(@class,'configure')]/I", "Type of Click":"Javascript")
            }
        }
    }
}