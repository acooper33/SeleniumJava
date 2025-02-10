package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Exists
import actions.selenium.SetCombobox
import java.lang.Character;

class NewMoveIdeasinPipelineStepspage{
    public void run(def params){
        //may be used in Rules config modal as well
        if(Exists.run(ID:"//*[@id='actions_dropdown']")>0){
            Click.run(ID:"//*[@id='actions_dropdown']")
        }
        if(Exists.run(ID:"//*[@id='action-change_ws']")>0){
            Click.run(ID:"//*[@id='action-change_ws']")
        }
        if(params."Move To Pipeline"){
        	SetCombobox.run(ID:"//*[@id='move-idea-combobox']", Option:params."Move To Pipeline")
        }
        
        if(params."Category"){
             SetCombobox.run(ID:"//*[@class='f-move-idea-category-dropdown-container']//*[@id='select-category-combobox']", Option:params."Category", "Type of Clear":"Cut")
            
        }
        if(params."Status"){
            SetCombobox.run(ID:"//*[@class='f-move-idea-status-dropdown-container']//*[@id='select-category-combobox']", Option:params."Status", "Type of Clear":"Cut")  
            
        }
        SetCheckBox.run(ID:"//*[@id='checkbox-appendExtraSubmissionQuestions']", Check:params."Append extra submission questions to description")
        SetCheckBox.run(ID:"//*[@id='checkbox-notifySubmitter']", Check:params."Notify submitter(s)")
        sleep(2000)
        
        if(params."Missing Development Question Field"){
         assert Exists.run(ID:"//*[@class='f-missing-dev-question-warning-message-wrapper' and .='${params."Missing Development Question Field"} Development fields from this initiative are missing in the destination initiative. The data for these fields will not be moved. Learn more about Development Fields.']")==1, "Error - Development Field count is wrong"  
        }
        
        if(params.Action=="Move Idea"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@data-test='modal-footer-cancel']")}              
    }
    private static boolean containsEmoji(String str) {
    int length = str.length();

    for (int i = 0; i < length; i++) {
      int type = Character.getType(str.charAt(i));
      if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
        return true;
      }
    }

    return false;
  }
}