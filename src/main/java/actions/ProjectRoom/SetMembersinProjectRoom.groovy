package actions.ProjectRoom;

import actions.common.AppsCommon
import actions.selenium.Click
import actions.selenium.SetReactTags

class SetMembersinProjectRoom{
    public void run(def params){
        
        if(params."Member"){
            //AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"",User:params."Member","Add or Remove":params."Member Add or Remove")
            SetReactTags.setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide("Field Name":"",User:params."Member","Add or Remove":params."Member Add or Remove")
        	Click.run(ID:"//*[contains(@class,'f-btn-sm f-send-invite')]")
        }
        if(params."Copy Link"){
            Click.run(ID:"//*[@class='f-copy-link']/BUTTON")
        }        
    }
}