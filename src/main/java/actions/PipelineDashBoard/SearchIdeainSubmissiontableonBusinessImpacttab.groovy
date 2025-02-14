package actions.PipelineDashBoard;

import actions.selenium.*

class SearchIdeainSubmissiontableonBusinessImpacttab{
    public void run(def params){
       
        if(params."Search Value"){
            SetText.run(ID:"//*[@id='category-table-search']",Text:params."Search Value")
            sleep(5000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[contains(@class,'table-search')]//*[@class='input-clear']")
            sleep(5000)
        }
    }
}