package actions.ActionItems;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem

class SetFindOwnerforanIdeainActionItemspage{
    public void run(def params){
        if(params."Do you own the decision to implement this idea"=="Yes"){
            Click.run(ID:"//*[@id='idea-owner-accept']")
            SelectItem.run(ID:"//*[@id='idea-owner-confirm-reason']","Visible Text":params."Do you plan to implement this idea")      
        } else {
            Click.run(ID:"//*[@id='idea-owner-decline']")
            SelectItem.run(ID:"//*[@id='idea-owner-decline-reason']","Visible Text":params."Can you help us find the appropriate owner for this idea")  
            if(params."Reassign Find Owner Action Item to a Colleague"){
                params."Reassign Find Owner Action Item to a Colleague".split(",").eachWithIndex{ name, x ->
                    if(params."Reassign Find Owner Action Item to a Colleague Add or Remove".split(",")[x]=="Add"){
                        SetText.run(ID:"//*[@id='member_search_input']",Text:name)
                        sleep(2000)
                        Click.run(ID:"//*[@id='atwho-container']//*[@data-value='${name}']/DIV/DIV")
                    }
                    else{
                        Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${name}')]/../A")
                    }
                }
            }
            SelectItem.run(ID:"//*[@id='select-reassign-category']","Visible Text":params."Reassign Find Owner Action Item to the right category")
        }
        if(params."Action"=="Confirm"){
            Click.run(ID:"//*[@class='idea-owner-confirm' and contains(@style,'block')]//*[@class='idea-owner-btn btn btn-primary' and text()='${params."Action"}']")
        } else {Click.run(ID:"//*[contains(@id,'idea-owner') and contains(@style,'block')]//A[text()='${params."Action"}']")}        
    }
}