package actions.ProjectRoom;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetFocus
import actions.Whiteboards.SendKeysToWhiteboard

import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class ProjectRoomAddTaskNote{
    public void run(def params){
        
        try{
            SetFocus.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]") 
        }catch (Exception e){
            System.out.println("Comment modal did not load. Retrying...")
			sleep(3000)
            Refresh.run()
       		SetFocus.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]")
        }
        
        SetText.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]",Text:params.Note,"Type of Clear":"None")
        
        if(params.Action){Click.run(ID:"//*[@class='f-flyover-note-input-actions']//button[.='${params.Action}']")}}
}