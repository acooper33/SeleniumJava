package actions.PostIdea;

import actions.selenium.Click

class SetActiononDiscardModal{
    public void run(def params){
       sleep(1000)
        if(params.Action){
            if(params.Action=="Discard"){
                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
            } else {
               Click.run(ID:"//*[@id='clickToConfirmCancelButton']")
            }
        }
        sleep(3000)
    }
}