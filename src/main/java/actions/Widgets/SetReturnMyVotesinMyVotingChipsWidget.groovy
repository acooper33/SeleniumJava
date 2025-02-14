package actions.Widgets;

import actions.selenium.Click

class SetReturnMyVotesinMyVotingChipsWidget{
    public void run(def params){

        Click.run(ID:"//*[@id='my_chips_widget']//a[text()='Return all of my votes']")

        if(params."Return My Votes Action"){
            if(params."Return My Votes Action"=="Yes"){
                Click.run(ID:"//*[@id='gen_mess_message']/button[text()='Yes']")
            } else {
                Click.run(ID:"//*[@id='gen_mess_message']/button[text()='No']")
            }
            sleep(2000)
        }
    }
}