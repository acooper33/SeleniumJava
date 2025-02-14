package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.ExplicitWait

class ChangeSubmitterinNGAViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='change-idea-submitter-icon']","Type of Click":"Javascript")
        
        params."User".split(",").eachWithIndex{name, x ->
            if(params."Add or Remove or Set Owner".split(",")[x]=="Add"){
                SetText.run(ID:"//*[@id='user-search']",Text:name,"Type of Clear":"Cut")
                Click.run(ID:"//*[@id='user-search-submit']")
                ExplicitWait.run(ID:"//*[@class='result-member-name' and text()='${name}']")
                Click.run(ID:"//*[@class='result-member-name' and text()='${name}']/..")
            }
            else if(params."Add or Remove or Set Owner".split(",")[x]=="Remove"){
                Click.run(ID:"//*[@class='review-team-member-item review-team-member-name' and text()='${name}']/../*[@class='review-team-member-item review-team-member-remove']")
            }
            else if(params."Add or Remove or Set Owner".split(",")[x]=="Set Owner"){
                Click.run(ID:"//*[@class='review-team-member-item review-team-member-name' and text()='${name}']/..//I[@class='fa fa-lightbulb-o']")
            }
        }
            if(params.Action=="Update"){Click.run(ID:"//*[@class='green_btn_center' and text()='Update']")}
            else if(params.Action=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
            else {Click.run(ID:"//*[@id='bimodal-close-label']")}
    }
}