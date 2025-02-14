package actions.ShareDialog;

import actions.selenium.*

class VerifyLicenseTypeofUsersinShareDialogFields{
    public void run(def params){
    
        switch(params."License Type"){
                case "Brightidea User":
            		assert Exists.run(ID:"//*[contains(@class,'f-brightidea-user')]//*[text()='${params."User"}']") == 1,"Error - Incorrect License Type Displayed for this User"
                    break
                case "Brightidea Administrator":
           	 		assert Exists.run(ID:"//*[contains(@class,'f-admin')]//*[contains(text(),'${params."User"}')]") == 1,"Error - Incorrect License Type Displayed for this User"
                    break
                case "Idea Box Manager":
            		assert Exists.run(ID:"//*[contains(@class,'f-idea-box-bg-color')]//*[text()='${params."User"}']") == 1,"Error - Incorrect License Type Displayed for this User"
                    break
                case "No License":
            		assert Exists.run(ID:"//*[normalize-space(@class)='f-tag-wrapper react-tags__selected-tag']//*[contains(text(),'${params."User"}')]") == 1,"Error - Incorrect License Type Displayed for this User"
                    break
        }
    }
}