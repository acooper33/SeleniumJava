package actions.ProjectRoom;

import actions.selenium.Click

class SetFilterforProjectRoomTasks{
    public void run(def params){
        
        if(params."Invoke Filter"==true){
            Click.run(ID:"//*[contains(@id,'f-table-filters-dropdown')]")
            println("Clicked on Filter")
        }
        if(params."Assignee"){
            params."Assignee".each{Click.run(ID:"//*[contains(@class,'f-assignee-column')]//*[text()='${it}']/../..//INPUT/..")}
        }
        if(params."Status"){
            params."Status".each{Click.run(ID:"//*[contains(@class,'f-table-filters-column')][2]//*[text()='${it}']/../..//INPUT/..")}
        }
        if(params."Due Date"){
            params."Due Date".each{Click.run(ID:"//*[contains(@class,'f-table-filters-column')][3]//*[text()='${it}']/../..//INPUT/..")}
        }
        if(params."Clear Filter"==true){
            Click.run(ID:"//*[contains(@class,'f-table-filters-footer')]/BUTTON[text()='Clear Filter']")
        }
        if(params."Click on Close Button"==true){
            Click.run(ID:"//*[contains(@class,'f-table-filters-footer')]/BUTTON[text()='Close']")
            sleep(2000)
        }
    }
}