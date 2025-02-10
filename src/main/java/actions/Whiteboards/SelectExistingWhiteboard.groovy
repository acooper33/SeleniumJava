package actions.Whiteboards;

import actions.selenium.Click

class SelectExistingWhiteboard{
    public void run(def params){
        switch(params."What List"){
            case "All Whiteboards":
            	Click.run(ID:"//*[contains(@class,'f-tabs-header')]/DIV[@class='f-tab'][1]")
				break
            case "My Whiteboards":
            	Click.run(ID:"//*[contains(@class,'f-tabs-header')]/DIV[@class='f-tab'][2]")
				break
            case "Shared with Me":
            	Click.run(ID:"//*[contains(@class,'f-tabs-header')]/DIV[@class='f-tab'][3]")
				break
            
           }
        if(params."Whiteboard Title"){
            Click.run(ID:"//*[@class='f-card-title-area']/H2[contains(text(),${params."Whiteboard Title"})]")
        }
    }
}