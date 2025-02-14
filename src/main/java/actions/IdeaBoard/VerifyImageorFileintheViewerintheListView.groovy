package actions.IdeaBoard;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyImageorFileintheViewerintheListView{
    public void run(def params){
        
        if(params."Open from Attachment Field in View Idea3"==true){
            Click.run(ID:"//*[@class='f-filedisplay-image-slide']//*[text()='${params."Image or File"}']/../..")
        } else {
             Click.run(ID:"//*[contains(@class,'fractal-secondary-ideas-view-list')]//*[text()='${params."Idea"}']/../..//*[@data-class='f-comment-wrapper-pinned' and contains(@style,'rgb(235, 245, 251)')]//*[@data-class='f-comment-body' and text()='${params."Comment"}']/..//*[@class='f-filedisplay-image-slide']//*[text()='${params."Image or File"}']/../..")            
        }
        sleep(2000)
        def verify = [:]
        verify.ID = "//*[@class='ril-inner ril__inner']//*[@alt='${params."Image or File"}'][1]"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        sleep(2000)
        Click.run(ID:"//*[@aria-label='Close lightbox']/..")
    }
}