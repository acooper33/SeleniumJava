package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.Exists

class SetConfigureBusinessImpactFields{
    public void run(def params){

        if(Exists.run(ID:"//*[contains(@class,'f-btn-primary f-btn-sm')]")==0){
            SetupCommon.NavigateTab(Tab:"Ideas",Section:"Business Impact")
        }
        params."Type".split(",").eachWithIndex{ type, x ->  
            def benefitTitle = params."Benefit Title".split(",")
            def action = params."Action".split(",")
            if (action[x]=="Add") {
                //Click.run(ID:"//*[@id='${type}-config']//*[contains(@class,'fractal-button plus f-btn-standard f-btn-xs')]")
               	Click.run(ID:"//*[@id='${type}-config']//*[contains(@class,'fractal-button')]")
                SetText.run(ID:"//*[@class='f-impact-row']/*[contains(@class,'impact-input') and @value='']",Text:benefitTitle[x])               
            } 
             else if (action[x]=="Delete") {
                Click.run(ID:"//*[@id='${type}-config']//*[contains(@class,'impact-input') and @value='${benefitTitle[x]}']/../I")  
                sleep(2000)
                 if(params."Delete Action"!=null){
                     def deleteAction = params."Delete Action".split(",")
                     SetCheckBox.run(ID:"//*[@id='f-delete-impact-type-understand']", Check:true)
                     if(deleteAction[x]=="Remove Benefit"){
                         Click.run(ID:"//*[@data-test='modal-footer-submit']")  
                     } else {
                         Click.run(ID:"//*[@data-test='modal-footer-cancel']")
                     }
                 }
            }
            else if (action[x]=="Edit"){
                def editedBenefitTitle = params."New Edited Benefit Title".split(",")
                SetText.run(ID:"//*[@id='${type}-config']//*[contains(@class,'impact-input') and @value='${benefitTitle[x]}']",Text:editedBenefitTitle[x],"Type of Clear":"Cut") 
            }
            Click.run(ID:"//*[contains(@class,'f-btn-primary f-btn-sm')]", "Type of Click": "Javascript") 
            sleep(3000)
        }
    }
}

