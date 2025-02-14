package actions.ProjectRoom;

import actions.selenium.Click

class NavigateRoomItems{
    public void run(def params){
        if(params."Room Item"){
            if(params."Room Page Row Number"){
                Click.run(ID:"//*[contains(@class,'f-rooms-sidebar-nav')]//LI[contains(@class,'f-room-item')][${params."Room Page Row Number"}]//SPAN[starts-with(.,'${params."Room Item"}')]")
            } else {
                Click.run(ID:"//*[contains(@class,'f-rooms-sidebar-nav')]//LI[contains(@class,'f-room-item')]//SPAN[starts-with(.,'${params."Room Item"}')]")
            }
        }
        if(params."Top Link"){Click.run(ID:"//*[contains(@class,'f-rooms-sidebar-nav')]//UL[contains(@class,'f-rooms-top-links')]//SPAN[starts-with(.,'${params."Top Link"}')]")}
    }
}