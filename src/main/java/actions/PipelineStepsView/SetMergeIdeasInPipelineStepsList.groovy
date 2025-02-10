package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.GetText
import actions.selenium.SetCheckBox
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import actions.selenium.utils.Elements

class SetMergeIdeasInPipelineStepsList{
    public void run(def params){
        
        Click.run(ID:"//*[@id='actions_dropdown']", "Type of Click":"Javascript")
        Click.run(ID:"//*[@id='action-merge']")
        sleep(1000)
        if (params."Verify Order of Ideas:"){
            def elements = Elements.findAll(ID:"//*[@class='merge-ideas']/DIV/LABEL/DIV/SPAN", Browser.Driver)
            def ideaTitles = params."Verify Order of Ideas:"
            def i=0
            elements.each{el -> 
                assert (GetText.run(Element:el).equals(ideaTitles[i])), "Error: ${GetText.run(Element:el)} not equal ${ideaTitles[i]}"
                i++
            }
        }
        if (params."Select Parent"){
            Click.run(ID:"//*[@class='merge-ideas']/DIV/LABEL/SPAN[contains(.,'${params."Select Parent"}')]")
        }
		if(params.Action=="Merge Ideas"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        if(params.Action=="Cancel"){Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
    }
}