package actions.Memo;

import actions.selenium.DragAndDrop
import actions.selenium.Click
import actions.selenium.SetText

class SetRequestReviewQuestions{
    public void run(def params){
        

       def path = "//*[contains(@class,'f-memo-review-item-container')][${params."Question Container"}]//*[@class='f-question-header' and .='${params."Question"}']"

        if(params."Drag the scrollbar or input the answer"=="Input"){
            SetText.run(Text:params."Answer",ID:"${path}/..//INPUT") 
        } else {
            DragAndDrop.run("From ID":"${path}/..//*[@role='slider'][1]", "To ID":"${path}/..//*[@class='rc-slider-mark']/span[text()='${params."Answer"}']") 
        }
        if(params."Add Comment"==true){
            Click.run(ID:"${path}/..//*[@data-tip='Add comment']")
        }
       SetText.run(Text:params."Add comment to this question",ID:"//*[contains(@class,'f-review-comment-textarea f-shown')]//*[@placeholder='Add a comment for this question']","Type of Clear":"Cut") 
       SetText.run(Text:params."Do you have any additional notes for the Author/Team?",ID:"//*[contains(@class,'f-memo-review-item-container')][${params."Question Container"}]//*[@class='f-question-header' and .='Do you have any additional notes for the Author/Team?']/..//*[@class='f-question-body']//TEXTAREA")
       if(params."Submit Review"==true){
           if(params."Question Container"){
                Click.run(ID:"//*[contains(@class,'f-memo-review-item-container')][${params."Question Container"}]//*[contains(@class,'f-btn-primary')]//*[text()='Submit Review' or text()='Save Review']")
           } else {
                Click.run(ID:"//*[contains(@class,'f-memo-review-item-container')][1]//*[contains(@class,'f-btn-primary')]//*[text()='Submit Review' or text()='Save Review']")
           }
           sleep(2000)
        } 
    }
}