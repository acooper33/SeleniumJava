package actions.Widgets;

import actions.selenium.*

class SetUserAvailabilityWidget{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='widget-admin-toggle-text-side' and text()='${params."Set User Availability"}']")==0){
            Click.run(ID:"//*[@class='widget-admin-toggle-text-side']")
        }
    }

}