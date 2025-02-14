package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Browser
import actions.selenium.DragAndDrop
import actions.selenium.Exists
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.SendKeys

class FilterIdeainIdeaBoardpage30{
    public void run(def params){
        
        sleep(2000)
        if(params."Open/Close Filter Bar"=="Close"){
            Click.run(ID:"//*[@id='ideaboard-filter-button-sidebar' and contains(@class,'active')]")
        }
        else if(params."Open/Close Filter Bar"=="Open"){
            Click.run(ID:"//*[@id='ideaboard-filter-button-sidebar' and not(contains(@class,'active'))]")
        }
        if(params."Expand Tags Filter"){
            Click.run(ID:"//*[@class='tab-header-title' and text()='Tags']/..//I") 
        }
        if(params."Expand Admin Tags Filter"){
            Click.run(ID:"//*[@class='tab-header-title' and text()='Admin Tags']/..//I") 
        }
        if(params."Search"){
            SetText.run(ID:"//*[@id='filter-search']", Text:"${params.Search}")
            SendKeys.run(ID:"//*[@id='filter-search']", Key:"ENTER")
        }
        if(params."Status"){
            params."Status".each{Click.run(ID:"//DIV[@class='filter-status']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-status')]")}
        }
        if(params."Stage"){
            params."Stage".each{Click.run(ID:"//DIV[@class='filter-stage']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-stage')]" )}
        }
        if(params."Categories"){
            params."Categories".each{Click.run(ID:"//DIV[@class='filter-category']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id,'filter-category')]")}
        }
        if(params."Tags"){
            params."Tags".each{
                //Click.run(ID:"//*[starts-with(@id, 'filter-tags')]/following-sibling::LABEL/*[text()='${it}']/../../input[@type='checkbox']")
				Click.run(ID:"//*[starts-with(@id, 'filter-tags')]/following-sibling::LABEL/*[contains(translate(., '${it.toUpperCase()}', '${it}'), '${it}')]/../../input[@type='checkbox']")
            }
        }
        if(params."Admin Tags"){
            params."Admin Tags".each{Click.run(ID:"//*[starts-with(@id, 'filter-admin_labels')]/following-sibling::LABEL/*[text()='${it}']/../../input[@type='checkbox']")}
        }
        if(params."Search Desired Expertise" || params."Desired Expertise"){
            if(Exists.run(ID:"//*[@id='filter-tag-search-Expertise Required']")==0){
                Click.run(ID:"//*[@class='tab-header-title' and text()='Expertise Required']/..//I")}
        }
        if(params."Search Desired Expertise"){SetText.run(ID:"//*[@id='filter-tag-search-Expertise Required']", Text:params."Search Desired Expertise")}
        if(params."Desired Expertise"){
            params."Desired Expertise".each{Click.run(ID:"//*[starts-with(@id, 'filter-expertise')]/following-sibling::LABEL/*[text()='${it}']/../../input[@type='checkbox']")}
        }
        if(params."My Favorites"){
            if(params."My Favorites"== true){Click.run(ID:"//input[@id='filter-is_favorite' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV")} 
            if(params."My Favorites"== false){Click.run(ID:"//input[@id='filter-is_favorite' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV")} 
        }

        if(params."My Votes"){
            if(params."My Votes"== true){Click.run(ID:"//input[@id='filter-my_voted_ideas' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV")} 
            if(params."My Votes"== false){Click.run(ID:"//input[@id='filter-my_voted_ideas' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV")} 
            sleep(3000)
        }

        if(params."New To Me"){
            if(params."New To Me"== true){Click.run(ID:"//input[@id='filter-ihaveviewed' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
            if(params."New To Me"== false){Click.run(ID:"//input[@id='filter-ihaveviewed' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        }

        if (params."Investment To-Date Min"){
            DragAndDrop.run("From ID":"//div[@class='filter-cost']//*[@role='slider'][1]", "To ID":"//div[@class='filter-cost']//*[@class='rc-slider-mark']/span[text()='${params."Investment To-Date Min"}']") //min slider

        }
        if (params."Investment To-Date Max"){
            DragAndDrop.run("From ID":"//div[@class='filter-cost']//*[@role='slider'][2]", "To ID":"//div[@class='filter-cost']//*[@class='rc-slider-mark']/span[text()='${params."Investment To-Date Max"}']")

        }
        if (params."Projected Benefit Min"){
            DragAndDrop.run("From ID":"//div[@class='filter-benefit']//*[@role='slider'][1]", "To ID":"//div[@class='filter-benefit']//*[@class='rc-slider-mark']/span[text()='${params."Projected Benefit Min"}']")
        }
        if (params."Projected Benefit Max"){
            DragAndDrop.run("From ID":"//div[@class='filter-benefit']//*[@role='slider'][2]", "To ID":"//div[@class='filter-benefit']//*[@class='rc-slider-mark']/span[text()='${params."Projected Benefit Max"}']") 
        }
        if(params."My Submissions"){
            if(params."My Submissions"== true){Click.run(ID:"//input[@id='filter-my_submissions' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
            if(params."My Submissions"== false){Click.run(ID:"//input[@id='filter-my_submissions' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        }
        if(params."My Subscriptions"){
            if(params."My Subscriptions"== true){Click.run(ID:"//input[@id='filter-my_subscriptions' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
            if(params."My Subscriptions"== false){Click.run(ID:"//input[@id='filter-my_subscriptions' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        }
        if(params."My Open Evaluations"){
            if(params."My Open Evaluations"== true){Click.run(ID:"//input[@id='filter-my_open_evaluations' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        	if(params."My Open Evaluations"== false){Click.run(ID:"//input[@id='filter-my_open_evaluations' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        	sleep(2000)
        }
        if(params."My Completed Evaluations"){
            if(params."My Completed Evaluations"== true){Click.run(ID:"//input[@id='filter-my_completed_evaluations' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
            if(params."My Completed Evaluations"== false){Click.run(ID:"//input[@id='filter-my_completed_evaluations' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        }
        if(params."My Applications"){
            if(params."My Applications"== true){Click.run(ID:"//input[@id='filter-my_applications' and @value='false']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
            if(params."My Applications"== false){Click.run(ID:"//input[@id='filter-my_applications' and @value='true']/..//*[contains(@class,'f-toggle-label')]/DIV", "Type of Click":"Javascript")}
        }
        if (params."Action"=="Reset Filters"){
            Click.run(ID:"//*[contains(@class,'ideaboard-filter-clear')]")
        }
        
        sleep(10000)       
    }
}

