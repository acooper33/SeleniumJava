package actions.PipelineSidebar;

import actions.selenium.*

class AddRemoveFavoriteforPipelineinPipelineSidebar{
    public void run(def params){
        RightClick.run(ID:"//*[@id='sidebar-pipelines']//DIV[text()='${params."Pipeline Name"}']")
        if(params."Add or Remove Favorite"=="Add"){Click.run(ID:"//*[@id='right-click-menu-template']//DIV[text()='Mark as Favorite']")}
        else{Click.run(ID:"//*[@id='right-click-menu-template']//DIV[text()='Remove From Favorites']")}
        sleep(2000)
    }
}