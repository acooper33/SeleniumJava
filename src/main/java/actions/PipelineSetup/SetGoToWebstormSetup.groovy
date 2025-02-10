package actions.PipelineSetup;

import actions.selenium.Click

class SetGoToWebstormSetup{
    public void run(def params){
      Click.run(ID:"//*[@id='webstorm-setup-link']/A")  
    }
}