package actions.Whiteboards;

import actions.selenium.Exists

class VerifyWhiteboardTitle{
    public void run(def params){
        
        sleep(9000)
        if(params."Title"){
            assert Exists.run(ID:"//*[contains(@class,'f-canvas-name') and .='${params."Title"}']") == 1,"Error - Incorrect Title displayed"
        }
        if(params."Title Starts With"){
            assert Exists.run(ID:"//*[contains(@class,'f-canvas-name') and starts-with(.,'${params."Title Starts With"}')]") == 1,"Error - Title Starts With Unexpected"
        }
    }
}