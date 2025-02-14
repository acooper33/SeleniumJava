package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class SetTabUserHomepage{
    public void run(def params){
        switch(params."Tab"){
            case "Highlights":
            	Click.run(ID:"//UL[@class='f-tabs']/LI/A/I/SPAN[text()='Highlights']/../..")
            	break
            case "Activities":
            	Click.run(ID:"//UL[@class='f-tabs']/LI/A/I/SPAN[text()='Activities']/../..")
            	break
            case "Ideas":
            	Click.run(ID:"//UL[@class='f-tabs']/LI/A/I/SPAN[text()='Ideas']/../..")
            	break
            case "Submissions":
            	Click.run(ID:"//UL[@class='f-tabs']/LI/A/I/SPAN[text()='Submissions']/../..")
            	break
            case "Projects":
            	Click.run(ID:"//UL[@class='f-tabs']/LI/A/I/SPAN[text()='Projects']/../..")
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