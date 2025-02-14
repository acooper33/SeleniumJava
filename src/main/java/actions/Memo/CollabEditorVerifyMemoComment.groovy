package actions.Memo;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import actions.selenium.ExplicitWait

class CollabEditorVerifyMemoComment{
    def verify = [:]
     
    public void run(def params){
        verify.IDChildren = [] 
        if(params."Click Open/Close Comments in Top Bar"){Click.run(ID:"//DIV[@class='f-memo-top-bar-right']//BUTTON[contains(@class,'f-comment-open-btn')]")}
        sleep(2000)
        if(params."Filtered Comment Count (if filter is on)"){
            def xpath = "//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'f-slate-comments-container-header')]//H3"
            WebElement filterHeader = Browser.Driver.findElement(By.xpath(xpath));
            println("Comment count in the header - ${filterHeader.getText()}")
            assert filterHeader.getText().contains(params."Filtered Comment Count (if filter is on)"), "Error - Filtered Comment Count is not what expected"
        }
        
        if(params."Comment to Verify"){
            if(params."Where to verify the comments?"=="Comment Popover Next to Document"){VerifyCommentPopover(params)}
        	else if(params."Where to verify the comments?"=="Dropdown List from Top Bar"){VerifyCommentInDropdownList(params)}
        	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        	VerifyNumberOfMatches.run(verify)
        }
    }
    
    private void VerifyCommentPopover(def params){
        if(params."Comment Count"){
            List<WebElement> commentsContainers = Browser.Driver.findElements(By.xpath("//*[contains(@class,'f-comment-popovers')]//DIV[@class='f-slate-comment']"))
            assert(commentsContainers.size()==params."Comment Count".toInteger()), "Error - actual comment count is ${commentsContainers.size()}, but expected ${params."Comment Count"}"
        }
            if(params."Placement Number (+1 if assigned)"){
            	verify.ID = "//*[contains(@class,'f-comment-popovers')]//DIV[@class='f-slate-comment' and position()='${params."Placement Number (+1 if assigned)"}']//DIV[@data-class='f-comment-body' and starts-with(.,'${params."Comment to Verify"}')]"              
            }else{
                verify.ID = "//*[contains(@class,'f-comment-popovers')]//DIV[@class='f-slate-comment']//DIV[@data-class='f-comment-body' and starts-with(.,'${params."Comment to Verify"}')]"
            }
            if(params."Commenter Name"){
                verify.IDChildren << "./../../../..//DIV[contains(@class,'f-slate-comment-user')]//A[.='${params."Commenter Name"}']"
            }
            if(params."Profile Pic"=="TRUE"){
                verify.IDChildren << "./../../../..//DIV[contains(@class,'f-slate-comment-user')]//DIV[@class='f-member-photo' and contains(@style, 'background-image: url')]"
            }
            if(params."Time"){
                //verify.IDChildren << "./../../../..//*[contains(@class,'f-slate-comment-date') and starts-with(.,'${params."Time"}')]"
                verify.IDChildren << "./../../../..//*[contains(@class,'f-slate-comment-date') and contains(.,'${params."Time"}')]"
            }
            if(params."Tagged Users"){
                params."Tagged Users".split(',').each{tag->
                    println("Verifying tag ${tag}")
                    verify.IDChildren << "./..//A[contains(.,'${tag}')]"
                }
            }
            if(params."Assigned to"){
                verify.IDChildren << "./../../../../../../../..//DIV[contains(@class,'f-slate-assigned-header')]//*[contains(.,'${params."Assigned to"}')]"
            }   
    }
    
    private void VerifyCommentInDropdownList(def params){
        def htmlClass = "f-slate-comments-container-shown" //default is parent comment
        if(params."Comment Count"){assert Exists.run(ID:"//DIV[contains(@class,'f-slate-all-comments-list')]/DIV[contains(@class,'f-slate-comments-container-header')]/H3[contains(.,'${params."Comment Count"}')]")==1, "Error - Invalid Comment Count"}
        	//if reply, need to expand from the parent comment and udpate htmlClass
        	if(params."Parent Comment (for verifying a reply)"){
            	def xpath = "//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'f-slate-comments-container-shown')]//DIV[@data-class='f-comment-body' and contains(.,'${params."Parent Comment (for verifying a reply)"}')]"
				if(params."Expand Replies"){Click.run(ID:"${xpath}/../../../..//DIV[contains(@class,'f-slate-comments-container-footer')]//*[contains(@class,'f-show-replies')]")}
        		htmlClass="f-slate-comment-shown"
        	}
            if(params."Placement Number (+1 if assigned)"){
                verify.ID="//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'${htmlClass}') and position()='${params."Placement Number (+1 if assigned)"}']//DIV[@data-class='f-comment-body' and contains(.,'${params."Comment to Verify"}')]"

            }else{
                verify.ID="//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'${htmlClass}')]//DIV[@data-class='f-comment-body' and contains(.,'${params."Comment to Verify"}')]"
            }
            if(params."Commenter Name"){
                verify.IDChildren << "./../../../..//DIV[@class='f-slate-comment-header']/DIV[@class='f-slate-comment-user']/A[contains(.,'${params."Commenter Name"}')]"
            }
            if(params."Profile Pic" == "TRUE"){
                verify.IDChildren << "./../../../..//DIV[contains(@class,'f-slate-comment-header')]//*[contains(@class,'f-member-image')]/DIV[@class='f-member-photo']"
            }
            if(params."Time"){
                verify.IDChildren << "./../../../..//SPAN[contains(@class,'f-slate-comment-date') and contains(.,'${params."Time"}')]"
            }
            if(params."Tagged Users"){
                params."Tagged Users".split(',').each{tag->
                    verify.IDChildren << "./../../../..//DIV[contains(@class,'f-slate-comment-input-body')]//A[contains(.,'${tag}')]"
                }
            }
            if(params."Marked As Resolved"){
                verify.IDChildren << "./../../../..//*[contains(@class,'f-slate-comments-container-footer')]/*[.='Marked as resolved']"
            }
            if(params."Assigned to"){
                WebElement assignedTo
                if(params."Placement Number (+1 if assigned)"){
                    assignedTo = Browser.Driver.findElement(By.xpath("//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'${htmlClass}') and position()='${params."Placement Number (+1 if assigned)"}']//DIV[@data-class='f-comment-body' and contains(.,'${params."Comment to Verify"}')]/../../../.././preceding-sibling::DIV[@class='f-slate-assigned-header']"))
                }else{
                    assignedTo = Browser.Driver.findElement(By.xpath("//DIV[contains(@class,'f-slate-all-comments-list')]//DIV[contains(@class,'${htmlClass}')]//DIV[@data-class='f-comment-body' and contains(.,'${params."Comment to Verify"}')]/../../../.././preceding-sibling::DIV[@class='f-slate-assigned-header']"))
                }
                assert (assignedTo.getText()=="Assigned to ${params."Assigned to"}"), "Error - Assigned to is wrong"
            }
        if(params."Back to Comments"){
            Click.run(ID:"//DIV[contains(@class,'f-slate-all-comments-list')]/DIV[@class='f-slate-comments-container-header']/DIV[@class='f-return-to-comments']")
        }
    }
}