package actions.SetupEnterpriseCommunities;

import actions.selenium.*

class NavigateCommunity{
    public void run(def params){
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        Click.run(ID:"//*[@id='navbar']//A[text()='${params."Community Page"}']")
    }
}