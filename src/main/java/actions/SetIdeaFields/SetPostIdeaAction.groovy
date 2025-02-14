package actions.SetIdeaFields;

import actions.selenium.Click

class SetPostIdeaAction{
        public static void run(def params){
        sleep(1000)
        if(params.Action){
            sleep(2000)
            if(params.Action=="Submit Idea"){
                Click.run(ID:"//*[@class='btn btn-primary f-submit-idea-btn']", "Type of Click":"Javascript")
            } else {
                Click.run(ID:"//*[contains(@class,'f-dropdown-submit-idea-btn btn-primary')]")
                Click.run(ID:"//*[@class='nav-item-label' and starts-with(text(),'${params."Action"}')]")
            }
        }
        sleep(3000)
    }
}