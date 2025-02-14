package actions.ShareDialog;

import actions.selenium.*

class SetShareDialog{
    public void run(def params){
        
        if(params."Access Share Dialog"==true){
            Click.run(ID:"//*[@id='f-share-dialog-btn']")   
        }
        
        if(params."Tab"){
            Click.run(ID:"//*[@class='f-tab']//*[text()='${params."Tab".toLowerCase()}']")
        }
        
        if(params."Done"==true){
            Click.run(ID:"//*[@data-test='modal-footer-submit']")   
        }
    }
}