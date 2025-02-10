package actions.WebstormHomepage;

import actions.selenium.*

class SetColorofSubmitbuttononHomepageHeader2{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-color-picker-group')][2]")
        SetText.run(ID:"//*[contains(@id,'rc-editable-input')]", Text:params."Color", "Type of Clear":"Cut")
    }
}