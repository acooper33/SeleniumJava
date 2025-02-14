package actions.ViewIdea30;

import actions.selenium.SetText
import actions.selenium.MouseOver
import actions.selenium.Click


class SetLinkedIdeasVI3{
    public void run(def params){
        if(params."Link or Unlink"=="Unlink"){
            MouseOver.run(ID:"//UL[@class='f-linked-idea-list']/LI//SPAN[@class='f-linked-title' and .='${params."Idea Title"}']/../../../IMG")
            //MouseOver.run(ID:"//UL[@class='f-linked-idea-list']/LI//SPAN[@class = 'f-linked-title-wrapper']/A and contains(.,'${params."Idea Title"}')]/../../../../IMG")
            Click.run(ID:"//UL[@class='f-linked-idea-list']/LI//SPAN[@class='f-linked-title' and contains(.,'${params."Idea Title"}')]/../../../I")
            if(params."Action"=='Submit'){Click.run(ID:"//BUTTON[@id='f-modal-submit']/SPAN[.= 'Unlink']")}
        }
        else if(params."Link or Unlink"=="Link"){
        	Click.run(ID:"//BUTTON[contains(@class,'f-link-idea-btn')]")
            if(params."Idea Title"){SetText.run(ID:"//INPUT[@id='f-select-linked-idea']", Text:params."Idea Title")}
            Click.run(ID:"//DIV[@id='f-combobox-list']//DIV[@class='f-link-idea-option']/SPAN[contains(.,'${params."Idea Title"}')]")
            if(params."Action"=='Submit'){Click.run(ID:"//DIV[@class='f-link-btns']//BUTTON[contains(@class,'f-btn-primary')]")}
        }
        sleep(2000)
    }
}