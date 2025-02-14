package actions.PostIdea;

import actions.selenium.*
import org.openqa.selenium.*
import actions.selenium.utils.*
import actions.general.VerifyMessage


class VerifySubmissionFormLabelsonPostIdea{
    public void run(def params){
        //Anna: test
        if(params."Title Question Title"){VerifyText.run(ID:"//*[@id='idea_title']/legend",Text:params."Title Question Title")}
        if (params."Title Placeholder Text"){
            assert Exists.run(ID:"//*[@id='idea-form-title-input']//input[@placeholder='${params."Title Placeholder Text"}'][1]")>0, "Error - Title Placeholder Text is not '${params."Title Placeholder Text"}'"
        }
        if(params."Title Similar Ideas Section"){
            VerifyText.run(ID:"//*[@id='idea-form-title-similar']//legend", Text:params."Title Similar Ideas Section")
        }
		
        if(params."Image Question Title"){VerifyText.run(ID:"//*[@class='f-file-upload-title']", Text:params."Image Question Title")}
        if(params."Submitter Title"){VerifyText.run(ID:"//*[@id='idea-form-submitter']/legend", Text:params."Submitter Title")}
        if(params."Submitter Individual Submitter Text"){VerifyText.run(ID:"//*[@id='idea-form-submitter']//select/option[@value='yourself']", Text:params."Submitter Individual Submitter Text")}
        if(params."Submitter Team Submitter Text"){VerifyText.run(ID:"//*[@id='idea-form-submitter']//select/option[@value='team']", Text:params."Submitter Team Submitter Text")}
        if(params."Submitter Team Info Banner"||params."Submitter Team Placeholder Text"){
            if(params."Submitter Team Info Banner"){VerifyText.run(ID:"//*[@id='idea-form-submitter-warning']/div[@class='error']/p", Text:params."Submitter Team Info Banner")}
            if(params."Submitter Team Placeholder Text")
            {
                assert Exists.run(ID:"//*[@id='idea-form-submitter-user-select']//input[@class='input-tags-typeahead tt-input form-control' and @placeholder='${params."Submitter Team Placeholder Text"}']")>0, "Error - Title Placeholder Text is not '${params."Submitter Team Placeholder Text"}'" 
            }
        }
        if(params."Submitter Anonymous Submitter Text"){VerifyText.run(ID:"//*[@id='idea-form-submitter']//select/option[@value='anonymous']", Text:params."Submitter Anonymous Submitter Text")}
        if(params."Submitter Anonymous Info Banner"){
            VerifyText.run(ID:"//*[@id='idea-form-submitter-warning']/div[@class='error']/p", Text:params."Submitter Anonymous Info Banner")
        }
        if(params."Description Question Title"){VerifyText.run(ID:"//*[@id='idea_description']/legend", Text:params."Description Question Title")}
        if(params."Attachments Title"){VerifyText.run(ID:"//*[@id='idea-form-upload-zone']/legend", Text:params."Attachments Title")}
        if(params."Tags Question Title"){VerifyText.run(ID:"//*[@id='idea-form-tags']/legend", Text:params."Tags Question Title")}
        if(params."Tags Placeholder Text"){
            assert Exists.run(ID:"//*[@id='idea-form-tags']//input[@class='input-tags-typeahead tt-input form-control' and @placeholder='${params."Tags Placeholder Text"}']")>0,"Error - Tags Placeholder Text is not '${params."Tags Placeholder Text"}'"
        }
        if(params."Tags Help Text"){VerifyText.run(ID:"//*[@id='idea-form-tags']//p[@class='hint']", Text:params."Tags Help Text")}
        if(params."Category Question Title"){VerifyText.run(ID:"//*[@id='idea-form-category']/legend", Text:params."Category Question Title")}
        if(params."Category Default Text"){VerifyText.run(ID:"//*[@id='idea-form-category']//select/option[1]", Text:params."Category Default Text")}
        if(params."Expertise Question Title"){VerifyText.run(ID:"//*[@id='idea-form-expertise']/legend", Text:params."Expertise Question Title")}
        if(params."Expertise Placeholder Text"){
            assert Exists.run(ID:"//*[@id='idea-form-expertise']//*[@class='input-tags-typeahead tt-input form-control' and @placeholder='${params."Expertise Placeholder Text"}']")>0, "Error - Expertise Placeholder Text is not '${params."Expertise Placeholder Text"}'"
        }
        if(params."Expertise Help Text"){VerifyText.run(ID:"//*[@id='idea-form-expertise']//p[@class='hint']", Text:params."Expertise Help Text")}
        if(params."Additional Question Name"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]")>0, "Error - Additional Question Name is not what expected"}
        
        
        if(params."Additional Question Type"){
            if(params."Additional Question Type"=="Multiple Choice"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@class='radio']")>0, "Error - Additional Question is not Multi Choice"}
            if(params."Additional Question Type"=="Checkbox"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@class='checkbox']")>0, "Error - Additional Question is not Checkbox"}
            if(params."Additional Question Type"=="Short Answer"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@type='text']")>0, "Error - Additional Question is not Short Answer"}
            if(params."Additional Question Type"=="Long Answer"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@class='redactor-box']")>0, "Error - Additional Question is not Long Answer"}
            if(params."Additional Question Type"=="Dropdown"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//select")>0, "Error -Additional Question is not Checkbox" }
            if(params."Additional Question Type"=="Date"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@class='date-wrap']")>0, "Error -Additional Question is not Date"}
            if(params."Additional Question Type"=="Number"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@type='text']")>0, "Error -Additional Question is not Number"}
            if(params."Additional Question Type"=="User Selection"){assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/..//*[@class='user-select-wrap']")>0, "Error -Additional Question is not User Selection"}
            }
        if(params."Additional Question Tooltip"){
            assert Exists.run(ID:"//*[contains(@class,'set-section question-section')]//legend[contains(text(),'${params."Additional Question Name"}')]/I[contains(@data-original-title,'${params."Additional Question Tooltip"}')]")>0, "Error with tooltip"
        }
    }
}