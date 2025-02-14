package actions.SetIdeaFields;

import actions.selenium.SetCheckBox
import actions.selenium.Browser
import actions.selenium.utils.Elements

class SetPostIdeaCheckbox{
    public static void run(def params){
        if(params."Checkbox Name"){
            params."Checkbox Name".split(",").eachWithIndex{ name, x ->
                def checkbox = Elements.findAll(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//DIV[@class='checkbox']",Browser.Driver)
                def index = 1
                checkbox.eachWithIndex{ element, i ->
                    if(index!=1){return}
                    if(element.getText().contains(name)){
                        index = i+1
                    }
                }
                SetCheckBox.run(ID:"(//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//DIV[@class='checkbox'])[${index.toString()}]//INPUT",Check:params.Check.split(",")[x].toBoolean())
            }
        }
    }
}