package actions.ViewIdeaOutcomes;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.Browser
import actions.selenium.utils.Elements
import actions.selenium.SetText
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetOutcomeViewIdea{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Outcomes")
        
        if(params."New Outcome or Name of Outcome to Edit"){
            if (params."New Outcome or Name of Outcome to Edit"=="New"){
                Click.run(ID:"//*[@id='create-outcome-btn']")
                SelectItem.run(ID:"//*[@id='type-select']","Visible Text":params."Type")
                if (params."Amount") {SetText.run(ID:"//*[@id='amount-input']", "Text":params."Amount")}
                SetText.run(ID:"//*[@id='name-input']", "Text":params."Title")
				SetText.run(ID:"//*[@id='description-input']", "Text":params."Description")
                if(params."Attachment Files"){
                	params."Attachment Files".split(",").eachWithIndex{ name, x ->
                        if(params."Add or Remove".split(",")[x]=="Add"){
                            //Get path to file we are sending
                            def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                            //Now send a file to the 'attachment_upload_fallback' element
                            SendKeys.run(ID:"//*[@id ='attachment_upload_fallback']",Text:fileName)
                            sleep(5000)    
                        }
                        else{
                            if(Exists.run(ID:"//A[@class='remove-file fa fa-trash-o']")>0){
                                Click.run(ID:"//A[@class='remove-file fa fa-trash-o']")
                            }
                            else{Click.run(ID:"//A[@class='clear-error fa fa-times']")}
                       }
                	}
            	}
            	if (params."Action"=="Add Outcome"){Click.run(ID:"//*[contains(@class, 'green_btn') and text()='Add Outcome']")}
            	else if (params."Cancel"=="Cancel"){Click.run(ID:"//*[contains(@class, 'bimodal-secondary') and text()='Cancel']")}
            }
       }
       //if "New Outcome or Name of Outcome to Edit" is not "New"
       else{
           //opening an Edit Outcome pop up
           Click.run(ID:"//*[@class='outcome-name']/*[contains(text(),'${params."New Outcome or Name of Outcome to Edit"}')]/../../../*[contains(@class,'grid-action-button')]", "Type of Click":"Javascript")
           Click.run(ID:"//*[@class='outcome-name']/*[contains(text(),'${params."New Outcome or Name of Outcome to Edit"}')]/../../../../../*[contains(@class,'grid-action-dropdown')]/*[contains(@class,'outcome-edit')]")
          //edit the outcome
           Click.run(ID:"//*[@id='type-select']")
           SelectItem.run(ID:"//*[@id='type-select']","Visible Text":params."Type")
           if (params."Amount") {SetText.run(ID:"//*[@id='amount-input']", "Text":params."Amount")}
           SetText.run(ID:"//*[@id='name-input']", "Text":params."Title")
           SetText.run(ID:"//*[@id='description-input']", "Text":params."Description")
           if(params."Attachment Files"){
                params."Attachment Files".split(",").eachWithIndex{ name, x ->
                    if(params."Add or Remove".split(",")[x]=="Add"){
                        //Get path to file we are sending
                        def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                        //Now send a file to the 'attachment_upload_fallback' element
                        SendKeys.run(ID:"//*[@id, 'attachment_upload_fallback']",Text:fileName)
                        sleep(5000)    
                    }
                    else{
                        if(Exists.run(ID:"//A[@class='remove-file fa fa-trash-o']")>0){
                            Click.run(ID:"//A[@class='remove-file fa fa-trash-o']")
                        }
                        else{Click.run(ID:"//A[@class='clear-error fa fa-times']")}
                   }
                }
           }
           if (params."Action"=="Update Outcome"){Click.run(ID:"//*[contains(@class, 'green_btn') and text()='Update Outcome']")}
           else if (params."Cancel"=="Cancel"){Click.run(ID:"//*[contains(@class, 'bimodal-secondary') and text()='Cancel']")}
       }
   }
}
