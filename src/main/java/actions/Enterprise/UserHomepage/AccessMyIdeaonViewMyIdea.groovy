package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class AccessMyIdeaonViewMyIdea{
    public void run(def params){
         if(params."Access View My Idea modal"=="Link"){
             Click.run(ID:"//*[@class='f-white-toast-link']","Type of Click" : "Javascript")
        } else {
            Click.run(ID:"//*[@class='fractal-table-cell f-sparks-table-title']//*[contains(.,'${params."Access View My Idea modal"}')]")
        }
    }
}