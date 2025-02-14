package actions.PostIdea;

import actions.selenium.Click

class SetChooseImageinPostIdea{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-upload-modal-dropzone']")
        
    }
}