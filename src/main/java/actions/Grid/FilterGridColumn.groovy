package actions.Grid;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class FilterGridColumn{
    public static void run(def params){
        Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@class='fa fa-filter']","Type of Click":"Javascript")
        if(params."Filter Select All or Clear"){
            if(params."Filter Select All or Clear"=="Select All"){Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@id='grid-filter-all-btn']")}
            else{Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@id='grid-filter-clear-btn']")}
        }
        SetText.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@id='grid-filter-search']",Text:params."Filter Search")
        if(params."Value"){
            params."Value".split(",").eachWithIndex{ name, x ->
                SetCheckBox.run(ID:"//TH/A[text()='${params."Column Name"}']/..//INPUT[@type='checkbox' and @value='${name}']",Check:params."Value Check".split(",")[x].toBoolean())
            }
        }
        if(params."Clear Keywords"==true){Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@class='input-group-addon closeWrapper']/I")}
        if(params.Action=="Apply" || params.Action=="OK"){Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@id='filter-btn-ok']","Type of Click":"Javascript")}
        else{Click.run(ID:"//TH/A[text()='${params."Column Name"}']/..//*[@id='filter-btn-cancel']","Type of Click":"Javascript")}
    }
}