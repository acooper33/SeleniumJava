package actions.PipelineList;

import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SendKeys

class SearchPipelineList{
    public void run(def params){
        if(params."Action"=="Clear"){Click.run(ID:"//*[@id='search_holder']//*[@class='clear']")}
        else if(params."Action"=="Basic Search"){
            SetText.run(ID:"//*[@id='search_holder']//INPUT[@type='search']",Text:params."Search Field")
            SendKeys.run(ID:"//*[@id='search_holder']//INPUT[@type='search']",Key:"ENTER")
        } else {
            Click.run(ID:"//*[@id='search_holder']//I[@class='fa fa-caret-down advanced-toggle']")
            SetText.run(ID:"//*[@id='advanced-search-menu']/DIV[2]/INPUT[1]",Text:params."Has the Words")
            SetText.run(ID:"//*[@id='advanced-search-menu']/DIV[4]/INPUT[1]",Text:params."Includes Tags")
            SetText.run(ID:"//*[@id='advanced-search-menu']/DIV[6]/INPUT[1]",Text:params."Excludes Tags")
            SetText.run(ID:"//*[@id='advanced-search-menu']/DIV[8]/INPUT[1]",Text:params."Includes Admin Tags")
            SetText.run(ID:"//*[@id='advanced-search-menu']/DIV[10]/INPUT[1]",Text:params."Excludes Admin Tags")
            SetCheckBox.run(ID:"//*[@id='advanced-search-menu']//INPUT[@class='advanced-input advanced-bool']",Check:params."Has Attachment")
            Click.run(ID:"//*[@id='advanced-search-menu']//DIV[text()='Search']")
        }
        sleep(3000)
    }
}
