package actions.NGAViewIdea;

import actions.selenium.MouseOver
import actions.selenium.Click

class SetUserFlyoverNGAViewIdea{
    public void run(def params){
        if(params."Submitter Username"){
            MouseOver.run(ID:"//*[@id='idea-submitter-name']/A[text()='${params."Submitter Username"}']")
            sleep(2000)
            if(params.Action){
                if(params.Action=='Message'){
                    Click.run(ID:"//DIV[contains(@id,'qtip')]//A[@id='user-fly-message-btn']","Type of Click":"Javascript")
                }
                if(params.Action=='Follow'){
                    Click.run(ID:"//DIV[contains(@id,'qtip')]//A[@id='user-fly-follow-btn']","Type of Click":"Javascript")
                }
                if(params.Action=='Profile'){
                    Click.run(ID:"//DIV[contains(@id,'qtip')]//A[@id='user-fly-profile-btn']","Type of Click":"Javascript")
                }
            }
        }
        else if (params."Comment Poster Username"){
            MouseOver.run(ID:"//*[@class='comment-text-container']/A[text()='${params."Comment Poster Username"}']")
            sleep(2000)
            if(params.Action){
                if(params.Action=='Message'){
                    println("We are in message...")
                    Click.run(ID:"//DIV[contains(@id,'qtip') and @aria-hidden='false']//A[@id='user-fly-message-btn']","Type of Click":"Javascript")
                }
                if(params.Action=='Follow'){
                    Click.run(ID:"//DIV[contains(@id,'qtip')]//A[@id='user-fly-follow-btn']","Type of Click":"Javascript")
                }
                if(params.Action=='Profile'){
                    Click.run(ID:"//DIV[contains(@id,'qtip')]//A[@id='user-fly-profile-btn']","Type of Click":"Javascript")
                }
            }
        }
    }
}