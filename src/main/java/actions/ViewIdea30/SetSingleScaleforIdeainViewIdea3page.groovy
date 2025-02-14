package actions.ViewIdea30;

import actions.selenium.Click

class SetSingleScaleforIdeainViewIdea3page{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-single-scale-question' and text()='${params."Question"}']/..//*[@class='f-rating-container']/*[contains(@class,'f-rating f-rating-')]/*[text()='${params."Rating"}']/..")
        sleep(2000)
     
    }
}
