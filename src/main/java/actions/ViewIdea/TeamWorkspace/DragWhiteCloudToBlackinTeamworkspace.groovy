package actions.ViewIdea.TeamWorkspace;

import actions.selenium.DragAndDrop
import actions.common.TeamWorkspaceCommon

class DragWhiteCloudToBlackinTeamworkspace{
    public void run(def params){
        TeamWorkspaceCommon.NavigateTab(Tab:"Files")
        sleep(3000)
        DragAndDrop.run("From ID":"//*[@class='drag-cloud']", "To ID":"//*[@class='drop-cloud']")   
        
    }
}