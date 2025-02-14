package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.DragAndDrop

class SetGlobalIdeaFilterBIW{
    public void run(def params){
        if(params."Invoke Filter"==true){
            Click.run(ID:"//BUTTON[@id='f-biw-filter-btn']")
            println("Clicked on Filter")
        }
        if(params."Expand/Collapse Tags Filter"=="Expand"){
            Click.run(ID:"//DIV[@id='filter-tab-tags']//I[contains(@class,'fa-plus-square-o')]") 
        }
        else if(params."Expand/Collapse Tags Filter"=="Collapse"){
            Click.run(ID:"//DIV[@id='filter-tab-tags']//I[contains(@class,'fa-minus-square-o')]") 
        }
        if(params."Search"){
            SetText.run(ID:"//*[@id='filter-search']", Text:"${params.Search}")
        }
        if(params."Object Type"){
            params."Object Type".each{Click.run(ID:"//DIV[@id='filter-tab-object_type']/..//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-object_type')]")}
        }
        if(params."Status"){
            params."Status".each{Click.run(ID:"//DIV[@id='filter-tab-status']/..//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-status')]")}
        }
         if(params."Stage"){
            params."Stage".each{Click.run(ID:"//DIV[@id='filter-tab-stage']/..//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-stage')]")}
        }
         if(params."Step"){
            params."Step".each{Click.run(ID:"//DIV[@id='filter-tab-step']/..//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-step')]")}
        }
        if(params."Category"){
            params."Category".each{Click.run(ID:"//DIV[@id='filter-tab-category']/..//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id,'filter-category')]")}
        }
        if(params."Owner"){
            params."Owner".each{
                SetText.run(ID:"//*[@id='filter-tag-search-Owner']",Text:it, "Type of Clear":"Cut")
                Click.run(ID:"//*[text()='${it}']/../../Input")}
        }
        if (params."Score Min"){
            DragAndDrop.run("From ID":"//div[@class='filter-inline-input f-filter-score']//*[@role='slider'][1]", "To ID":"//div[@class='filter-inline-input f-filter-score']//*[@class='rc-slider-mark']/span[text()='${params."Score Min"}']") //min slider
        }
        if (params."Score Max"){
            DragAndDrop.run("From ID":"//div[@class='filter-inline-input f-filter-score']//*[@role='slider'][2]", "To ID":"//div[@class='filter-inline-input f-filter-score']//*[@class='rc-slider-mark']/span[text()='${params."Score Max"}']")
        }
        if (params."Latest Review Score Min"){
            DragAndDrop.run("From ID":"//div[@class='filter-memo-score']//*[@role='slider'][1]", "To ID":"//div[@class='filter-memo-score']//*[@class='rc-slider-mark']/span[text()='${params."Latest Review Score Min"}']") //min slider
        }
        if (params."Latest Review Score Max"){
            DragAndDrop.run("From ID":"//div[@class='filter-memo-score']//*[@role='slider'][2]", "To ID":"//div[@class='filter-memo-score']//*[@class='rc-slider-mark']/span[text()='${params."Latest Review Score Max"}']")
        }
        if(params."Tags"){
            params."Tags".each{Click.run(ID:"//*[@class='filter-tag']//LABEL[@class='filter-label']/SPAN[text()='${it}']/../../input[@type='checkbox']")}
        }

        if(params."Favorites"== true){Click.run(ID:"//input[@id='filter-is_favorite' and @value='false']/..//*[@for='filter-is_favorite']/DIV")} 
        if(params."Favorites"== false){Click.run(ID:"//input[@id='filter-is_favorite' and @value='true']/..//*[@for='filter-is_favorite']/DIV")} 
        
        if(params."My Votes"== true){Click.run(ID:"//input[@id='filter-my_voted_ideas' and @value='false']/..//*[@for='filter-my_voted_ideas']/DIV")} 
        if(params."My Votes"== false){Click.run(ID:"//input[@id='filter-my_voted_ideas' and @value='true']/..//*[@for='filter-my_voted_ideas']/DIV")} 
        
        if(params."New To Me"== true){Click.run(ID:"//input[@id='filter-ihaveviewed' and @value='false']/..//*[@for='filter-ihaveviewed']/DIV", "Type of Click":"Javascript")}
        if(params."New To Me"== false){Click.run(ID:"//input[@id='filter-ihaveviewed' and @value='true']/..//*[@for='filter-ihaveviewed']/DIV", "Type of Click":"Javascript")}
        
        if(params."My Submissions"== true){Click.run(ID:"//input[@id='filter-my_submissions']/../DIV[contains(@class,'f-toggle-off')]", "Type of Click":"Javascript")}
        if(params."My Submissions"== false){Click.run(ID:"//input[@id='filter-my_submissions']/../DIV[contains(@class,'f-toggle-on')]", "Type of Click":"Javascript")}
        
        if(params."My Applications"){
            if(params."My Applications"== true){Click.run(ID:"//input[@id='filter-my_applications']/../DIV[contains(@class,'f-toggle-off')]", "Type of Click":"Javascript")}
            if(params."My Applications"== false){Click.run(ID:"//input[@id='filter-my_applications']/../DIV[contains(@class,'f-toggle-on')]", "Type of Click":"Javascript")}
        }
        if(params."Clear Filters"==true){
            Click.run(ID:"//*[@class='f-footer f-justified-footer']/BUTTON[contains(@class,'f-clear-filter')]")
        }
        if(params."Clear Individual Filters"){
            params."Clear Individual Filters".each{Click.run(ID:"//*[@class='tab-header-title' and text()='${it}']/following-sibling::DIV/SPAN")}
        }
        if(params.Action=="Save"){
            Click.run(ID:"//*[@class='f-footer f-justified-footer']/BUTTON[contains(@data-test,'submit')]")
            sleep(2000)
        }
        else if(params.Action=="Cancel"){
            Click.run(ID:"//*[@class='f-footer f-justified-footer']/BUTTON[contains(@data-test,'cancel')]")
        }
        sleep(2000)
        if(params."Filter Button Should be Active"==true){
            assert Exists.run(ID:"//button[@id='f-biw-filter-btn'and contains(@class,'f-has-filter')]")==1, "Error - Filter Button Not Active"
        }
        else if(params."Filter Button Should be Active"==false){
            assert Exists.run(ID:"//BUTTON[@id='f-biw-filter-btn' and contains(@class,'f-has-global-filter')]")==0, "Error - Filter Button Active"
        }
        sleep(3000)
    }
}