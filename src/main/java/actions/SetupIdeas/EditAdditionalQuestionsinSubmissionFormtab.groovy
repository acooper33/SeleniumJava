package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.ExecuteJavascript
import java.io.*
import actions.selenium.Browser
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement

class EditAdditionalQuestionsinSubmissionFormtab{
    public void run(def params){
		boolean success = false
        def y = 200
        def screenHeight, position, positionOfButton, positionOfDependentCheckbox
        if (Exists.run(ID:"//*[@id='ideas_tab']")>0){
        	SetupCommon.NavigateTab(Tab:"Ideas",Section:"Submission Form")
        	Click.run(ID:"//*[@id='edit-idea']")        
        }
        
        def index;
        switch(params."Edit or Hide or Remove"){
            case 'Edit':
            	index = 1;
            	break;
            case 'Hide':
            	index = 2;
            	break;
            case 'Remove':
            	index = 7;
            	break;
        }
        
        screenHeight = (Browser.Driver).manage().window().getSize().getHeight();
        WebElement element = Elements.find(ID:"//*[contains(@class,'f-question-wrapper')]/DIV[contains(@class,'f-question-header')]/DIV/H3[starts-with(normalize-space(),'${params."Question"}')]",Browser.Driver)
        position = element.getLocation().getY()
        ExecuteJavascript.run(Code:"window.scrollTo(0, ${position-100});")
        Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[contains(normalize-space(),'${params."Question"}')]/../../DIV[contains(@class,'f-question-header-actions')]//DIV[contains(@class,'fractal-clickoutside')]")
        sleep(2000)
        Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style, 'display: block;')]/LI[${index}]");
            
        HandleWarningPopUp(params."Action on Edit, Hide or Remove")
        
        if(params."Edit or Hide or Remove"=="Edit"){
            SetCheckBox.run(ID:"//INPUT[contains(@id,'devFieldCheckBox')]",Check:params."Development Field")
            SelectItem.run(ID:"//SELECT[@id='viewingPermissions']","Value":params."Viewing Permissions")
            SetText.run(ID:"//INPUT[contains(@id, 'word_limit')]", Text:params."Word Limit")
            SetText.run(ID:"//INPUT[contains(@id,'question_description')]", Text:params."New Question Title")
            if(params.Body!=null){
                SetText.run(ID:"//*[contains(@class, 'redactor-in')]", Text:params.Body, "Type of Clear":"Cut")
            }
            if(params."Question Type"){
                SelectItem.run(ID:"//select[@id='questionTypeDropdown']", "Visible Text":params."Question Type")
            
            }
            sleep(2000)
            if(params."Question Answers"){
                def removed
                removed = 0
                params."Question Answers".split(",").eachWithIndex{value, x ->
                    if(x<3){SetText.run(ID:"(//DIV[contains(@class,'f-question-example')]//INPUT[starts-with(@id,'submission_answer')])[${x+1-removed}]", Text:value)}
                    else{
                        Click.run(ID:"//BUTTON[contains(., 'Add Question Item')]") 
                        //the input field for Additional Answer has a different xpath  
                        SetText.run(ID:"//INPUT[starts-with(@id,'submission_answer')and position()='${x+1-removed}']", Text:value)
                    }
                    if(params."Question Answers Actions".split(",")[x]=="Remove"){
                        Click.run(ID:"(//DIV[contains(@class,'f-question-example')]//BUTTON[starts-with(@class,'f-question-remove-btn')])[${x+1-removed}]")
                        removed++
                            }                  
                }
            }
            if(params."Tooltip"){SetText.run(ID:"//*[contains(@id, 'question_tooltip')]", Text:params."Additional Question Tooltip")}
            
            if(params."Set Dependent Answer"){
                WebElement dependentElement = Elements.find(ID:"//INPUT[@class='f-question-checkbox' and @name='dependent-answers']",Browser.Driver)
            	positionOfDependentCheckbox = dependentElement.getLocation().getY()
            	ExecuteJavascript.run(Code:"window.scrollTo(0, ${positionOfDependentCheckbox-50});")
   				SetCheckBox.run(ID:"//INPUT[@class='f-question-checkbox' and @name='dependent-answers']",Check:params."Set Dependent Answer")
            }
            
            SelectItem.run(ID:"//INPUT[@class='f-question-checkbox' and @name='dependent-answers']/../SELECT","Visible Text":params."Set Dependent Answer Dropdown")
            sleep(2000)
             success=false
            //scroll down more
            while(!success && y<screenHeight){
                try{
                    SetCheckBox.run(ID:"//INPUT[@class='f-question-checkbox' and @name='administrator']",Check:params."Administrator Only")
                    success=true    
                }
                catch(Exception e){
                    println("Exception caught: ${e}")
                    y+=200
                    ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                    
                }
            }
            success=false
            //scroll down more
            while(!success && y<screenHeight){
                try{
                    SetCheckBox.run(ID:"//INPUT[@class='f-question-checkbox' and @name='required']",Check:params."Required")
                    success=true    
                }
                catch(Exception e){
                    println("Exception caught: ${e}")
                    y+=200
                    ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                    
                }
            }
            if(params."Click on Done" == true || params."Click on Done" == null){
                WebElement doneElement = Elements.find(ID:"//BUTTON[@id='doneButton']",Browser.Driver)
                positionOfButton = doneElement.getLocation().getY()
                ExecuteJavascript.run(Code:"window.scrollTo(0, ${positionOfButton-50});")
                Click.run(ID:"//BUTTON[@id='doneButton']")
            }
        }
        if(params."Save Form"==true){Click.run(ID:"//*[@id='saveFormButton']","Type of Click":"Javascript")}
       
    }
    public static void HandleWarningPopUp(String action){
        if(action=="Cancel"){
            if(Exists.run(ID:"//*[@id='clickToConfirmCancelButton']")>0){Click.run(ID:"//*[@id='clickToConfirmCancelButton']")}
        }else if(action=="Submit"){
            if(Exists.run(ID:"//*[@id='clickToConfirmOkButton']")>0){Click.run(ID:"//*[@id='clickToConfirmOkButton']")}
        }
    }
}