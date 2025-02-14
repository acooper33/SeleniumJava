package actions.SetDevelopmentFields;

import actions.selenium.SelectItem

class SetDevDropdown{
    public static void run(def params){
        if(params."Field Value"){
            SelectItem.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//SELECT","Visible Text":params."Field Value")
        }
    }
}