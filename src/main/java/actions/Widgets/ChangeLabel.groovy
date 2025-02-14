package actions.Widgets;

import actions.selenium.*

class ChangeLabel{
    public void run(def params){
        Click.run(ID:"//*[@id='lbl_text' and text()='${params."Label to Change"}']")
        SetText.run(ID:"//*[@id='label_edit_input']",Text:params."New Label Value")
        Click.run(ID:"//*[@id='label_editor_popup']//BUTTON[1]")
    }
}