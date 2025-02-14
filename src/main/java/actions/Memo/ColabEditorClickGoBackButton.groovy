package actions.Memo;

import actions.selenium.Click
import actions.selenium.SetFocus

class ColabEditorClickGoBackButton{
    public void run(def params){
        SetFocus.run(ID:"//BUTTON[contains(@class,'f-back-btn')]")
        Click.run(ID:"//BUTTON[contains(@class,'f-back-btn')]")
       	//SetFocus.run(ID:"//BUTTON[contains(@data-for,'f-back-btn')]")
       	//Click.run(ID:"//BUTTON[contains(@data-for,'f-back-btn')]")
		sleep(3000)
    }
}