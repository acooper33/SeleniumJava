package actions.Whiteboards;

import actions.selenium.Click

class WhiteaboardsSetAddTemplateModal{
    public void run(def params){
        if(params."Whiteaboards - Set Add Template Modal"==true){
			Click.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."View All Templates"}']/../..//DIV[contains(@class,'f-thumbnail')]")
        }
        if(params."Tab"){
            Click.run(ID:"//*[contains(@class,'f-tab')]//*[text()='${params."Tab"}']")
        }        
    }
}