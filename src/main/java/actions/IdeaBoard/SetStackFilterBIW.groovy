package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SetText

class SetStackFilterBIW{
    public void run(def params){
        if(params."Search"){
            SetText.run(ID:"//*[@id='filter-search']", Text:"${params.Search}")
            //SendKeys.run(ID:"//*[@id='filter-search']", Key:"ENTER")
        }
        if(params."Status"){
            params."Status".each{Click.run(ID:"//DIV[@class='filter-status']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-status')]")}        
        }
        if(params."Categories"){
            params."Categories".each{Click.run(ID:"//DIV[@class='filter-category']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id,'filter-category')]")}
        }
        if(params."Expand Tags Filter"){
            Click.run(ID:"//*[@class='tab-header-title' and text()='Tags']/..//I")
        }
        if(params."Tags"){
            params."Tags".each{Click.run(ID:"//*[starts-with(@id, 'filter-tags')]/following-sibling::LABEL/*[text()='${it}']/../../input[@type='checkbox']")}
        }
        if(params."My Submissions"){
            if(params."My Submissions" == true){Click.run(ID:"//DIV[@class='filter-submissions']//DIV[@class='filter-inline-input' and @data-vote='0']", "Type of Click":"Javascript")}
            if(params."My Submissions" == false){Click.run(ID:"//DIV[@class='filter-submissions']//DIV[@class='filter-inline-input' and @data-vote='1']", "Type of Click":"Javascript")}
            //if(params."My Submissions"== true){Click.run(ID:"//input[@id='filter-my_submissions' and @value='false']/..//*[@for='filter-my_submissions']/DIV", "Type of Click":"Javascript")}
            //if(params."My Submissions"== false){Click.run(ID:"//input[@id='filter-my_submissions' and @value='true']/..//*[@for='filter-my_submissions']/DIV", "Type of Click":"Javascript")}
        }
        if(params."Favorites"){
            if(params."Favorites" == true) {Click.run(ID:"//DIV[@class='filter-favorite']//DIV[@class='filter-inline-input' and @data-vote='1']", "Type of Click":"Javascript")}
            if(params."Favorites" == false) {Click.run(ID:"//DIV[@class='filter-favorite']//DIV[@class='filter-inline-input' and @data-vote='0']", "Type of Click":"Javascript")}  
        }
        if(params."My Votes"){
            if(params."My Votes" == true) {Click.run(ID:"//DIV[@class='filter-myvotes']//DIV[@class='filter-inline-input' and @data-vote='1']", "Type of Click":"Javascript")}
            if(params."My Votes" == false) {Click.run(ID:"//DIV[@class='filter-myvotes']//DIV[@class='filter-inline-input' and @data-vote='0']", "Type of Click":"Javascript")}
        }
        if(params."My Subscriptions"){
            if(params."My Subscriptions" == true){Click.run(ID:"//DIV[@class='filter-subscriptions']//DIV[@class='filter-inline-input' and @data-vote='1']", "Type of Click":"Javascript")}
            if(params."My Subscriptions" == false){Click.run(ID:"//DIV[@class='filter-subscriptions']//DIV[@class='filter-inline-input' and @data-vote='0']", "Type of Click":"Javascript")}
        }
        if(params."New To Me"){
            if(params."New To Me" == true) {Click.run(ID:"//DIV[@class='filter-ihaveviewed']//DIV[@class='filter-inline-input' and @data-newtome='false']", "Type of Click":"Javascript")}
            if(params."New To Me" == false) {Click.run(ID:"//DIV[@class='filter-ihaveviewed']//DIV[@class='filter-inline-input' and @data-newtome='true']", "Type of Click":"Javascript")}
        }
        if(params.Action=="Cancel"){Click.run(ID:"//*[contains(@class,'f-filters-done')]/BUTTON[1]")}
        if(params.Action=="Save"){Click.run(ID:"//*[contains(@class,'f-filters-done')]/BUTTON[2]")}   
    }
}