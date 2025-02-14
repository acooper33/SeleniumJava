package actions.SetDevelopmentFields;

import actions.selenium.Browser
import actions.selenium.utils.Elements
import actions.selenium.Click

class SetDevMultiChoice{
    public static void run(def params){
        if(params."Field Value"){
            println("Multi Choice answer: ${params."Field Value"}")
            def label = Elements.findAll(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//LABEL",Browser.Driver)
            def index = 0
            label.eachWithIndex{element, i ->
                if(index!=0) {return} //value found
                println("Multi Choice options: ${element.getText()}")
                if(element.getText().contains(params."Field Value")){
                    index = i+1
                    println("We found it, index : ${index}")    
                }
            }
            Click.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT[@class='development-radio'][${index.toString()}]")
        }
    }
}