package actions.ViewIdea3Fields;

import actions.selenium.VerifyText
import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.Browser


class VerifyViewIdea3DescriptionTabFieldValue{
    public void run(def params){
        sleep(5000)
        def path
        
        if(params."Template"=="Memo Record"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-memo-record')]"
        }else if(params."Template"=="Small Header"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-modern-small')]"
        } else if(params."Template"=="Large Header"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-modern-large')]"       
        } else {
            //path = "//*[@class='f-idea-page-main']//*[contains(@class,'-medium')]"
            path = "//*[@class='f-idea-page-main' and //*[contains(@class,'-medium')]]"  
        }
        if(params."Should Exist"){
            //WebElement tool = Elements.find(ID:"${path}//*[contains(@class,'f-component-title') and contains(.,'${params."Field Name"}')]/../..//*[text()='${params."Field Value"}']",Browser.Driver)
            List <WebElement> tool = Elements.findAll(ID:"${path}//*[contains(@class,'f-component-title') and contains(.,'${params."Field Name"}')]/../..//*[text()='${params."Field Value"}']",Browser.Driver)
            //println("Text: ${tool.getText()}")
            println("Size: ${tool.size()}")
            assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and starts-with(normalize-space(.),'${params."Field Name"}')]/../..//*[text()='${params."Field Value"}']")>0,"Expected Field Not Found"
        }else{
            assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and starts-with(normalize-space(.),'${params."Field Name"}')]/../..//*[text()='${params."Field Value"}']")==0,"Unexpected Field Found"
        }
    	
        /*
        
        
        if(params."Type of Question"=="Response Questions"){
            if(params."Position Number"){
                VerifyText.run(ID:"//*[contains(@class,'f-question-wrapper')][${params."Position Number"}]//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[@data-test='f-test-dropdown']//*[contains(@class,'fractal-htmlpreview')]/DIV","Text":params."Field Value")
            } else {
                VerifyText.run(ID:"//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[@data-test='f-test-dropdown']//*[contains(@class,'fractal-htmlpreview')]/DIV","Text":params."Field Value")
            }
        } else if(params."Type of Question"=="Date"){
            if(params."Position Number"){
                assert Exists.run(ID:"//*[contains(@class,'f-question-wrapper')][${params."Position Number"}]//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[contains(@class,'react-datepicker__input-container')]/INPUT[@value='${params."Field Value"}']")==1,"Error - Incorrect Date displayed in the field"
            } else {
                assert Exists.run(ID:"//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[contains(@class,'react-datepicker__input-container')]/INPUT[@value='${params."Field Value"}']")==1,"Error - Incorrect Date displayed in the field"
            }
        } else {
            if(params."Position Number"){
                VerifyText.run(ID:"//*[contains(@class,'f-question-wrapper')][${params."Position Number"}]//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[contains(@class,'fractal-htmlpreview')]/DIV","Text":params."Field Value")
            } else {
            VerifyText.run(ID:"//*[@class='f-component-title f-question-description' and starts-with(.,\"${params."Field Name"}\")]/../..//*[contains(@class,'fractal-htmlpreview')]/DIV","Text":params."Field Value")
            }
        }*/
    }
}
 
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

      