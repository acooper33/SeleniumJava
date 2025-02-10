package actions.Whiteboards;

import actions.selenium.Exists


class VerifyTimerWhiteboards{
    public void run(def params){
        if(params."Timer Should be Present"==false){
            assert Exists.run(ID:"//*[class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]")==0, "Error - Timer is present"
        }else{
            if(params."Timer Should be Running, Paused, Initialized or Minimilized"){
                def state = 'timer-' + params."Timer Should be Running, Paused, Initialized or Minimilized"
                println("State of the timer - > ${state}")
                assert Exists.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-top-bar-right')]/DIV[contains(@class,'${state}')]")>0, "Error - Timer is not present or in the wrong state"
            }else{
                assert Exists.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]")>0, "Error - Timer is not present"
            }
            if(params."Minutes Value"){
                assert Exists.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]//*[@class='f-timer-clock']//INPUT[@value='${params."Minutes Value"}']")>0, "Error - Timer minutes are wrong"
            }
            if(params."Timer Set By"){
                assert Exists.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]//*[contains(@class,'f-timer-footer')]/P[contains(.,'${params."Timer Set By"}')]")>0, "Error - Timer Set By wrong"
            }
        }
    }
}