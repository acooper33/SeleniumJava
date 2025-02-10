package actions.common;

import actions.selenium.*
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetRedactorToolbarOptions{
    public void run(def params){
        
        def xpath
        switch(params."Field"){
            case "Post Idea Description":
                xpath = "//*[contains(@id,'idea-form-description')]"
            	break
             case "Post Idea Long Ans":
                xpath = "//*[contains(@class,'set-section question-section')]/.."
            	break
            case "Evaluation Reordering Email":
                xpath = "//*[contains(@class,'f-email-evals-body-container')]/.."
            	break
            case "Rick Text Widget 2.0":
                xpath = "//*[contains(@id,'rich-text-html-redactor-widget')]"
            	break
            case "Challenge Brief Widget":
                xpath = "//*[contains(@id,'homepage')]"
            	if(Exists.run(ID:"//*[@id='homepage-htmlpreview-brief']")>0){
                    println("hello")
             		Click.run(ID:"//*[@id='homepage-htmlpreview-brief']")
                    sleep(2000)
                }
            	break
        }
       Click.run(ID:xpath+"//*[contains(@class,'redactor-toolbar') and contains(@style,'block')]/A[@aria-label='${params."Toolbar Option"}']")
       sleep(2000)
        if(params."Dropdown Option"){
            Click.run(ID:"//*[contains(@id,'redactor-dropdown') and contains(@style,'block')]//*[contains(@class,'redactor-dropdown-item')]/*[contains(text(),'${params."Dropdown Option"}')]/..")
        }
        if(params."Image or File to Upload"){
            def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Image or File to Upload"}"
        	//Now send a file to the 'fallback_input' element
            SendKeys.run(ID:"//*[@class='redactor-modal open']//*[.='${params."Toolbar Option"}']/..//INPUT[@type='file']", Text:fileName)
            if(params."Wait for file or image to load"==true){
                sleep(7000)    
            }       	        
        }
        if(params."Dropdown Option"=="Insert Link"){
            SetText.run(ID:"//*[@id='modal-link-url']",Text:params."Insert Link URL")  
            SetText.run(ID:"//*[@id='modal-link-text']",Text:params."Insert Link Text")
            if(params."Insert Link Open link in new tab"==true){
                SetCheckBox.run(ID:"//input[@name='target']",Check:params."Insert Link Open link in new tab")
            }
            if(params."Insert Link Action"){
                Click.run(ID:"//button[@data-command='${params."Insert Link Action".toLowerCase()}']")
            }
       }
        if(params."Font Color For Text or Highlight"){
            Click.run(ID:"//span[contains(@class,'redactor-dropdown-not-close') and contains(text(),'${params."Font Color For Text or Highlight"}')]")              	        
        }
        if(params."Font Color"){
            Click.run(ID:"//div[contains(@class,'re-dropdown-box-')]//span[@rel='${params."Font Color"}']")              	        
        }
    }
}