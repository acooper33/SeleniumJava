package actions.SetupUsers;

import actions.selenium.Exists
import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class SetEnterpriseSetupProfileFieldspage{
    public void run(def params){
        if (Exists.run(ID:"//*[@id='bi-header' and text()='Configure User Profile Fields']") == 0) {
            SetupCommon.NavigateTab(Tab:"Users",Section:"Profile Fields")
        }
        if(params."Add Section Header"==true){
            Click.run(ID:"//*[@id='add_section_header']")
        }
        if(params."Select Profile Field Type"){
            SelectItem.run(ID:"//*[@id='profile-field-select-main']","Visible Text":params."Select Profile Field Type")
            Click.run(ID:"//*[@id='add-profile-field-button']")
        }      
        if(params."Edit or Remove"=="Edit"){
            Click.run(ID:"//*[@class='profile_header_text title' and text()='${params."Section or Field to Edit/Remove"}']/../../..//A[contains(@id,'edit_')]")
            SetText.run(ID:"//*[contains(@id,'field-title')]",Text:params."New Field Title")
            SelectItem.run(ID:"//*[contains(@id,'new-profile-field-select')]","Visible Text":params."Profile Field Type")
            if(params."Response Type"){
                SelectItem.run(ID:"//*[contains(@id,'response-type-select')]","Visible Text":params."Response Type")
                Click.run(ID:"//*[@id='bi-modal-button']/span[text()='Change Type']")
            }
            SetCheckBox.run(ID:"//INPUT[contains(@id,'required_')]",Check:params."Required")
            SetCheckBox.run(ID:"//INPUT[contains(@id,'private_')]",Check:params."Private")
            SetCheckBox.run(ID:"//INPUT[contains(@id,'admin_')]",Check:params."Lock from Editing")
            SetText.run(ID:"//*[contains(@id,'field-answer')]/INPUT",Text:params."Short Text Answer")
            SetText.run(Text:params."Long Text Answer",ID:"//*[contains(@id,'field-answer')]/TEXTAREA")
            if(params."Dropdown and Checkbox Answers"){
                params."Dropdown and Checkbox Answers".split(";").eachWithIndex{ answer, x -> 
                    Click.run(ID:"//*[@id='add-answer-button']")
                    SetText.run(ID:"//TR[${x.toInteger() + 1}]/*[contains(@id,'field-answer') or contains(@id,'answer_list')]//*[contains(@id,'text_')]",Text:params."Dropdown and Checkbox Answers")
                }
            }
            if(params.Action){
                Click.run(ID:"//*[contains(@id,'-profile-field-button') and text()='${params.Action}']")
            }
        } else if(params."Edit or Remove"=="Remove"){
            Click.run(ID:"//*[@class='profile_header_text title' and text()='${params."Section or Field to Edit/Remove"}']/../../..//A[contains(@id,'_remove')]")
        }
        if(params."Click Save"==true){
            Click.run(ID:"//*[@id='profile-edit-save-changes-button']")
        }
    }
}