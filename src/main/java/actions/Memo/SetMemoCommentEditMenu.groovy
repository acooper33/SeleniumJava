package actions.Memo;

import actions.selenium.SetText
import actions.selenium.Click

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By


class SetMemoCommentEditMenu{
    public void run(def params){
        def xPath, xPathMenu, xPathMenuOption
        if(params."Click Open/Close Comments in Top Bar"){Click.run(ID:"//DIV[@class='f-memo-top-bar-right']//BUTTON[contains(@class,'f-comment-open-btn')]")}
        
        if(params."Where to edit the comments?"=="Comment Popover Next to Document"){
            xPath = "//*[contains(@class,'f-comment-popovers')]//DIV[@class='f-slate-comment']//DIV[@data-class='f-comment-body' and starts-with(.,'${params."What Comment to Edit"}')]"
        }
        else if(params."Where to edit the comments?"=="Dropdown List from Top Bar"){
        	xPath="//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'f-slate-comments-container-shown')]//DIV[@data-class='f-comment-body' and contains(.,'${params."What Comment to Edit"}')]"
        }
        if(params."Menu Option"){
            xPathMenu = xPath+"/../../../..//DIV[@data-test='f-test-dropdown']//I[contains(@class,'fa-ellipsis-h')]"
           	WebElement comment = Browser.Driver.findElement(By.xpath(xPath))
           	println("Our found comment: ${comment.getText()}")
            Click.run(ID:xPathMenu)
           	sleep(3000)
            xPathMenuOption = xPath+"/../../../..//UL[contains(@class,'f-dropdown-options') and (contains(@style, 'display: block'))]//*[starts-with(.,'${params."Menu Option"}')]"
            Click.run(ID:xPathMenuOption)
       	}
        if(params."Menu Option"=="Edit"){
            SetText.run(ID:"//DIV[contains(@id,'fractal-commenting-input')]", Text:params."Edited Comment")
            Click.run(ID:"//DIV[contains(@class,'f-slate-comment-input-container')]//BUTTON[contains(@class,'f-btn-primary')]")
        }
        sleep(1000)
       	if(params."Delete Action"=="Delete"){Click.run(ID:"//BUTTON[contains(@id,'clickToConfirmOkButton')]")} 
        if(params."Delete Action"=="Cancel"){Click.run(ID:"//BUTTON[contains(@id,'clickToConfirmCancelButton')]")}
        sleep(1000)
    }
}