package actions.ViewIdea30;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetFocus

class SetCoverImageinViewIdea3page{
    public void run(def params){
        
        SetFocus.run(ID:"//*[contains(@class,'f-idea-image-container')]")
        Click.run(ID:"//I[contains(@class,'fa fa-image-polaroid')]")
        if(Exists.run(ID:"//*[contains(@class,'open fractal-dropdownPopout-popout-container')]")==1){
            Click.run(ID:"//*[contains(@class,'open fractal-dropdownPopout-popout-container')]//A/../..")
        }
        if(params."Original Image"){
            if(params."Original Image"=="Default"){
                assert Exists.run(ID:"//*[@class='f-change-img' and contains(@style,'default-idea-image.jpg')][1]")==1, "Incorrect original image displayed"
            } else{
                assert Exists.run(ID:"//*[@class='f-change-img' and contains(@style,'/ct/getfile.php')][1]")==1, "Incorrect original image displayed"
            }            
        }
        if(params."New Image"==true){
            if(params."Original Image"=="Default"){
                assert Exists.run(ID:"//*[@class='f-change-img' and (contains(@style,'/ct/getfile.php') or contains(@style,'data:image/svg+xml'))][1]")==1, "Incorrect new image displayed" 
            } else {
                assert Exists.run(ID:"//*[@class='f-change-img' and (contains(@style,'/ct/getfile.php') or contains(@style,'data:image/svg+xml'))][2]")==1, "Incorrect new image displayed" 
            }               
        }
        if(params."Update Cover Image Action"){
            if(params."Update Cover Image Action"=="Update image"){
                Click.run(ID:"//*[@class='title' and text()='Update cover image']/../..//*[@data-test='modal-footer-submit']")
            } else {
                Click.run(ID:"//*[@class='title' and text()='Update cover image']/../..//*[@data-test='modal-footer-cancel']")
            }
        }
    }
}