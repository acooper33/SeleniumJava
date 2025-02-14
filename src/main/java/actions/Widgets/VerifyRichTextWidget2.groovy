package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyRichTextWidget2{
    public void run(def params){
    
        def verify = [:]
        verify.ID = "//*[contains(@class,'widget_title_text') and text()='${params."Widget Title"}']"        
        verify.IDChildren = []
        if(params."Body"){verify.IDChildren << "./../../../..//*[contains(@class,'fractal-htmlpreview redactor-styles')]//*[contains(text(),'${params."Body"}')]" }
        if(params."Image"==true){
            def img = "/..//img[contains(@src,'/ct/getfile')]"
            verify.IDChildren << "${img}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Click on Return to Editor"==true){
            Click.run(ID:"//*[contains(@class,'f-edit-redactor-widget-action-btns')]//*[text()='Return to Editor']")}
    }
}
