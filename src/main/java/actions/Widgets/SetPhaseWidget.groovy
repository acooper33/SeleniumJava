package actions.Widgets;

import actions.selenium.*

class SetPhaseWidget{
    public void run(def params){
        Click.run(ID:"//*[@class='widget_title']//*[text()='Phase Widget']/../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")

        if (params."Action on Phase"=="Add"){
            Click.run(ID:"//*[@id='add-phase-btn-wrapper']/DIV")
            SetText.run(ID:"//*[@class='edit-phase-name' and contains(@value,'Enter Name of Phase')]",Text:params."Phase")
            if (params."Description of Phase"){
                SetText.run(ID:"//*[contains(@id,'edit-phase-new_phase_')]//*[@class='edit-phase-desc' and text()='Enter Description of Phase']",Text:params."Description of Phase")}
        } else if(params."Action on Phase"=="Edit") {
            Click.run(ID:"//*[@class='setup-phase-name' and contains(text(),'${params."Phase"}')]/..//A[@class='setup-phase-edit-link']")
            if (params."New Edited Phase Name"){
                SetText.run(ID:"//*[@class='edit-phase-name' and contains(@value,'${params."Phase"}')]",Text:params."New Edited Phase Name")}
            if (params."Description of Phase"){
                SetText.run(ID:"//*[@class='edit-phase-name' and contains(@value,'${params."Phase"}')]/..//*[@class='edit-phase-desc']",Text:params."Description of Phase")}
        } else {
            Click.run(ID:"//*[@class='setup-phase-name' and contains(text(),'${params."Phase"}')]/..//A[@class='setup-phase-delete-link']")
            Click.run(ID:"//*[@class='setup-phase-name' and contains(text(),'${params."Phase"}')]/following-sibling::DIV[@class='delete-text']//A[@id='delete-yes-link']")
        }

        if (params."Action on Adding or Editing Phase" == 'Save Phase'){
            Click.run(ID:"//*[contains(@id,'edit-phase') and not(contains(@style,'none'))]//DIV[@class='save-phase-btn bi-css-btn']")
            sleep(2000)
            Click.run(ID:"//*[@class='widget_tools widget_tools_icons' and contains(@style,'block')]/A[@class='widget_edit_icon']")
        } else { Click.run(ID:"//*[contains(@id,'edit-phase') and not(contains(@style,'none'))]//A[text()='Delete']")
                if (params."Yes or Cancel on Deletion") {
                    Click.run(ID:"//*[contains(@id,'edit-phase') and not(contains(@style,'none'))]//A[text()='${params."Yes or Cancel on Deletion"}']")}
               } 
    }
}



