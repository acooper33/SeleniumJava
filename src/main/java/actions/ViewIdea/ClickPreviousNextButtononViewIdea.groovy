package actions.ViewIdea;

import actions.selenium.Click
import actions.selenium.MouseOver

class ClickPreviousNextButtononViewIdea{
    public void run(def params){
        if (params."Previous or Next"=="Next"){
            Click.run(ID:"//A[@id='nav-buttons' and contains(@class,'next-button')]", "Type of Click":"Javascript")
        }else if(params."Previous or Next"=="Previous"){
            Click.run(ID:"//A[@id='nav-buttons' and contains(@class,'prev-button')]", "Type of Click":"Javascript")
        }
    }
}