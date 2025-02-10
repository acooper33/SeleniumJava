package actions.Whiteboards;

import actions.selenium.SetReactModal

class SetWhiteboardAddLinkDialog{
    public void run(def params){
        if(params.URL){
            SetReactModal.setModalWithOneInputField(Text:params.URL)
        }
        sleep(3000)
        if(params.Action){
            SetReactModal.setModalActionButton("Modal xPath":"//DIV[contains(@class,'link-modal')]", Action:params.Action) 
        }
    }
}