package actions.Memo;

import actions.selenium.VerifyText
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class CollabEditorVerifyText{
    public void run(def params){
        //println("Should exist or not: ${params."Should Text Exist"}")
        if(params."Should Text Exist"==false){assert (verifyText(params) == false), "Error - Text Should Not Exist"}
        else{assert (verifyText(params) == true), "Error - Expected Text Not Found"}
    }
    
    private boolean verifyText (def params){
        def ExpectedTexFound = false
        def textValue
        String fontStyle
        
        List <WebElement> allPars = Elements.findAll(ID:"//DIV[@role='textbox']//P",Browser.Driver)
        if(params."Contains Text (only verifies text & color!)"){
            allPars.eachWithIndex{ par, i ->
                textValue = new String( new StringBuffer(par.getText()))
                println("Our text from paragraph is ${textValue}")
                if(textValue.replaceAll("[^a-zA-Z0-9.@\\-]", "").contains(params."Contains Text (only verifies text & color!)".replaceAll("[^a-zA-Z0-9.@\\-]", ""))){
                    fontStyle = par.getAttribute("innerHTML").replace('&quot;','').toLowerCase().replace(' ','').replace('px','')
                    ExpectedTexFound = true
                    if(params."Font Color"){
                        if(!fontStyle.contains("color:${params."Font Color"}")){
                            ExpectedTexFound = false
                        }
                    } 
                }
            }
        }else{
            allPars.eachWithIndex{ par, i ->
            	textValue = new String( new StringBuffer(par.getText()))
            	println("Our text from paragraph is ${textValue}")
            	if(textValue.replaceAll("[^a-zA-Z0-9.@\\-]", "").equals(params."Expected Text".replaceAll("[^a-zA-Z0-9.@\\-]", ""))){
                	if(params."Align"){assert par.getAttribute('align').contains(params."Align"), "Error - Incorrect Align"}
            		fontStyle = par.getAttribute("innerHTML").replace('&quot;','').toLowerCase().replace(' ','').replace('px','')
            		println("Fontstyle: ${fontStyle}")
            		if(params."Text Font"){
           				def expFont = params."Text Font".toLowerCase().replace(' ','')
            			assert fontStyle.contains("font-family:${expFont}"),"Error - Unexpected Text Font"
        			}
            		if(params."Font Size"){assert fontStyle.contains("font-size:${params."Font Size"}"),"Error - Unexpected Font Size"}
            		if(params."Font Style"){assert fontStyle.contains("font-style:${params."Font Style"}"),"Error - Unexpected Font Style"}
        			if(params."Text Decoration"){assert fontStyle.contains("text-decoration:${params."Text Decoration"}"),"Error - Unexpected Text Decoration"}
        			if(params."Font Weight"){assert fontStyle.contains("font-weight:${params."Font Weight"}"),"Error - Unexpected Font Weight"}
        			if(params."Font Color"){assert fontStyle.contains("color:${params."Font Color"}"),"Error - Unexpected Font Color"}
            		ExpectedTexFound = true
            	}
            }
        }
        return ExpectedTexFound
	}
}