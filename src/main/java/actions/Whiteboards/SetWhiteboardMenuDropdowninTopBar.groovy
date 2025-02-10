package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.Exists
import org.openqa.selenium.By
import screens.WhiteboardLocators

class SetWhiteboardMenuDropdowninTopBar{
    public void run(def params){
        Click.run(ID:"//*[@data-test='f-test-whiteboard-menu-dropdown']")
        if(params."Create My Own"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-top-bar')]//DIV[contains(@class,'f-canvas-top-bar-right')]//*[@id='create-my-own-whiteboard']")
        }
        if(params."Menu Option"){
            Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[.='${params."Menu Option"}']")
        }
        if(params."Sub Option"){
            Click.run(ID:"//*[contains(@class,'f-dropdown-options-nested')]//*[@class='f-menu-item' and .='${params."Sub Option"}']")
            
        }
        sleep(1000)
        if(params."Delete Modal Action"=="Submit"){
            //println("Delete Modal Action==Submit")
            if(Exists.run(ID:"//DIV[contains(@class,'fractal-modal-body')]//DIV[contains(@class,'f-checkbox')]")>0){
                //println("Checkbox detected")
                Click.run(ID:"//DIV[contains(@class,'fractal-modal-body')]//input[@id='delete-canvas-checkbox']/..")
            }
            Click.run(ID:"//*[@id='clickToConfirmOkButton']")
        }else if (params."Delete Modal Action"=="Cancel") {
            Click.run(ID:"//*[@id='clickToConfirmCancelButton']")
        }
    }
}