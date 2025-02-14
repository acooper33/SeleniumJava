package actions.SetupIdeas;

import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.Browser

class SetWebstormSetupBusinessModelforIdeasTab {
    public void run(def params){
        if(params."Navigate to Business Model Tab"){SetupCommon.NavigateTab(Tab:"Ideas",Section:"Team Workspace")}        
        //if(params."Launch Business Model Form Builder"){Click.run(ID:"//*[text()='Launch Business Model Form Builder...']")}
		//SetupCommon.NavigateTab(Tab:"Ideas",Section:"Team Workspace")
        if(params."Launch Business Model Form Builder"){Click.run(ID:"//*[@id='view-editor-link']")}
        
        if(params."Navigate to New Tab"==true){
            def windowHandles = new ArrayList(Browser.Driver.getWindowHandles())
            if (windowHandles.size() > 1) {
    			// Get the index of the current window handle
    			def currentHandle = Browser.Driver.getWindowHandle()
    			def currentIndex = windowHandles.indexOf(currentHandle)
				// Calculate the index of the next tab
    			def nextIndex = currentIndex + 1
				// If the next index exceeds the number of handles, wrap around to the first tab
                if (nextIndex >= windowHandles.size()) {
        			nextIndex = 0
                	}
                def newTabHandle = windowHandles[nextIndex]
				Browser.Driver.switchTo().window(newTabHandle)
            }
        }
        if(params."Field to Edit"){
          def ID = "//*[@class='business-model-editor-question']//*[@class='question-name' and text()='${params."Field to Edit"}']"
          Click.run(ID:ID+"/../A[@class='edit-link']")
          if(params."Question Title"){SetText.run(ID:ID+"/../..//*[contains(@class,'fractal-input text-input')]/label[text()='Question Title:']/../input", Text:params."Question Title")}
          if(params."Question Default Text"){SetText.run(ID:ID+"/../..//*[contains(@class,'fractal-input text-input')]/label[text()='Question Default Text:']/../input", Text:params."Question Default Text")}
          if(params.Action=="Done"){Click.run(ID:ID+"/../..//*[@class='bottom']/button")}
          if(params."Form Action"=="Save Form"){Click.run(ID:"//*[@id='f-save-form-btn']")}
          sleep(2000)
        }
   	}
} 