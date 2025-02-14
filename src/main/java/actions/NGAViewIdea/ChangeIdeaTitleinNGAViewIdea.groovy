package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.selenium.Click


class ChangeIdeaTitleinNGAViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='inline-edit-icon-idea-title']", "Type of Click":"Javascript")
        if(params."New Title"){
            SetText.run(ID:"//*[@id='idea-title-edit']", Text:params."New Title")
            if(params.Action=="Save"){Click.run(ID:"//*[@id='submit-btn-title']")}
            else if (params.Action=="Cancel"){Click.run(ID:"//*[@id='cancel-btn-title']")}
        }
        
        
    }
}