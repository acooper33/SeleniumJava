package actions.ProjectRoom;

import actions.selenium.*
    
class VerifyFloatingModalinGateActionItem{
    public void run(def params){
        
        if(params."Due Date"){
            VerifyText.run(ID:"//*[contains(@class,'-pr-gate-popout-item ReactModal__Content')]//SPAN[contains(@class,'f-due-label')]","Contains Text":params."Due Date")
        }
        if(params."Message"){
            VerifyText.run(ID:"//*[contains(@class,'-pr-gate-popout-item ReactModal__Content')]//SPAN[contains(@class,'f-popout-completed')]",Text:params."Message")
        }
        if(params."Collapse or Expand"){
            if(params."Collapse or Expand"=="Collapse"){
                 assert Exists.run(ID:"//*[contains(@class,'-pr-gate-popout-item ReactModal__Content')]//*[contains(@class,'f-gate-container')]/DIV[2][contains(@class,'f-gate-body f-collapsed')]")==1, "Error - 'Modal expanded"    
            } else {
                assert Exists.run(ID:"//*[contains(@class,'-pr-gate-popout-item ReactModal__Content')]//*[contains(@class,'f-gate-container')]/DIV[2][not(contains(@class,'f-gate-body f-collapsed'))]")==1, "Error - 'Modal collapsed"
            }
        }        
    }
}