package actions.SetIdeaFields;

import actions.selenium.SelectItem

class SetPostIdeaDropdown{
    public static void run(def params){
        if(params."Field Name"=="Submitter"){
            SelectItem.run(ID:"//*[@id='idea-form-submitter']//SELECT","Visible Text":params."Field Value")
        }
        else{
            SelectItem.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//SELECT[@class='form-control']","Visible Text":params."Field Value")
        }
        
    }
}