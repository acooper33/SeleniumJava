package actions.ViewIdea30;

import actions.selenium.Click

class AccessIdeafromViewIdea3Modal{
    public void run(def params){
        
        if(params."Access Idea"){
            if(params."Access Idea" == "Modal Header") {
                Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//A")
            } else {
                Click.run(ID:"//*[contains(@class,'f-component f-idea-title')]//A")
            }
            sleep(2000)
        }
        if(params."Close Idea Modal" == true){
            Click.run(ID:"//*[@class='close-button']")
        }
    }
}