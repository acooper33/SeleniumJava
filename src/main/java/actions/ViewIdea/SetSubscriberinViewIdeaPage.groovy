package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click

class SetSubscriberinViewIdeaPage{
    public void run(def params){

        Click.run(ID:"//*[@id='subscribe-button-side']")
        SetText.run(ID:"//*[contains(@class,'subscribe-others-dropdown')]//*[contains(@class,'fractal-member-typeahead')]//INPUT",Text:params."Subscriber")
        sleep(2000)
        Click.run(ID:"//*[@id='react-autowhatever-default' and contains(.,'${params."Subscriber"}')]")
        sleep(2000)
    }
}

