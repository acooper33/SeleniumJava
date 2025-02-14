package actions.Memo;

import actions.selenium.Exists

import actions.selenium.utils.Elements
import actions.selenium.Browser
import java.util.ArrayList
import org.openqa.selenium.WebElement

class CollabEditorVerifyImage{
    public void run(def params){
        //println("We are here")
        //if(params."Should Image Exist"){assert (Exists.run(ID:"//DIV[@role='textbox']//DIV//IMG[contains(@class,'image')]"))>0, "Error - Image not found"}
        //if(params."Should Image Exist"){assert (Exists.run(ID:"//DIV[@role='textbox']//DIV[contains(@class,'f-slate-image-container')]//IMG"))>0, "Error - Image not found"}
        
        //WebElement doc = Elements.find(ID:"//DIV[@role='textbox']//P//*[contains(@class,'f-slate-image-container')]//IMG",Browser.Driver)
        //println("InnerHTML: ${doc.getAttribute("innerHTML")}")
        
        if(params."Should Image Exist"){assert (Exists.run(ID:"//DIV[@role='textbox']//P//*[contains(@class,'f-slate-image-container')]//IMG"))>0, "Error - Image not found"}
        if(!params."Should Image Exist"){assert (Exists.run(ID:"//DIV[@role='textbox']//P//*[contains(@class,'f-slate-image-container')]//IMG"))==0, "Error - Unexpected image found"}
    }
}