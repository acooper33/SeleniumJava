package actions.ActionItems;
import actions.selenium.Click
import actions.selenium.Exists

class VerifyRevisionHistoryDevelopmentforIdeainActionItemspage{
    public void run(def params){

        if(Exists.run(ID:"//*[@id='proposal-revision']")>0){ 
            Click.run(ID:"//*[@id='proposal-revision']")
        }  

        if(params."Revision History"){
            Click.run(ID:"//*[@id='proposal-versions']")
            Click.run(ID:"//*[@id='proposal-versions-list']//a[contains(.,'${params."Revision History"}')]")
            sleep(2000)
        }

        if(params."Development Multiple Choice Question"){assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development Multiple Choice Question')]/..//DIV[@class='scores-question-answer' and text()='${params."Development Multiple Choice Question"}']")>0, "Error - Incorrect Value for Development Multiple Choice Question"}
        if(params."Development Long Answer Question"){assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development Long Answer Question')]/..//DIV[@class='scores-question-answer' and text()='${params."Development Long Answer Question"}']")>0, "Error - Incorrect Value for Development Long Answer Question"}
        if (params."Development User Select Question") {
            params."Development User Select Question".split(",").eachWithIndex{ name, x ->
                assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development User Select Question')]/..//A[contains(text(),'${name}')]")>0, "Error - ${name} not displayed"}
        }              
        if(params."Development Parent Dropdown Question"){assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development Parent Dropdown Question')]/..//DIV[@class='scores-question-answer' and text()='${params."Development Parent Dropdown Question"}']")>0, "Error - Incorrect Value for Development Parent Dropdown Question"}
        if(params."Development Child Checkbox Question"){assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development Child Checkbox Question')]/..//DIV[@class='scores-question-answer' and text()='${params."Development Child Checkbox Question"}']")>0, "Error - Incorrect Value for Development Child Checkbox Question"}
        if(params."Development Attachment Question"){assert Exists.run(ID:"//*[@id='proposal-content-sheet']//DIV[contains(text(),'Development Attachment Question')]/..//A[text()='${params."Development Attachment Question"}']")>0, "Error - Incorrect attachment"}    
        
        if(params."Back To Edit"==true){Click.run(ID:"//*[@id='proposal-revision-back']")}
        if(params."Restore Revision"==true){Click.run(ID:"//*[@id='proposal-revision-restore']")}
    }
}
