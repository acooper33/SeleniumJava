package actions.ProjectRoom;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCombobox

class SetIdeaMemoorWhiteboardinProjectRoom{
    public void run(def params){
        
        if(params."Existing or New"){
            Click.run(ID:"//*[contains(@class,'f-rooms-add-main f-add-')]//*[contains(text(),'${params."Existing or New"}')]/..//INPUT/..")
        }
        if(params."Existing Idea or Whiteboard or Memo to Search"){
            SetCombobox.run(ID:"//*[@id='f-add-select']", Option:params."Existing Idea or Whiteboard or Memo to Search")
            sleep(1000)
        }
		SetText.run(Text:params."New Whiteboard or Memo Name",ID:"//*[@id='f-rooms-add-name']") 
         if(params.Action){
             if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-test='modal-footer-cancel']") 
             } else {
                Click.run(ID:"//*[@data-test='modal-footer-submit']")
                sleep(3000)
             }
        }
    }
}
