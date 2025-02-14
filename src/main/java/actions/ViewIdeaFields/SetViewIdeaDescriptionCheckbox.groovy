package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.SetCheckBox
import actions.selenium.utils.Elements
import actions.selenium.Browser

class SetViewIdeaDescriptionCheckbox{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")
        ViewIdeaCommon.DescriptionEnableEdit(params)
        println(params."Checkbox Name")
        
        
        
        if(params."Checkbox Name"){
            params."Checkbox Name".split(",").eachWithIndex{ name, x ->
                def checkbox = Elements.findAll(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//input",Browser.Driver) 
                def index = 0
                checkbox.eachWithIndex{ element, i ->
                    print("name:")
                    println(name)
                    if(index!=0){return}
                    if(element.getAttribute("value").contains(name)){
                        index = i+1
                    }
                }
                SetCheckBox.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//input[${index.toString()}]", Check:params."Checkbox Check".split(",")[x].toBoolean())
            }
        }
        
        ViewIdeaCommon.DescriptionAction(params)
    }
}