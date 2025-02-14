package actions.MTS;

import actions.selenium.*

class SetOneDriveForSystemAdmin{
    public void run(def params){
        
        if(params."Email Address"){
            sleep(2000)
            SetText.run(ID:"//*[@type='email']",Text:params."Email Address")
        }
        
        if(params."Type of 3rd Party Document"){
            if(params."Type of 3rd Party Document"=="Google"){
                sleep(2000)
                Click.run(ID:"//span[text()='Next']/..")
        } else {
            Click.run(ID:"//*[@type='submit']")
            }
        }
        if(params."Verify its you on Google"==true){
           Click.run(ID:"//*[@type='button' and .='Continue']") 
           //Click.run(ID:"//*[@type='button' and .='Allow']") 
        }
    }
}