package actions.SetDevelopmentFields;

import actions.selenium.SetCheckBox
import actions.selenium.Browser
import actions.selenium.utils.Elements
import actions.selenium.Click

class SetDevCheckBox{
    public static void run(def params){
        if(params."Field Value"){
            params."Field Value".split(",").eachWithIndex{value, x ->
                def label = Elements.findAll(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//LABEL",Browser.Driver)
                def index = 0
                label.eachWithIndex{element, i ->
                    if(index!=0) {return} //value found
                    if(element.getText().contains(value)){
                        index = i+1
                    }
                }
                SetCheckBox.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT[@class='development-checkbox'][${index.toString()}]", Check:params.Check.split(",")[x].toBoolean())
            }
        }
    }
}