package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.Exists
import actions.selenium.ExecuteJavascript
import java.io.*
import actions.selenium.Browser
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement

class SetWebstormSetupIdeasforSubmissionFormTab{
    public void run(def params){
        
        def positionOfdoneButton
        if (Exists.run(ID:"//*[@id='ideas_tab']")>0){
            SetupCommon.NavigateTab(Tab:"Ideas",Section:"Submission Form")
            Click.run(ID:"//*[@id='edit-idea']")
        }
        if(params."Title Question Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Title']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")
            SetText.run(ID:"//*[@id='title_question_title']", Text:params."Title Question Title", "Type of Clear":"Clear")
            if(params."Title Placeholder Text"){SetText.run(ID:"//*[@id='title_placeholder_text']", Text:params."Title Placeholder Text")}
            if(params."Title Similar Ideas Section"){SetText.run(ID:"//*[@id='title_similar_ideas']", Text:params."Title Similar Ideas Section")}
            Click.run(ID:"//*[@id='doneButton']")
       }
        if(params."Image Question Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Image']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")
            SetText.run(ID:"//*[@id='image_question_title']", Text:params."Image Question Title")
            Click.run(ID:"//*[@id='doneButton']")
        }        
        if (params."Submitter Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Submitter']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")
            SetText.run(ID:"//*[@id='submitter_question_title']", Text:params."Submitter Title")
            if(params."Submitter Individual Submitter Text"){SetText.run(ID:"//*[@id='individual_submitter_text']", Text:params."Submitter Individual Submitter Text")}
            if(params."Submitter Team Submitter Text"){SetText.run(ID:"//*[@id='team_submitter_text']", Text:params."Submitter Team Submitter Text")}
            if(params."Submitter Team Info Banner"){SetText.run(ID:"//*[@id='team_info_banner']", Text:params."Submitter Team Info Banner")}
            if(params."Submitter Team Placeholder Text"){SetText.run(ID:"//*[@id='team_placeholder_text']", Text:params."Submitter Team Placeholder Text")}
            if(params."Submitter Anonymous Submitter Text"){SetText.run(ID:"//*[@id='anonymous_submitter_text']", Text:params."Submitter Anonymous Submitter Text")}
            if(params."Submitter Anonymous Info Banner") {SetText.run(ID:"//*[@id='anonymous_info_banner']", Text:params."Submitter Anonymous Info Banner")}
             Click.run(ID:"//*[@id='doneButton']")
		}        
        if(params."Description Question Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Description']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")           
            SetText.run(ID:"//*[@id='description_question_title']", Text:params."Description Question Title")
            Click.run(ID:"//*[@id='doneButton']")
        }
        if(params."Attachments Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Attachments']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")           
            //Click.run(ID:"//*[@class='labelContainer']//*[contains(text(),'Attachments')]/../a[contains(text(),'Edit')]")
            SetText.run(ID:"//*[@id='attachments_question_title']", Text:params."Attachments Title")
            Click.run(ID:"//*[@id='doneButton']")
        }
        if(params."Tags Question Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Tags']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")                       
            SetText.run(ID:"//*[@id='tags_question_title']", Text:params."Tags Question Title")
            if(params."Tags Placeholder Text") {SetText.run(ID:"//*[@id='tags_placeholder_text']", Text:params."Tags Placeholder Text")}
            if(params."Tags Help Text") {SetText.run(ID:"//*[@id='tags_similar_ideas']", Text:params."Tags Help Text")}
            Click.run(ID:"//*[@id='doneButton']", "Type of Click":"Javascript")
        }
        if(params."Category Question Title"){
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Category']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")                       
			SetText.run(ID:"//*[@id='category_question_title']", Text:params."Category Question Title")
            if(params."Category Default Text"=="<EMPTY>") {SetText.run(ID:"//*[@id='category_placeholder_text']", Text:params."Category Default Text", "Type of Clear":"Clear")}
            else{SetText.run(ID:"//*[@id='category_placeholder_text']", Text:params."Category Default Text")}
            Click.run(ID:"//*[@id='doneButton']", "Type of Click":"Javascript")
        }
        if(params."Additional Question Name"){
            println("Adding a Question")
            sleep(2000)
            Click.run(ID:"//*[@id='addQuestionsButton']","Type of Click":"Javascript")
            sleep(3000)
            SetText.run(ID:"//*[contains(@id,'question_description')]", Text:params."Additional Question Name")
            sleep(2000)
            SetCheckBox.run(ID:"//*[@id='devFieldCheckBox']",Check:params."Development Field")
            sleep(2000)
            SelectItem.run(ID:"//SELECT[@id='viewingPermissions']","Value":params."Viewing Permissions")
            if(params."Additional Question Type"){SelectItem.run(ID:"//select[contains(@id, 'questionTypeDropdown')]", "Visible Text":params."Additional Question Type")}
            
            WebElement doneElement = Elements.find(ID:"//BUTTON[@id='doneButton']",Browser.Driver)
            positionOfdoneButton = doneElement.getLocation().getY()
            ExecuteJavascript.run(Code:"window.scrollTo(0, ${positionOfdoneButton-100});")
            if(params."Additional Question Answers"){
                def removed
                removed = 0
                params."Additional Question Answers".split(",").eachWithIndex{value, x ->
                    if(x<3){SetText.run(ID:"(//DIV[contains(@class,'f-question-example')]//INPUT[starts-with(@id,'submission_answer')])[${x+1-removed}]", Text:value)}  
                    else{
                        boolean success = false
        				def y = 200
            			while(!success && y < 3000){
                try{
                    	Click.run(ID:"//BUTTON[contains(., 'Add Response')]") 
                        SetText.run(ID:"(//DIV[contains(@class,'f-question-example')]//INPUT[starts-with(@id,'submission_answer')])[${x+1-removed}]", Text:value)
                    success=true    
                }
                catch(Exception e){
                    println("Exception caught: ${e}")
                    ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                    y+=100
                }
            }
                    }
                    if(params."Additional Question Answers Actions".split(",")[x]=="Remove"){
                        Click.run(ID:"(//DIV[contains(@class,'f-question-example')]//BUTTON[starts-with(@class,'f-question-remove-btn')])[${x+1-removed}]", "Type of Click":"Javascript")
                        removed++
                    }                  
                }
            }
            if(params."Additional Question Tooltip"){SetText.run(ID:"//*[contains(@id, 'question_tooltip')]", Text:params."Additional Question Tooltip")}
            //need to scroll to the required checkbox sometimes
            boolean success = false
        	def y = 200
            while(!success && y<3000){
                try{
                    SetCheckBox.run(ID:"//INPUT[@class='f-question-checkbox' and @name='required']", Check:params."Additional Question Required")
                    SetCheckBox.run(ID:"//INPUT[@class='f-question-checkbox' and @name='administrator']",Check:params."Administrator Only")
                    success=true    
                }
                catch(Exception e){
                    println("Exception caught: ${e}")
                    ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                    y+=100
                }
            }
            SetCheckBox.run(ID:"//DIV[contains(@class,'f-question-row')]/P[contains(.,'Allow Multiple Selection')]/../INPUT", Check:params."Additional Question Allow Multiple User Selection")
            Click.run(ID:"//BUTTON[@id='doneButton']","Type of Click":"Javascript")
            sleep(2000)
         }
        //aded here
        if(params."Expertise Question Title"){            
            Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='Expertise Required']/../../DIV[contains(@class,'f-question-header-actions')]//*[contains(@class,'f-btn-standard f-btn-combined-right') and normalize-space()='Edit']")                       
			SetText.run(ID:"//*[@id='expertise_question_title']", Text:params."Expertise Question Title")
            if(params."Expertise Placeholder Text") {SetText.run(ID:"//*[@id='expertise_placeholder_text']", Text:params."Expertise Placeholder Text")}
            if(params."Expertise Help Text") {SetText.run(ID:"//*[@id='expertise_similar_ideas']", Text:params."Expertise Help Text")}
            Click.run(ID:"//*[@id='doneButton']", "Type of Click":"Javascript")
       }
        if(params."Save Form"){Click.run(ID:"//*[@id='saveFormButton']")}
        sleep(2000)
     }
}