package actions.general;

import actions.selenium.Click
//import actions.general.Navigate

class NavigateWebstormviaAdminBarOnly{
    public void run(def params){
        Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
        sleep(2000)
        switch(params."Area to Navigate to"){
            case "Site":
            	Click.run(ID:"//*[contains(@class,'fractal-dropdownPopout-popout-container')]//UL/LI[contains(@class,'nav-item')]/A/*[text()='Site']")
            	break
            case "Site Setup":
            	Click.run(ID:"//*[contains(@class,'fractal-dropdownPopout-popout-container')]//UL/LI[contains(@class,'nav-item')]/A/*[text()='Site Setup']")
            	break
            case "List":
				Click.run(ID:"//*[contains(@class,'backbone-link') and .='List']")
            	sleep(2000)
            	break 
            case "Steps":
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Steps']")
            	sleep(2000)
            	break
            case "Action Items Manager":
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Action Items Manager']")
            	sleep(4000)
            	break
            case "Dashboard":
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Dashboard']")
            	sleep(2000)
            	break
            case "Knowledge Base":
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Knowledge Base']")
            	sleep(2000)
            	break
            case "Pipeline Setup":
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Pipeline Setup']")
            	sleep(2000)
            	break
           case "Top Ideas":
            	Click.run(ID:"//*[contains(@class,'nav-item')]//I[contains(@class,'fa-star-christmas')]")
          }
    }
}