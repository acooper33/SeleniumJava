package actions.Utils;

import actions.selenium.Browser

class NavigateToSystemManager{
    public String run(def params){
        
       def systemManagerLink
       if((redwood.launcher.Launcher.variables.URL).contains("sandbox")){
          systemManagerLink = "https://www.brightideasandbox.com/systemManager"
       } else {
           systemManagerLink = "https://www.brightideatest.com/systemManager"
       }
        return systemManagerLink
    }
}