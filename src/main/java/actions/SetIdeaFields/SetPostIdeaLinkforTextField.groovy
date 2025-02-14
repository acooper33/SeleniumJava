package actions.SetIdeaFields;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.SetFocus

class SetPostIdeaLinkforTextField{
    public void run(def params){
        if(params."Field Name".contains("Description")){
            SetFocus.run(ID:"//*[@id='idea-form-description']//DIV[starts-with(@class,'redactor-styles redactor-in redactor-in')]")
            Click.run(ID:"//*[@id='idea-form-description']//DIV[starts-with(@class,'redactor-styles redactor-in redactor-in')]", "Type of Click":"Javascript")
        }else{
            SetFocus.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//DIV[starts-with(@class,'redactor-styles redactor-in redactor-in')]")
            Click.run(ID:"//*[@id='idea-form-description']//DIV[starts-with(@class,'redactor-styles redactor-in redactor-in')]", "Type of Click":"Javascript")
        }
        if(params."Link, Unlink or Edit"=="Link"){
            Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//DIV[@class='redactor-toolbar']/A[@aria-label='Link']")
        	//Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//*[@aria-label='Link']")
            Click.run(ID:"//A/*[text()='Insert Link']") //added span
            SetText.run(Text:params."URL",ID:"//*[@id='modal-link-url']", "Type of Clear":"Cut")
            SetText.run(Text:params."Text",ID:"//*[@id='modal-link-text']", "Type of Clear":"Cut")
            SetCheckBox.run(ID:"//*[@class='redactor-modal-body']//INPUT[@type='checkbox']",Check:params."Open link in new tab")
            if(params."Link Action"){
                if(params."Link Action"=="Insert"){Click.run(ID:"//*[@id='redactor-modal']//*[text()='Insert']")}
                else if (params."Link Action"=="Cancel") {Click.run(ID:"//*[@id='redactor-modal']//*[text()='Cancel']")}
            }
        }
        //if unlink
        else if(params."Link, Unlink or Edit"=="Unlink"){
            Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//A[text()='${params."Text"}']")
			Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//DIV[@class='redactor-toolbar']/A[@aria-label='Link']")
            //Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//*[@aria-label='Link']")
            Click.run(ID:"//A/span[text()='Unlink']")
            //Click.run(ID:"//A[text()='Unlink' and contains(@class,'redactor-dropdown-unlink')]/span[text()='Unlink']")
        }
        //if Edit
        else{
            //println("Trying to Edit")
            Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//A[text()='${params."Text of Link to Edit"}']")
            Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//DIV[@class='redactor-toolbar']/A[@aria-label='Link']")
            //Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//*[@aria-label='Link']")
            Click.run(ID:"//A/span[text()='Edit Link']")
            SetText.run(Text:params."URL",ID:"//*[@id='modal-link-url']", "Type of Clear":"Cut")
            SetText.run(Text:params."Text",ID:"//*[@id='modal-link-text']", "Type of Clear":"Cut")
            SetCheckBox.run(ID:"//*[@class='redactor-modal-body']//INPUT[@type='checkbox']",Check:params."Open link in new tab")
            if(params."Link Action"){
                if(params."Link Action"=="Edit"){Click.run(ID:"//*[@id='redactor-modal']//button[text()='Save']")}
                else if (params."Link Action"=="Cancel") {Click.run(ID:"//*[@id='redactor-modal']//*[text()='Cancel']")}
            }
        }
        sleep(1000)
        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]","Type of Click":"Move to Element")
    }
}