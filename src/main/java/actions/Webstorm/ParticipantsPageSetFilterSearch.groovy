package actions.Webstorm;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.selenium.DragAndDrop

class ParticipantsPageSetFilterSearch{
    public void run(def params){
        if(params."Clear All Filters"){
        	Click.run(ID:"//*[starts-with(@class,'ideaboard-filter-bar')]//span[starts-with(@class, 'ideaboard-filter-clear')]")
            sleep(2000)
        }
        if(params."Search by name"){
            SetText.run(ID:"//input[contains(@class,'filter-search-input')][1]", Text:params."Search by name")
            sleep(3000)
        }
        if(params."Clear Search"){
            Click.run(ID:"//*[@data-for='fractal-input-clear']/I")
            sleep(500)
        }
        if(params."Search Expertise"){
            SetText.run(ID:"//input[contains(@id,'filter-tag-search-Expertise')]", Text:params."Search Expertise")
            sleep(500)
        }
        if(params."Clear Search Expertise"){
            Click.run(ID:"//*[@data-for='filter-search-clear']/I")
            sleep(500)
        }
        if(params."Tick Expertise"){
            params."Tick Expertise".split(",").each{
				Click.run(ID:"//*[starts-with(@id, 'filter-expertise')]/following-sibling::LABEL/*[starts-with(.,'${it}')]/../../input[@type='checkbox']")
            }
        }
        if(params."Available to Join Teams"){
            Click.run(ID:"//DIV[contains(@class,'filter-participant-availability')]//*[starts-with(@id, 'filter-availability')]/following-sibling::LABEL/*[starts-with(.,'${params."Available to Join Teams"}')]/../../input[@type='checkbox']")
        }
        if(params."Projects Count"){
            sleep(2000)
        	DragAndDrop.run("From ID":"//DIV[@class='filter-participant-idea-count']//*[@role='slider'][1]", "To ID":"//DIV[@class='filter-participant-idea-count']//*[@class='rc-slider-mark']/span[text()='${params."Projects Count"}']", "Type of Drag and Drop":"Dragging") 
            sleep(2000)
        }
        if(params."Location"){
            Click.run(ID:"//DIV[contains(@class,'filter-participant-location')]//*[starts-with(@id, 'filter-location')]/following-sibling::LABEL/*[starts-with(.,'${params."Location"}')]/../../input[@type='checkbox']")
        }
        if(params."Certifications"){
            params."Certifications".each{
				Click.run(ID:"//*[starts-with(@id, 'filter-certification')]/following-sibling::LABEL/*[contains(., '${it}')]/../../input[@type='checkbox']")
            }
        }
    }
}