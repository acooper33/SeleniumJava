package actions.SetIdeaFields;

import actions.selenium.SetText

class SetPostIdeaTeamSubmissionField{
    public static run(def params){
        
        SetText.run(Text:params."Field Value",ID:"//*[@aria-label='Team Name']")
        
    }
}