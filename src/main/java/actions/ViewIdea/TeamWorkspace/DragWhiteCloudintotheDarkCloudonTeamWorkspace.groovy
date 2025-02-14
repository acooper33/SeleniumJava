package actions.ViewIdea.TeamWorkspace;

import actions.selenium.DragAndDrop
import actions.selenium.MouseOver
import actions.selenium.Browser
import actions.selenium.SwitchToFrame
import actions.selenium.utils.Elements


class DragWhiteCloudintotheDarkCloudonTeamWorkspace{
    public void run(def params){
        //SwitchToFrame.run(Index:'0') //switching to the iframe with clouds 
        MouseOver.run(ID:"//*[contains(@class,'drag-cloud')]")
        DragAndDrop.run("From ID":"//*[contains(@class,'drag-cloud')]", "To ID":"//*[contains(@class,'drop-cloud')]")
        
        
        sleep(2000)
        
        
    }
}