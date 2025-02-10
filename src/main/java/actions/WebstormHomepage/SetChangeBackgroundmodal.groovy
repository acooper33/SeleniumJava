package actions.WebstormHomepage;

import actions.selenium.*

class SetChangeBackgroundmodal{
    public static void run(def params){
        
        if (Exists.run(ID:"//*[@id='f-homepage-hero-buttons-image']")>=1){Click.run(ID:"//*[@id='f-homepage-hero-buttons-image']")} //this is used for Set Background Image, skip for whiteboard
        if(params."Tab"){
            Click.run(ID:"//*[contains(@class,'f-tab')]//*[text()='${params."Tab"}']")
        }     
    }
}