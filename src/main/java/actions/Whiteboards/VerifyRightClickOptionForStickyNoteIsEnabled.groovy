package actions.Whiteboards;

import actions.selenium.Exists

class VerifyRightClickOptionForStickyNoteIsEnabled{
    public void run(def params){
        if(params."Menu Option".contains("Bring") || params."Menu Option".contains("Send")){
            if(params."Is Enabled"==false){
            	assert Exists.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[@class='f-disabled']/SPAN[.='${params."Menu Option"}']")==1, "Error - ${params."Menu Option"} is clickable even though it should not be"
        	} else {
            	assert Exists.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled'))]/SPAN[.='${params."Menu Option"}']")==1, "Error - ${params."Menu Option"} is not clickable even though it should be"
        	}
        }else{
            if(params."Is Enabled"==false){
            	assert Exists.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[@class='f-disabled' and .='${params."Menu Option"}']")==1, "Error - ${params."Menu Option"} is clickable even though it should not be"
        	} else {
            	assert Exists.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and .='${params."Menu Option"}']")==1, "Error - ${params."Menu Option"} is not clickable even though it should be"
        	}
        }
    }
}
