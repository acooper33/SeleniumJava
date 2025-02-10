package actions.PipelineStepsView;

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import actions.selenium.Browser
import actions.selenium.Click
import actions.selenium.GetText

class SetUnMergeIdeasInPipelineStepsList{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']", "Type of Click":"Javascript")
        Click.run(ID:"//*[contains(@id,'action-un')]")
        if(params."Verify Parents:"){
            def elements = Elements.findAll(ID:"//DIV[@class='unmerge-ideas']/UL/LI/DIV[contains(.,'Parent')]/SPAN", Browser.Driver)
            def parentIdeas = params."Verify Parents:"
            def i=0
            elements.each{el -> 
                assert (GetText.run(Element:el).equals(parentIdeas[i])), "Error: ${GetText.run(Element:el)} not equal ${parentIdeas[i]}"
                i++
            }
        }
        if(params."Verify Children:"){
            if(params."Verify Children:" == "None"){
                def elements = Elements.findAll(ID:"//DIV[@class='unmerge-ideas']/UL/LI/DIV[contains(.,'Child')]/SPAN", Browser.Driver)
                assert (elements.size()==0), "Error - Unexpected Child Ideas Present"
            }else{
                def elements = Elements.findAll(ID:"//DIV[@class='unmerge-ideas']/UL/LI/DIV[contains(.,'Child')]/SPAN", Browser.Driver)
            	def childIdeas = params."Verify Children:"
            	def i=0
            	elements.each{el -> 
                	assert (GetText.run(Element:el).equals(childIdeas[i])), "Error: ${GetText.run(Element:el)} not equal ${childIdeas[i]}"
                	i++
            	}
            }
        }
        if(params."Click on URL for idea"){
            Click.run(ID:"//DIV[@class='unmerge-ideas']/UL/LI/SPAN/SPAN[contains(text(), '${params."Click on URL for idea"}')]/../A")
        }
        if(params.Action=="Un-Merge Ideas"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        if(params.Action=="Cancel"){Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
    }
}