package actions.Search;

import actions.selenium.Click
import actions.selenium.MouseOver

class SetAdminbuttonsorAccessIteminRecentlyViewedList{
    public void run(def params){

        Click.run(ID:"//*[@id='global-search-input']")
        def path = "//*[@class='item-title' and text()='${params.Item}']"
        sleep(3000)
        MouseOver.run(ID:"${path}")
        switch(params."Access Admin Button"){
            case "Go to Submission":
            Click.run(ID:"${path}/../../..//*[contains(@data-for,'submission-tooltip')]","Type of Click":"Javascript")
            sleep(3000)
            break
            case "Go to Team Workspace":
            Click.run(ID:"${path}/../../..//*[contains(@data-for,'workspace-tooltip')]","Type of Click":"Javascript")
            break
            case "Go to Site Homepage":
            Click.run(ID:"${path}/../../..//*[contains(@data-for,'webstorm-initiative-tooltip')]","Type of Click":"Javascript")
            break
            case "Go to Pipeline Steps":
            Click.run(ID:"${path}/../../..//*[contains(@data-for,'webstorm-steps-tooltip')]","Type of Click":"Javascript")
            break
        }
        if(params."Access Item"==true){
            Click.run(ID:"${path}")
        }
    }
}