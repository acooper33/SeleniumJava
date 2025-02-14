package actions.People;

import actions.common.PeopleCommon
import actions.common.AppsCommon
import actions.selenium.Click

class SetWhiteboardLicenseUser{
    public void run(def params){
        
        if(params."Expand License Breakdown"== true || params."Expand License Breakdown"== null){
            PeopleCommon.ExpandLicenseBreakdown(License:"Whiteboard License Type")
        } 
       
        if(params."Click on Add License"==true){
            Click.run(ID:"//*[contains(@class,'f-wb-license-btn')]")
        }
        
        if(params."User"){
            AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Add License",User:params."User","Add or Remove":params."Users Add or Remove from Input Field")
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
        }
        
        if(params."Action on Add License Modal"=="Add"){
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
        }
        
       if(params."Remove User"){
           Click.run(ID:"//*[@class='f-wb-col f-wb-unlimited']/preceding-sibling::LI//A[text()='${params."Remove User"}']/..//I")
           sleep(2000)
           if(params."Remove Licensed User Action"){
               if(params."Remove Licensed User Action"=="Remove"){
                  Click.run(ID:"//*[@data-test='modal-footer-submit']") 
               } else {
                   Click.run(ID:"//*[@data-test='modal-footer-cancel']") 
               }
           }
       }
    }
}
           