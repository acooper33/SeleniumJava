package actions.Grid;

import actions.selenium.Click

class SortGridColumn{
    public static void run(def params){
        Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@class='fa fa-filter']","Type of Click":"Javascript")
        if(params."Sort"=="Ascending"){Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@class='grid-sort-btn']/*[text()='Sort Ascending']")}
        else{Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@class='grid-sort-btn']/*[text()='Sort Descending']")}
        sleep(3000)
    }
}