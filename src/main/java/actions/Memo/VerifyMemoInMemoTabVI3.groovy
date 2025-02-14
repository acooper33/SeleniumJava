package actions.Memo;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists

class VerifyMemoInMemoTabVI3{
    public void run(def params){
        if(params."Empty State"==true){
            assert Exists.run(ID:"//*[@class='f-memo-no-memos']//*[contains(text(),'Ready to start your memo?')]")==1, "No Empty State"
            assert Exists.run(ID:"//*[@class='f-memo-no-memos']//*[contains(@class,'f-create-memo-btn')]")==1, "Missing Create Memo Button"
        }else{
            if(params."Should Exist"==false){
        		assert Exists.run(ID:"//*[contains(@class,'f-idea-memo')]//SPAN[contains(@class,'f-memo-thumbnail-title') and contains(.,'${params."Title"}')]")==0, "Error - Unexpected Memo Displayed"
        	}else{
            	def verify = [:]
        		verify.IDChildren = []
        		verify.ID = "//*[contains(@class,'f-idea-memo')]//SPAN[contains(@class,'f-memo-thumbnail-title') and contains(.,'${params."Title"}')]"
        		if(params."Time"){verify.IDChildren << "./../../../../../..//SPAN[contains(@class,'f-memo-thumbnail-date') and starts-with(.,'${params."Time"}')]"}
        		if(params."Submitter"){verify.IDChildren << "./../../../../../..//SPAN[contains(@class,'f-memo-thumbnail-date')]/A[text()='${params."Submitter"}']"}
        		if(params."Thumbnail Image Displayed"){verify.IDChildren << "./../../../../../..//DIV[contains(@class,'f-memo-thumbnail-body')]//DIV[@class='f-memo-thumbnail-image' and contains(@style,'background-image')]"}
        		if(params."Memo Icon"){verify.IDChildren << "./../../../../../..//DIV[contains(@class,'f-memo-thumbnail-header-left')]//I[contains(@class,'f-memo-thumbnail-icon')]"}
        		VerifyNumberOfMatches.run(verify)
        	}
        }
    }
}