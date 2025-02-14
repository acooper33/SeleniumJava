package actions.Enterprise.UserHomepage;

import actions.selenium.*
import java.nio.file.Paths
import actions.selenium.ExplicitWait

class CaptureMyIdea{
    public void run(def params){
		def os = System.getProperty("os.name").toLowerCase();
        if(params."Capture My Idea from"){
            if(params."Capture My Idea from"=="My Idea Empty List Button"){
                sleep(2000)
                Click.run(ID:"//*[@id='clickToCreateSparkButton']")
            } else if(params."Capture My Idea from"=="My Idea List Button"){
                Click.run(ID:"//*[@id='f-sparks-create-button']")
            } else if(params."Capture My Idea from"=="Link"){
                Click.run(ID:"//*[@class='f-sparks-list-empty']//A")
            } else {
                ExplicitWait.run(ID:"//*[@class='fractal-spark-nav-button-v1 global-nav-btn']//*[@class='fa fa-plus-circle']")
                Click.run(ID:"//*[@class='fractal-spark-nav-button-v1 global-nav-btn']//*[@class='fa fa-plus-circle']")}
        }
        SetText.run(ID:"//*[contains(@class,'dynamic-resize-large')]",Text:params."Description")
        if(params."Attachments"){
            params."Attachments".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    def fileName
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    }else{
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }
                    SendKeys.run(ID:"//*[@id='f-fileupload-link']",Text:fileName)
                    if(name.contains(".png") || name.contains(".jpg") || name.contains(".gif")){
                        ExplicitWait.run(ID:"//*[@class='f-image-block']//*[@class='f-file-progress-bar f-progress-hidden']")
                    } else {ExplicitWait.run(ID:"//*[@class='f-file-block']//*[@class='f-file-progress-bar f-progress-hidden']")}
                    sleep(8000)
                } else {
                    Click.run(ID:"//*[contains(@class,'f-images-horizontal-scroll')]//*[@alt='${name}' or text()='${name}']/../..//I[contains(@class,'trash')]")
                    sleep(3000)
                }   
            }
        }
        if(params."Action"){
            ExplicitWait.run(ID:"//*[not(contains(@class,'f-btn-disabled')) and @id='save-spark-button']")
            if(params."Action" =="Save"){
                Click.run(ID:"//*[@id='save-spark-button']","Type of Click" : "Javascript")
                ExplicitWait.run(ID:"//*[contains(@class,'fractal-toast  success')]")
            } else if(params."Action"=="Add Details"){
                Click.run(ID:"//*[@id='add-details-spark-button']")
                ExplicitWait.run(ID:"//*[contains(@class,'fractal-toast  success')]")
            } else { 
                Click.run(ID:"//*[contains(@class,'f-close-button')]")
            }
        }
    }
}
