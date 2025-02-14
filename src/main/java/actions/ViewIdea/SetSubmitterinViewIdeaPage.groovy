package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click

class SetSubmitterinViewIdeaPage{
    public void run(def params){
        Click.run(ID:"//*[@id='inline-edit-icon-idea-submitter']","Type of Click":"Javascript")

        params."User".split(",").eachWithIndex{ name, x ->
            if(params."Add or Remove or Set Owner".split(",")[x]=="Add"){
                SetText.run(ID:"//*[@id='search_member_input']",Text:name)
                Click.run(ID:"//*[@id='change_submitter_popup-content-wrapper']//*[@class='search_proposal_button_off']")
                Click.run(ID:"//*[text()='${name}']/..//A[text()='>>']")
            }
            else if(params."Add or Remove or Set Owner".split(",")[x]=="Remove"){
                Click.run(ID:"//*[@class='name' and text()='${name}']/..//IMG[@class='delete_icon']")
            }
            else{
                Click.run(ID:"//*[@class='name' and text()='${name}']/..//IMG[@class='lightbulb_icon_off']")
            }
        }
        if(params."Action"){
            if(params."Action" == "Save"){Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Save Changes']")}
            else if(params."Action" == "Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else {Click.run(ID:"//*[@id='bimodal-close-label' and text()='Close']")}
        }
        sleep (2000)
    } 
}