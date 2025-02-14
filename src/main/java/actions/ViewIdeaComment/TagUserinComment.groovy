package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click

class TagUserinComment{
    public void run(def params){
        if(params."Username"){
            def tag = "@"+params.Username
            SetText.run(ID:"//*[@id='add-comment-input']", Text:tag)
            sleep(3000)
            Click.run(ID:"//UL[contains(@class,'ui-autocomplete')]/LI/A/SPAN[contains(@class,'email') and contains(.,'${params."User Email"}')]")
            sleep(2000)
            Click.run(ID:"//*[@id='bi-comment-button']")
            sleep(2000)
       }
    }
}