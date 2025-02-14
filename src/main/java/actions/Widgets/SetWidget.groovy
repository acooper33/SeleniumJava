package actions.Widgets;

import actions.selenium.*
    
class SetWidget{
    public void run(def params){
        if(params."New Title name"){
            Click.run(ID:"//*[@class='widget_title']//*[text()='${params."Name of Widget to Modify"}']/../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
            SetText.run(ID:"//INPUT[contains(@id,'title_edit') and @value='${params."Name of Widget to Modify"}']",Text:params."New Title name")
            if(params."Click on Edit while editing the title"==null || params."Click on Edit while editing the title"==true){
                Click.run(ID:"//INPUT[contains(@id,'title_edit') and @value='${params."Name of Widget to Modify"}']/../../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
            }            
            params."Name of Widget to Modify" = params."New Title name"
        }
        
        if(params."Show or Hide"){
            if(params."Show or Hide"=="Show"){Click.run(ID:"//*[@class='widget_title']//*[text()='${params."Name of Widget to Modify"}']/../..//I[contains(@oldtitle,'Show title bar and text')]","Type of Click":"Javascript")}
            else{Click.run(ID:"//*[@class='widget_title']//*[text()='${params."Name of Widget to Modify"}']/../..//I[contains(@title,'Hide title bar and text')]","Type of Click":"Javascript")}
        }
        
        if(params."Remove"){
            Click.run(ID:"//*[@class='widget_title']//*[text()='${params."Name of Widget to Modify"}']/../..//I[contains(@title,'Remove')]","Type of Click":"Javascript")
            //Click.run(ID:"//DIV[@class='widget_title_container']/DIV[@class='widget_title']/DIV[contains(@id,'title_text') and text()='${params."Name of Widget to Modify"}']/../../DIV[contains(@class,'widget_tools')]")
            println(">>>>>>>>Sucess!!")
            sleep(2000)
            Click.run(ID:"//*[@id='dialogbox_content']/DIV[1]/BUTTON[1]")
        }
        if(params."Save"==true){
            Click.run(ID:"//INPUT[contains(@id,'title_edit') and @value='${params."Name of Widget to Modify"}']/../../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
        }    
        sleep(1000)
    }
}