package actions.MTS;

import actions.selenium.Click

class SetAdvancedCreateMemo{
    public void run(def params){
        
        if(params."Start a blank memo or with a template?"){
            Click.run(ID:"//*[contains(@class,'f-template-title') and text()='${params."Start a blank memo or with a template?"}']/../..")
        }
        if(params."Action on Start a blank memo or with a template slide"){
            if(params."Action on Start a blank memo or with a template slide"=="Cancel"){
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-cancel']")
            } else {
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-submit']")
            }
        }
        if(params."Select an editor to draft your Memo within"){
            Click.run(ID:"//*[text()='${params."Select an editor to draft your Memo within"}']/../..")
        }
        if(params."Action on Select an editor to draft your Memo within slide"){
            if(params."Action on Select an editor to draft your Memo slide"=="Cancel"){
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-cancel']")
            } else {
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-submit']")
            }
        }
        if(params."Select visibility for your memo"){
            Click.run(ID:"//*[text()='${params."Select visibility for your memo"}']/../..")
        }
        if(params."Select Batch"){
           Click.run(ID:"//*[@id='select-campaign-combobox']")
           Click.run(ID:"//*[contains(@id,'f-combobox-list')]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Select Batch"}')]")
        }
        if(params."Action on Select visibility for your memo slide"){
            if(params."Action on Select visibility for your memo slide"=="Cancel"){
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-cancel']")
            } else {
                Click.run(ID:"//*[text()='Create a New Memo']/../..//*[@data-test='modal-footer-submit']")
            }
        }
        sleep(3000)
    }
}