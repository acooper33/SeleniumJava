package actions.Widgets;

import actions.selenium.*

class SetRichTextWidgetEditor2{
    public void run(def params){
       
        if(params."Click on Edit Icon"==true){
            Click.run(ID:"//*[contains(@class,'widget_container rich_texthtml_redactor_widget')]//*[@class='widget_title_text' and text()='${params."Widget Title"}']/../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
        }
        if(params."Text"){
            if(params."Click on Input Field"==null || params."Click on Input Field"==true){
                SetFocus.run(ID:"//*[contains(@id,'_redactor')]/../DIV[2]")
            }            
            SetText.run(ID:"//*[contains(@id,'_redactor')]/../DIV[2]",Text:params."Text","Type of Clear":"None")
            sleep(3000)
        }
        if(params."Action"){
            Click.run(ID:"//*[contains(@class,'f-edit-redactor-widget-action-btns')]//*[text()='${params."Action"}']")
        }        
    }
}