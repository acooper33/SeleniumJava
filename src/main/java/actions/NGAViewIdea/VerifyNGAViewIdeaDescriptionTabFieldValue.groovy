package actions.NGAViewIdea;

import actions.selenium.*
import actions.common.*

class VerifyNGAViewIdeaDescriptionTabFieldValue{
    public static void run(def params){
        if(params."Field Value"){
            sleep(500)
        	if(Exists.run(ID:"//*[@id='desc' and contains(@class,'unselected')]")>0){
            	println("Will click Description tab")
            	NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        	}
        	if(params."Field Value"=="Video"){
                assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]//IFRAME[contains(@src,'www.youtube.com') or contains(@src,'vimeo.com')]","Timeout":20)>0,"Error - Video for field ${params."Field Name"} not found"
            }
            else{VerifyText.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]","Contains Text":params."Field Value")}
        }
    }
}