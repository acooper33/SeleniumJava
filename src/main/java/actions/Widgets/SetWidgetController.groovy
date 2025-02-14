package actions.Widgets;

import actions.selenium.*

class SetWidgetController{
    public void run(def params){
        //View Idea 2
        if(Exists.run(ID:"//*[@id='widget-admin-panel']")>0){
            if(Exists.run(ID:"//*[@id='widget-admin-panel']//*[@class='widget-admin-content']")==0){
            	Click.run(ID:"//*[@id='widget-admin-panel']//*[@class='widget-admin-icon fa fa-gears']")
            }
            if(params."Widget Edit Mode"){
            	if(params."Widget Edit Mode"=='Enable'){Click.run(ID:"//*[@id='widget-admin-widget-editor-toggle']/SPAN[text()='Off']")}
            	else{Click.run(ID:"//*[@id='widget-admin-widget-editor-toggle']/SPAN[text()='On']")}
            	sleep(1500)   
        	}
            if(params."Label Edit Mode"){
            	if(params."Label Edit Mode"=='Enable'){Click.run(ID:"//*[@id='widget-admin-label-toggle']/SPAN[text()='Off']")}
            	else{Click.run(ID:"//*[@id='widget-admin-label-toggle']/SPAN[text()='On']")}
            	sleep(1500)
        	}
            if(params."Preview as Ordinary User"!=null){
            	Click.run(ID:"//*[@id='preview-as-end-user']")
            	sleep(1500)
        	}
            if(params."Add Widget from Selection"){
            	SelectItem.run(ID:"//*[@id='widget-admin-approved-select']","Visible Text":params."Add Widget from Selection")
            	Click.run(ID:"//*[@id='widget-admin-add-approved-widget-btn']")
            	sleep(1500)
        	}
            if(params."Add Widget from Unapproved Selection"){
            	SelectItem.run(ID:"//*[@id='widget-admin-edit-options']","Visible Text":params."Add Widget from Selection")
            	Click.run(ID:"//*[@id='widget-admin-add-unapproved-widget-btn']")
            	sleep(1500)
        	}
            Click.run(ID:"//*[@id='widget-admin-panel']//*[@class='widget-admin-svg-icon widget-admin-icon']")
        //View Idea 3    
        }else if (Exists.run(ID:"//DIV[@class='f-admin-icon']")){
            Click.run(ID:"//DIV[@class='f-admin-icon']")
            if(params."Widget Edit Mode"){
            	if(params."Widget Edit Mode"=='Enable'){Click.run(ID:"//DIV[contains(@class,'f-admin-wrapper')]//DIV[contains(@class,'f-toggle-off')]")}
            	else{Click.run(ID:"//DIV[contains(@class,'f-admin-wrapper')]//DIV[contains(@class,'f-toggle-on')]")}
            	sleep(1500)   
        	}
            if(params."Navigate to"){
                Click.run(ID:"//DIV[contains(@class,'f-admin-wrapper')]//*[contains(@class,'f-widget-admin-link-item')]//*[contains(.,'${params."Navigate to"}')]")
            }
            
        }
        
        
        
        
        
        
        
        
    }
}