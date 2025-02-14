package actions.Widgets;

import actions.selenium.*

class VerifyChipsinMyVotingChipsWidget{
    public void run(def params){
        
        VerifyText.run(ID:"//*[@id='my_chips_widget' and contains(.,'${params."Votes Left"}')]","Contains Text":params."Votes Left")
    }
}