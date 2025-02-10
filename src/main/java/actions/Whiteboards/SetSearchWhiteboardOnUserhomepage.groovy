package actions.Whiteboards;

import actions.selenium.*
    
class SetSearchWhiteboardOnUserhomepage{
    public void run(def params){
        
        if(params."Clear Field"==true){
            Click.run(ID:"//*[contains(@class,'fractal-input fa-search')]/../I")
            sleep(3000)
        }
        if(params."Search Field"){
            SetText.run(ID:"//*[@id='f-canvas-search']",Text:params."Search Field")
            sleep(3000)
        }
    }
}
