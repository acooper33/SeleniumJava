package actions.ViewIdea;

import actions.selenium.Click
import actions.selenium.SetText


class SetLinkedSubmissionsonViewIdeaPage{
    public void run(def params){
        Click.run(ID:"//A[@id='inline-edit-icon-link_ideas']", "Type of Click":"Javascript")
        if(params."Add or Remove"){
            params."Submission Title".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    Click.run(ID:"//INPUT[@id='search-linked-ideas-input']")
                	SetText.run(ID:"//INPUT[@id='search-linked-ideas-input']", Text:name)
                    Click.run(ID:"//INPUT[@id='search-linked-ideas-input']/..//DIV[contains(@class,'search_users_button')]")
                    sleep(500)
                    Click.run(ID:"//*[starts-with(text(),'${name}')]/..//A[text()='>>']")
                }
                else if (params."Add or Remove".split(",")[x]=="Remove"){
                    Click.run(ID:"//*[@class='name' and contains(text(),'${name}')]/..//SPAN[contains(@id,'delete')]")
                }
            }
        }
        if(params.Action=="Save Changes"){
            Click.run(ID:"//*[@class='green_btn_center' and text()='Save Changes']")
        sleep(2000)}
        else if(params.Action=="Cancel") {Click.run(ID:"//A[text()='Cancel']")}
    }
}
