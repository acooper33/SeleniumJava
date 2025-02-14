package actions.ActionItems;

import actions.selenium.*
import java.nio.file.Paths

class SetDevelopmentforIdeainActionItemspage{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        if(Exists.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']",Timeout:4)>0){
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            if(Exists.run(ID:"//*[contains(text(),'Skip Tour')]",Timeout:2)>0){
                Click.run(ID:"//*[contains(text(),'Skip Tour')]")
            }
            else{
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Finish']")
            }
        }

        if(params."Development Multiple Choice Question"){Click.run(ID:"//*[@id='questions']//LABEL[text()='${params."Development Multiple Choice Question"}']/preceding-sibling::INPUT[1]")}
        SetText.run(Text:params."Development Long Answer Question", ID:"//*[@id='questions']//TEXTAREA[1]")
        SetText.run(Text:params."Development Short Answer Question", ID:"//*[@id='questions']//INPUT[@type='text'and not(@class)]")
        SetText.run(Text:params."Development Date Question", ID:"//*[@id='questions']//INPUT[@type='text' and contains(@class,'date')]")
        Click.run(ID:"//DIV[@class='question-name']")
        SetText.run(Text:params."Development Number Question", ID:"//*[@id='questions']//INPUT[@type='text' and contains(@class,'number')]")
        if(params."Development Attachment Question"){
            def fileName
            //Get path to file we are sending
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ 	//linux
        		fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Development Attachment Question"}"
        	}else{																//windows
        		fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Development Attachment Question"}"  
       		}
            //Now send a file to the 'fallback_input' element
            SendKeys.run(ID:"//*[@id='questions']//DIV[@class='question-wrapper file ']//INPUT",Text:fileName)
            sleep(2000)
        }
        if(params."Development User Select Question"){
            params."Development User Select Question".split(",").eachWithIndex{ name, x ->
                if(params."Development User Select Question Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='member_search_input']",Text:name)
                    sleep(3000)
                    Click.run(ID:"//DIV[contains(@style,'display:none') or starts-with(@style,'display: block')]/UL/LI[starts-with(@data-value,'${name}') or contains(@email,'${name}') and contains(@class,'cur')]/DIV/DIV")
                }
                else{
                    Click.run(ID:"//*[@id='member_search_input']//*[contains(text(),'${name}')]/../A")
                }
            }
        }
        SelectItem.run(ID:"//*[@id='questions']//SELECT","Visible Text":params."Development Parent Dropdown Question")
        sleep(2000)
        if(params."Development Child Checkbox Question"){
            params."Development Child Checkbox Question".each{
                Click.run(ID:"//*[@id='questions']//LABEL[text()='${it}']/preceding-sibling::INPUT[1]")
            }
        }
        if(params.Action){
            if(params.Action=="Save"){
                Click.run(ID:"//*[@id='save']")
            }else{
                Click.run(ID:"//*[@id='complete']")
                if(params."Action on Mark Development Form Complete" == "Mark Complete"){
                    Click.run(ID:"//*[@id='f-modal-submit']//*[text()='Mark Complete']")
                }else if(params."Action on Mark Development Form Done" == "Mark Done"){
                    println("We are in Mark Done")
                    Click.run(ID:"//*[@id='f-modal-submit']//*[text()='Mark Finished']")} //, "Type of Click":"Javascript")}
                else if(params."Action on Mark Development Form Complete" == "Cancel") {Click.run(ID:"//*[@data-test='modal-footer-cancel']")}              
            }
            sleep(7000)
        }
    }
}