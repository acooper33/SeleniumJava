package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.selenium.Click

class SetMessageNGAViewIdeaMessagePopup{
    public void run(def params){
        if(params."Recipients"){
            params."Recipients".split(",").eachWithIndex{name, x ->
            if(params."Add or Remove Recipient".split(",")[x]=="Add"){
                Click.run(ID:"//*[@id='member_search_input']")
                SetText.run(ID:"//*[@id='member_search_input']",Text:name,"Type of Clear":"None")
                sleep(3000)
                Click.run(ID:"//DIV[contains(@style,'display:none') or starts-with(@style,'display: block')]/UL/LI[starts-with(@data-value,'${name}') or contains(@email,'${name}') and contains(@class,'cur')]/DIV/DIV","Type of Click":"Javascript") 
            }
            else if(params."Add or Remove Recipient".split(",")[x]=="Remove"){
                Click.run(ID:"//*[@class='review-team-member-item review-team-member-name' and text()='${name}']/../*[@class='review-team-member-item review-team-member-remove']")
            	}
        	}
    	}
        SetText.run(ID:"//*[@id='new-message-subject']",Text:params."Subject")   
        SetText.run(ID:"//*[@id='new-message-body']",Text:params."Message Body")
        
        if(params."Action"=="Send"){Click.run(ID:"//*[@id='bi-modal-button']")}
        else{Click.run(ID:"//*[@id='bimodal-secondary']")}
	}
}