package actions.selenium;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import org.openqa.selenium.StaleElementReferenceException;

class SetReactTags{
    public static void setIdeaTagsOrExpertise(params){
        //sets regular idea tags and expertise
    	//Tag Name, Tag Add or Remove
        // Modal xpath helpful when multiple modals are open
        
        if(params."Modal xpath"==null){params."Modal xpath"=""}
        params."Tag Name".split(",").eachWithIndex{ name, x ->
        	if(params."Tag Add or Remove".split(",")[x]=="Add"){
                println("Adding tag ${name}" )
            	SetText.run(ID:params."Modal xpath"+"//*[contains(@id,'react-tags')]//*[@class='react-tags__combobox-input']",Text:name)
                sleep(2000)
                if(params."Set Tab"){                        
                	def setTab = params."Set Tab".split(",")
                    Click.run(ID:"//*[contains(@class,'f-tag-suggestion-name')][normalize-space()='${setTab[x]}']") 
                    sleep(4000)
                }
                SendKeys.run(ID:params."Modal xpath"+"//*[@class='react-tags__combobox-input']",Key:"ENTER")
             }else{
                  println("Removing tag ${name}" )
                  Click.run(ID:params."Modal xpath"+"//*[contains(@class,'react-tags__tag')]//SPAN[contains(@class,'name') and text()='${name}']//following-sibling::*[contains(@class,'f-rmv-tag')]")
             }
    	}
    }
    public static void setMemberTagsWithAddRemove(params){
        if(params."User"){
            if(params."Field Name"==null) {params."Field Name"=""}
            params."User".split(",").eachWithIndex{ name, x ->
        		if(params."Add or Remove".split(",")[x]=="Add"){
        			addMemberTag(params."Field Name", name)
				}else{
            		deleteMemberTag(params."Field Name", name)
        		}
       		}
        }
    	
    }
    public static void setMemberTagsWithoutAddRemove(params){ 
        //used in collab editor, memo
        //add users as if "Add or Remove" parameter is always "Add"
        //also covers "Permission" and "Send Invite"
        
        if(params."Field Name"==null) {params."Field Name"=""}
        params."User".split(",").eachWithIndex{ name, x ->
        	addMemberTag(params."Field Name", name)
            
        	if(params."Permission".split(",")[x]){
        		Click.run(ID:"//*[contains(text(),'${params."Field Name"}')]/../..//*[contains(@class,'f-member-typeahead')][1]/following-sibling::*[contains(@class,'fractal-clickoutside')]")
            	Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI/*[contains(.,'${params."Permission".split(",")[x]}')]")
        	}
       		if(params."Send Invite".split(",")[x]=="TRUE"){
        		Click.run(ID:"//*[contains(@class,'f-send-invite') and .='Send Invite']")
        	}
        }
    }
    public static void setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide(params){
        //used in Duplicate Pipeline, Scorecard, Single Scale Config
        
        params."User".split(",").eachWithIndex{ name, x ->
        	if(params."Add or Remove".split(",")[x]=="Add"){
            	//println("Adding tag ${name} into ${params."Field Name"}" )
        		addMemberTagLabelSideBySide(params."Field Name", name)
			}else{
            	//println("Removing tag ${name} into ${params."Field Name"}" )
        		deleteMemberTagLabelSideBySideORLabelAbove(params."Field Name", name)
        	}
       	}   
    }  
    
    public static void setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsAbove(params){
        //used in Pipeline Setup
        
        params."User".split(",").eachWithIndex{ name, x ->
        	if(params."Add or Remove".split(",")[x]=="Add"){
            	println("Adding tag ${name} into ${params."Field Name"}" )
        		addMemberTagWithLabelAbove(params."Field Name", name)
			}else{
            	println("Removing tag ${name} into ${params."Field Name"}" )
                deleteMemberTagLabelSideBySideORLabelAbove(params."Field Name", name)
        	}
       	}   
    }
    public static void setMemberTagsWithAddRemoveWithCustomxPath(params){
        //used in Development Step Config
        
        params."User".split(",").eachWithIndex{ name, x ->
            if(params."Add or Remove".split(",")[x]=="Add"){
           		addMemberTagWithCustomxPath(params."Custom xpath", name) 
            }else{
                deleteMemberTagWithCustomxPath(params."Custom xpath", name)
            }
        }
    }
    public static void setMemberTagsWithAddRemoveNewSetupWizard(params){
        //used in std license pipeline setup wizard 
        //create memo webstorm, create app webstorm 
        if(params."Field Name"==null) {params."Field Name"=""}
        params."User".split(",").eachWithIndex{ name, x ->
        	if(params."Add or Remove".split(",")[x]=="Add"){
       			addMemberTag(params."Field Name", name)
			}else{
            	deleteMemberTagLabelSideBySideORLabelAbove(params."Field Name", name)
        	}
      	}
    }
    
    public static void setMemberWhiteboardMemoModalTags(params){
        //memo set member for review
        if(params."User"){
            if(params."Field Name"==null) {params."Field Name"=""}
            params."User".split(",").eachWithIndex{ name, x ->
        		if(params."Add or Remove".split(",")[x]=="Add"){
        			addMemberWhiteboardMemoModal(params."Field Name", name)
				}else{
            		deleteMemberTagLabelSideBySideORLabelAbove(params."Field Name", name)
        		}
       		}
        }
    }
    
    //internal add and delete member tags
    private static void addMemberWhiteboardMemoModal(def fieldName, def name){
        SetFocus.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[@class='react-tags__combobox-input']")
        SetText.run(ID:"//*[contains(text(),'${fieldName}')]/../..//*[contains(@class,'f-member-typeahead')][1]//*[@class='react-tags__combobox-input']",Text:name,"Type of Clear":"None")
        sleep(500)
        Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${name}' or text()='${name} (Create new user)']/../../..")
    }
    
    private static void addMemberTag(def fieldName, def name){
        SetFocus.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[@class='react-tags__combobox-input']")
        SetText.run(ID:"//*[contains(text(),'${fieldName}')]/../..//*[contains(@class,'f-member-typeahead')][1]//*[@class='react-tags__combobox-input']",Text:name,"Type of Clear":"None")
        sleep(500)
        //if(Exists.run(ID:"//*[@class='react-tags__listbox']//*[text()='${name}' or text()='${name} (Create new user)']")>0){
            Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${name}' or text()='${name} (Create new user)']/../../..", "Handle Stale Element":true)
        //}else{
            //request review on memo
        	//Click.run(ID:"//DIV[@class='f-modal-body']//DIV[contains(@class,'react-tags__combobox')]//*[text()='${name}' or text()='${name} (Create new user)']/../../..","Handle Stale Element":true)
        //}
    }
    private static void deleteMemberTag(def fieldName, def name){
        //wizard setup, review on memo
        //if(Exists.run(ID:"//*[contains(text(),'${fieldName}')]/../following-sibling::*[contains(@class,'f-member-typeahead')][1]")>0){
            SetFocus.run(ID:"//*[contains(text(),'${fieldName}')]/../following-sibling::*[contains(@class,'f-member-typeahead')][1]")
        	Click.run(ID:"//*[contains(text(),'${fieldName}')]/../following-sibling::*[contains(@class,'f-member-typeahead')][1]//*[text()='${name}']/..//*[@class='f-tag-remove']")       
        //}else{
            //memo review
            //Click.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[text()='${name}']/..//I")
            //Click.run(ID:"//*[contains(text(),'${fieldName}')]/../..//*[contains(@class,'f-member-typeahead')][1]/../../..//*[text()='${name}']/..//I")
        //} 
    }
    private static void deleteMemberTagLabelSideBySideORLabelAbove(def fieldName, def name){
        if(fieldName.contains("Access")){
            SetFocus.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[text()='${name}']")
        	Click.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[text()='${name}']/..//I")
        } else {
            SetFocus.run(ID:"//*[starts-with(text(),'${fieldName}')]/../../..//*[text()='${name}']")
        	Click.run(ID:"//*[starts-with(text(),'${fieldName}')]/../../..//*[text()='${name}']/..//I")
        }
    }
    
    private static void deleteMemberTagWithCustomxPath(def xPath, def name){
        Click.run(ID:"${xPath}//*[text()='${name}']/..//I")
    }
    private static void addMemberTagWithCustomxPath(def xPath, def name){
        SetFocus.run(ID:"${xPath}//*[@class='react-tags__combobox-input']")
       	SetText.run(ID:"${xPath}//*[@class='react-tags__combobox-input']",Text:name)
        sleep(500)
        Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${name}' or text()='${name} (Create new user)']/../../..")
                	
    }
    private static void addMemberTagLabelSideBySide(def fieldName, def name){
     
        def teamName = name
    	def remainingPart = ""
        if(name.contains("member")) {
        	teamName = name.replaceAll("\\s*\\(.*\\)", "") // Strip text inside parentheses
        	remainingPart = name.find("\\(.*\\)") // Capture the part inside parentheses
        }
        if(fieldName.contains("Access")){
            Click.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[@class='react-tags__combobox-input']")
       		SetText.run(ID:"//*[starts-with(text(),'${fieldName}')]/../..//*[@class='react-tags__combobox-input']",Text:teamName,"Type of Clear":"None")
        } else {
            Click.run(ID:"//*[starts-with(text(),'${fieldName}')]/../../..//*[@class='react-tags__combobox-input']")
       		SetText.run(ID:"//*[starts-with(text(),'${fieldName}')]/../../..//*[@class='react-tags__combobox-input']",Text:teamName,"Type of Clear":"None")
        }
		sleep(500)
       if(name.contains("member")) {
           Click.run(ID:"//*[@class='react-tags__listbox']//*[contains(text(),'${teamName} ${remainingPart}')]/../../..") 
       } else {
           Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${teamName}' or text()='${teamName} (Create new user)' or contains(text(),'${teamName}')]/../../..") 
       }        
    } 
    private static void addMemberTagWithLabelAbove(def fieldName, def name){
        SetFocus.run(ID:"//*[contains(text(),'${fieldName}')]/../following-sibling::*[contains(@class,'f-member-typeahead')][1]//*[@class='react-tags__combobox-input']")
        SetText.run(ID:"//*[contains(text(),'${fieldName}')]/../following-sibling::*[contains(@class,'f-member-typeahead')][1]//*[@class='react-tags__combobox-input']",Text:name,"Type of Clear":"None")
        sleep(500)
        Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${name}' or text()='${name} (Create new user)']/../../..") 
    }    
}