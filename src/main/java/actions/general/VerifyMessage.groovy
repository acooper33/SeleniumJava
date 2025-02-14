package actions.general;

//import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser

class VerifyMessage{
    public void run(def params){
        def exists = false
        for(int i = 1;i <= 3;i++){
            def allElements = Elements.findAll(ID:"//*[contains(text(),\"${params."Message Text"}\")]",Browser.Driver)
            allElements.each{
                if(exists == true){return}
                if(it.isDisplayed()){exists = true}
            }
            if(exists == true){break}
            sleep(500)
        }

        assert exists==params."Should Exist","Error - Message expected to be ${params."Should Exist"} but is actually ${exists}"
    }
}