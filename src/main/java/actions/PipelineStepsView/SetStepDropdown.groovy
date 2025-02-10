package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetFocus
import org.openqa.selenium.StaleElementReferenceException;

class SetStepDropdown{
    public static void setDropdownOption(def params){
        try {
			SetFocus.run(ID:"//SPAN[@class='step_header_name' and normalize-space()='${params."Step Name"}']/../DIV[contains(@class,'img-dropdown')]")
		}catch (StaleElementReferenceException e){
			System.out.println("Stale element encountered. Retrying...")
			sleep(1000)
			SetFocus.run(ID:"//SPAN[@class='step_header_name' and normalize-space()='${params."Step Name"}']/../DIV[contains(@class,'img-dropdown')]")
		}
        Click.run(ID:"//SPAN[@class='step_header_name' and normalize-space()='${params."Step Name"}']/../DIV[contains(@class,'img-dropdown')]")
        sleep(500)
        Click.run(ID:"//SPAN[@class='step_header_name' and normalize-space()='${params."Step Name"}']/../..//*[starts-with(text(),'${params."Step Dropdown Option"}')]")

    }
}