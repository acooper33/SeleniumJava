package actions.SetIdeaFields;

import actions.selenium.SetText
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click
import org.openqa.selenium.WebElement
import actions.selenium.SetReactTags
import actions.selenium.Exists

class SetPostIdeaTag{
    public static void run(def params){
        if(params."Tag or User Name"){
            sleep(1000)
            if((Exists.run(ID:"//*[@id='idea-form-submitter-user-select']/DIV[1]//*[contains(@id,'f-user-reg-on-the-fly')]")>0) && params."Field Name"=="Submitter"){
                SetReactTags.setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide(User:params."Tag or User Name", "Add or Remove":params."Add or Remove", "Field Name":"Team Members")
            }else{
                params."Tag or User Name".split(",").eachWithIndex{ name, x ->
                    def xpath
                    if(params."Field Name"=="Submitter"){xpath="//*[@id='idea-form-submitter-user-select']/DIV[1]"}
                    else{xpath="//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV"}
                    if(params."Add or Remove".split(",")[x]=="Add"){
                        SetText.run(ID:xpath+"//DIV[1]/SPAN[contains(@class,'twitter-typeahead')]/INPUT[2]",Text:name)
                        sleep(2000)
                        // for linked submissions, the option contains the idea code, but the search would not work with the idea code
                        if(params."Field Name".toLowerCase().contains("submissions") || params."Field Name".toLowerCase().contains("ideas")){
                            Click.run(ID:xpath+"//*[contains(@class,'tt-menu tt-open')]//*[contains(text(),'${name}')]","Type of Click":"Javascript")
                        }else{
                            Click.run(ID:xpath+"//*[contains(@class,'tt-menu tt-open')]//*[starts-with(text(),'${name}')]","Type of Click":"Javascript")
                        }
                    }
                    else{
                        Click.run(ID:xpath+"//DIV[1]/SPAN[text()='${name}']/SPAN[@data-role='remove']")
                    }
                }
        	}
        }
    }
}
