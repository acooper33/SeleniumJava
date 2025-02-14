package actions.Memo;

import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetFocus
import actions.selenium.SendKeys
import actions.selenium.SendKeyboardAction
import actions.selenium.DoubleClick
import org.openqa.selenium.Keys
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

class CollabEditorAddComment{
    public void run(def params){
        def xPath
        if(params."Click Open/Close Comments in Top Bar"){Click.run(ID:"//DIV[@class='f-memo-top-bar-right']//BUTTON[contains(@class,'f-comment-open-btn')]")}
        sleep(3000)
        if(params."Parent or Reply"=="Parent"){
            xPath = "//DIV[contains(@class,'f-slate-comment-input-container')]/DIV[contains(@class,'f-slate-comment-input-body')]//DIV[contains(@id,'fractal-commenting-input')]"
        	println("Setting text: ${params."Comment"}")
            SetFocus.run(ID:xPath)
            SetText.run(ID:xPath, Text:params."Comment")
            sleep(2000)
            if(params."Tag Usernames"){SetTag(params."Tag Usernames", params."Tag Email", xPath, params."Assign to Username")}
        }else if(params."Parent or Reply"=="Reply Via Container Next to Doc"){
            xPath = "//DIV[contains(@class,'f-comment-popovers')]/DIV[contains(@class,'f-slate-comment-thread-popover')]//DIV[contains(@class,'fractal-clickoutside')]//DIV[@data-class='f-comment-body' and contains(text(),'${params."Reply To Comment"}')]"
            Click.run(ID:xPath)
            sleep(500)
            def replyxPath = xPath+"/../../../../../../..//DIV[contains(@class,'f-comment-input-textarea')]"
            SetText.run(ID:replyxPath, Text:params."Comment")
            if(params."Tag Usernames"){SetTag(params."Tag Usernames", params."Tag Email", replyxPath, params."Assign to Username")}
        }else if(params."Parent or Reply"=="Reply Via Comments in Header"){
            sleep(500)
            xPath = "//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[@class='f-slate-all-comments-scroll']//DIV[contains(@class,'f-slate-comment-shown')]//DIV[@class='f-slate-comment-input-container']//DIV[@data-class='f-comment-body' and contains(text(),'${params."Reply To Comment"}')]"     
            def replyTo = xPath+"/../../../../..//DIV[contains(@class,'footer')]/SPAN"
            def textInput = xPath+"/../../../../..//DIV[contains(@class,'f-slate-comment-input-container')]//DIV[starts-with(@id,'fractal-commenting-input')]"
            Click.run(ID:replyTo)
            sleep(500)
            SetText.run(ID:textInput, Text:params."Comment") 
            if(params."Tag Usernames"){SetTag(params."Tag Usernames", params."Tag Email", textInput, params."Assign to Username")}
        }else{
            SetText.run(ID:"//DIV[contains(@class,'f-comment-input-textarea')]", Text:params."Comment")
            if(params."Tag Usernames"){SetTag(params."Tag Usernames", params."Tag Email", "//DIV[contains(@class,'f-comment-input-textarea')]", params."Assign to Username")}
        }
        sleep(1000)
        if(params.Action=="Comment"){Click.run(ID:"//DIV[contains(@class,'f-slate-comment-input-container')]//BUTTON[contains(@class,'f-btn-primary')]")}
        if(params.Action=="Cancel"){Click.run(ID:"//DIV[contains(@class,'f-slate-comment-input-container')]//BUTTON[contains(@class,'f-btn-subtle')]")}
        sleep(10000)
    }
    
    public static void SetTag(def tags, def emails, def xPath, def assignTo){
        def tag1
        def eachEmail = emails.split(",")
        def eachTag = tags.split(",")
        for (int i=0; i<eachTag.size(); i++){
        	tag1 = " @"+eachTag[i]
            println("Each tag: ${tag1}")
            println("Tags size: ${eachTag.size()}")
            SetFocus.run(ID:xPath)
           	SetText.run(ID:xPath, Text:tag1, "Type of Clear":"None")
            sleep(1000)
            Click.run(ID:"//*[contains(@class,'f-comment-input-tagging-panel')]//*[contains(@class,'f-comment-input-memberlist-name') and (contains(text(),'${eachTag[i]}') or contains(text(), '${eachEmail[i]}'))]")
        }
        if(assignTo!=null){
            if(eachTag.size()>1){
               	Click.run(ID:"//DIV[@class='f-slate-assign-lockup']//*[contains(@id,'f-slate-assign-comment')]")
                sleep(500)
                Click.run(ID:"//DIV[@class='f-slate-assign-lockup']//UL[@class='f-dropdown-options']/LI/SPAN[starts-with(.,'${assignTo}')]")
            }
        Click.run(ID:"//INPUT[@id='f-slate-assign-comment']/../.")    
        }   
    }
}