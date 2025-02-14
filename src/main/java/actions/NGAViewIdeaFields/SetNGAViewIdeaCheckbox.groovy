package actions.NGAViewIdeaFields;

import actions.common.NGAViewIdeaCommon
import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.SetCheckBox


class SetNGAViewIdeaCheckbox{
    public static void run(def params){
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        sleep(3000)
        if(params."Checkbox Name"){
            params."Checkbox Name".split(",").eachWithIndex{ name, x ->
                println("Check or not check: ${params."Checkbox Check".split(",")[x].toBoolean()}")
                SetCheckBox.run(ID:"//*[@id='additional-questions-container']//*[starts-with(text(),'${params."Field Name"}')]/../..//DIV[starts-with(@class,'checkbox-answer-edit-container')]/input[@value='${name}']",Check:params."Checkbox Check".split(",")[x].toBoolean())
            }
        }
        
        /*
                
                println("Name: ${name}")
                    println("Field Name: ${params."Field Name"}")
                    def checkbox1 = Elements.find(ID:"//*[@id='additional-questions-container']//*[starts-with(text(),'${params."Field Name"}')]",Browser.Driver)
                	println("Passed checkbox1")
                    def checkbox = Elements.find(ID:"//*[@id='additional-questions-container']//*[starts-with(text(),'${params."Field Name"}')]/../..//DIV[starts-with(@class,'checkbox-answer-edit-container')]/input[@value='${name}']", Browser.Driver)
                    println("Valuee: ${checkbox.getAttribute("value")}")
                    //println("Checkbox size ${checkbox.size()}")
                    def index = 0 
                	checkbox.eachWithIndex{element, i ->
                    if(index !=0){return}
                    if(element.getAttribute("value").contains(name)){
                        index = i + 1
                        println("Index: ${index}")
                    }
                }
                SetCheckBox.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//input[${index.toString()}]", Check:params."Checkbox Check".split(",")[x].toBoolean())
            }
        }
*/
        NGAViewIdeaCommon.DescriptionAction(params)
     }
}