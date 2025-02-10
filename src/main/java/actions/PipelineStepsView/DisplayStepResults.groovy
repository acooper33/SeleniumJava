package actions.PipelineStepsView;

import actions.selenium.SetCheckBox
import actions.selenium.Click


class DisplayStepResults{
    public void run(def params){
        println("We are in Display Results----<")
            println("HEre ------>")
            println(params."Display Step Results")
            Click.run(ID:"//*[@id='enable-box']")
            sleep(1000)
            SetCheckBox.run(ID:"//*[@id='display-evaluation-data']", Check:params."Display Step Results")
        	sleep(3000)
    }
}