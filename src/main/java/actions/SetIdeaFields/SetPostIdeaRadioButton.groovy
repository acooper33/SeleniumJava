package actions.SetIdeaFields;

import actions.selenium.Click

class SetPostIdeaRadioButton{
    public static void run(def params){
        if(params."Field Value"){
            Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//INPUT[starts-with(@value,'${params."Field Value"}')]")
        }
    }
}