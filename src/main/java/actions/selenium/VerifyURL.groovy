package actions.selenium

import actions.selenium.Browser


class VerifyURL{
    public String run(def params){
        if(params.Value){
            assert Browser.Driver.getCurrentUrl() == params.Value, "Error: expected URL value ${params.Value} does not match URL displayed: ${Browser.Driver.getCurrentUrl()}"
        }
        
        if(params."Contains Value"){
            assert (Browser.Driver.getCurrentUrl()).contains(params."Contains Value"), "Error: expected URL value ${params.Value} does not contain URL displayed: ${Browser.Driver.getCurrentUrl()}"
        }

        if(params."Regular Expression"){
            assert Browser.Driver.getCurrentUrl() =~ /${params."Regular Expression"}/, "Error: expected URL reg expression ${params."Regular Expression"} does not match URL displayed: ${Browser.Driver.getCurrentUrl()}"
        }
        return Browser.Driver.getCurrentUrl()

    }
}