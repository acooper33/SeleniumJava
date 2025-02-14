package actions.MyActivity;
import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifyPeopleIamFollowinginmyActivitypage{
    public void run(def params){

        if(params."People"=="EMPTY") {
            assert Exists.run(ID:"//*[@id='user_following_list']") == 0,"Error - List not empty"
        } 
        else { 
            params."People".split(",").eachWithIndex{ name, x ->
                VerifyText.run(ID:"//*[@class='follow_user_btn_span']/A[text()='${name}']","Text":name)
            } 
        }
    }
}