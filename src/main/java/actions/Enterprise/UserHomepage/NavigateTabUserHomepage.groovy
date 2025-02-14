package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class NavigateTabUserHomepage{
    public void run(def params){
        switch(params."Tab"){
            case "Highlights":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Highlights']/../..")
				break
            case "Activities":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Activities']/../..")
            	break
            case "Ideas":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Ideas']/../..")
            	break
            case "Whiteboards":
            case "My Whiteboards":
            	//Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Whiteboards']/../..")
                Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[contains(.,'Whiteboards')]")
            	break
            case "Submissions":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Submissions']/../..")
            	break
            case "Projects":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Projects']/../..")
            	break
            case "Memos":
            case "My Memos":
            	//Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[contains(.,'Memos')]/../..")
                Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[contains(.,'Memos')]")
            	break
            case "Pipeline":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Pipeline']/../..")
				break
            case "Action Items":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Action Items']/../..")
				break
            case "Project Room":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Project Room']/../..")
				break
            case "Backlog":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Backlog']/../..")
				break
            case "Home":
            	Click.run(ID:"//UL[contains(@class,'f-tabs')]/LI/A/SPAN[text()='Home']/../..")
				break
        }
        if(params."Expand Parent Helpful Link (if any)"){
            Click.run(ID:"//*[@class='fractal-widget-helpfulLinks']/UL/LI/DIV/SPAN[.='${params."Expand Parent Helpful Link (if any)"}']/following-sibling::BUTTON")
        }
        if(params."Select Helpful Link (or Child Helpful Link)"){
            Click.run(ID:"//*[@class='fractal-widget-helpfulLinks']//A/SPAN[.='${params."Select Helpful Link (or Child Helpful Link)"}']/..")
        }
    }
}