package actions.Search;

import actions.selenium.Click
import actions.selenium.MouseOver

class QuickResultsSetAdminButton{
    public void run(def params){
        Click.run(ID:"//*[@id='global-search-input']")
        def path = "//*[@class='f-result-bold' and text()='${params."Quick Results Item"}']"
        sleep(3000)
        MouseOver.run(ID:"${path}")
        switch(params."Admin Button"){
            case "Submit":
            Click.run(ID:"${path}/../../..//*[contains(@id,'webstorm-submit')]","Type of Click":"Javascript")
            sleep(3000)
            break
            case "Team Workspace":
            Click.run(ID:"${path}/../../..//*[contains(@data-tooltip-id,'workspace-tooltip')]","Type of Click":"Javascript")
            break
            case "Site Homepage":
            Click.run(ID:"${path}/../../..//*[contains(@data-tooltip-id,'webstorm-initiative-tooltip')]","Type of Click":"Javascript")
            break
            case "Pipeline Steps":
            Click.run(ID:"${path}/../../..//*[contains(@data-tooltip-id,'webstorm-steps-tooltip')]","Type of Click":"Javascript")
            break
            case "Submission":
            Click.run(ID:"${path}/../../..//*[contains(@data-tooltip-id,'submission-tooltip')]","Type of Click":"Javascript")
            sleep(3000)
        }
    }
}