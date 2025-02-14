package actions.Enterprise.UserHomepage;

import actions.selenium.VerifyText

class VerifyViewMyIdeainUserHomepage{
    public void run(def params){

        VerifyText.run(ID:"//*[@class='f-spark-edit-title']",Text:params."Idea Title")
        VerifyText.run(ID:"//*[@id='edit-spark-description']/DIV",Text:params."Idea Description")
        VerifyText.run(ID:"//*[@class='f-spark-edit-header' and text()='Created']//following-sibling::P[1]","Contains Text":params."Created Date")
        VerifyText.run(ID:"//*[@class='f-spark-edit-header' and text()='Updated']//following-sibling::P[1]","Contains Text":params."Updated Date")
    }
}