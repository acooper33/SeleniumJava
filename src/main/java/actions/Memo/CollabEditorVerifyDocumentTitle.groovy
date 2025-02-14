package actions.Memo;

import actions.selenium.VerifyText

class CollabEditorVerifyDocumentTitle{
    public void run(def params){
        if(params.'Expected Title'){VerifyText.run(ID:"//SPAN[contains(@class,'f-memo-title')]", Text:params.'Expected Title')}
        if(params."Expected Status"){VerifyText.run(ID:"//DIV[contains(@class,'f-status-indicator')]", "Contains Text":params."Expected Status")}
    }
}