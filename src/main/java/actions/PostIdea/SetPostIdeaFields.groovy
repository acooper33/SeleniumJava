package actions.PostIdea;

import actions.SetIdeaFields.SetPostIdeaAction
import actions.SetIdeaFields.SetPostIdeaAttachment
import actions.SetIdeaFields.SetPostIdeaCheckbox
import actions.SetIdeaFields.SetPostIdeaDropdown
import actions.SetIdeaFields.SetPostIdeaImage
import actions.SetIdeaFields.SetPostIdeaRadioButton
import actions.SetIdeaFields.SetPostIdeaTag
import actions.SetIdeaFields.SetPostIdeaTextField
import actions.SetIdeaFields.SetPostIdeaUserSelection
import actions.selenium.ExplicitWait
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.ExecuteJavascript

class SetPostIdeaFields{
    public void run(def params){
        if(params."Wait for Page to Load" == true){
           ExplicitWait.run(ID:"//*[@id='form-section']") 
        }
        //idea title question
        SetPostIdeaTextField.run("Field Name":params."Idea Title Question - Title","Field Value":params."Idea Title Question - Value")
        //Description
        SetPostIdeaTextField.run("Field Name":params."Description Question - Title","Field Value":params."Description Question - Value")
        //Image Question
        SetPostIdeaImage.run("Field Name":params."Image Question - Title","Image File":params."Image File","Crop or Cancel":params."Image Crop or Cancel")
        //Attachments
        SetPostIdeaAttachment.run("Field Name":params."Idea Attachment Question - Title", "Attachment File":params."Idea Attachment Question - Value", "Add or Remove":params."Idea Attachment Add or Remove")
        //tags
        SetPostIdeaTag.run("Field Name":params."Tags Question - Title","Tag or User Name":params."Tags Question - Value","Add or Remove":params."Tag Add or Remove")
        //Category
        SetPostIdeaDropdown.run("Field Name":params."Category Question - Title","Field Value":params."Category Question - Value")
        //Checkbox
        SetPostIdeaCheckbox.run("Field Name":params."Checkbox Question - Title","Checkbox Name":params."Checkbox Question - Value","Check":params."Checkbox Check")
        //Date
        SetPostIdeaTextField.run("Field Name":params."Date Question - Title","Field Value":params."Date Question - Value")
        //Number Question
        SetPostIdeaTextField.run("Field Name":params."Number Question - Title","Field Value":params."Number Question - Value")
        //Multiple Choice
        SetPostIdeaRadioButton.run("Field Name":params."Multiple Choice - Title","Field Value":params."Multiple Choice - Value")
        //Dropdown
        SetPostIdeaDropdown.run("Field Name":params."Dropdown Question - Title","Field Value":params."Dropdown Question - Value")
        //Short Answer
        SetPostIdeaTextField.run("Field Name":params."Short Answer - Title","Field Value":params."Short Answer - Value")
        //Long Answer
        SetPostIdeaTextField.run("Field Name":params."Long Answer - Title","Field Value":params."Long Answer - Value")
        //User Selection
        SetPostIdeaTag.run("Field Name":params."User Selection - Title","Tag or User Name":params."User Selection - Value","Add or Remove":params."User Selection Question Add or Remove")
        //Whiteboard
        SetPostIdeaTag.run("Field Name":params."Whiteboard - Title","Tag or User Name":params."Whiteboard - Value","Add or Remove":params."Whiteboard Add or Remove")
        //Linked Submissions
        SetPostIdeaTag.run("Field Name":params."Linked Submissions - Title","Tag or User Name":params."Linked Submissions - Value","Add or Remove":params."Linked Submissions Add or Remove")
        sleep(2000)
        SetPostIdeaAction.run("Action":params."Action")
        if(params."Title With Emoji"){
            println("Start Setting TextForEmoji")
            def text = params.'Title With Emoji'//"🌎 🌊 " + u'\u2764' //
            def code = """
                var elm = arguments[0];
				elm.innerHTML = ${text};
                elm.dispatchEvent(new Event('change'));
                """

            WebElement element = Elements.find(ID:"//*[@id='idea-form-title-input']",Browser.Driver)
            println("Code: ${code}")
            ExecuteJavascript.run(Code:code, Arguments: element);
            println("Finished Setting TextForEmoji")
        }
    }
}