package actions.Whiteboards;

import actions.selenium.Exists
import actions.selenium.*
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.SetFocus

class VerifySmartMatrixExists{
    public void run(def params){
        def xPath
        if(params."Verify This Actual Text"){xPath="//UL[@class='f-canvas-element-list']/LI/DIV/SPAN[starts-with(.,'${params."Verify This Actual Text"}')]/../../../../../.."}
        if(params."Contains Text"){xPath="//UL[@class='f-canvas-element-list']/LI/DIV/SPAN[contains(.,'${params."Contains Text"}')]/../../../../../.."}
        println("Verifying text via xPath: ${xPath}")
        if(params."Element (skip if verifying text)"){
            println("Verifying element: ${params."Element (skip if verifying text)"}")
            if (params."Element (skip if verifying text)"=="Sticky Note"){
            	xPath="//*[@class='f-canvas-list-item']//I[contains(@class,'sticky-note')]/../../../../../.." 
        	}else if (params."Element (skip if verifying text)"=="Marker"){
                xPath="//*[@class='f-canvas-list-item']//*[starts-with(text(),'Pen Stroke')]/../../../../../.." 
        	}else{
            	xPath="//UL[@class='f-canvas-element-list']/LI/SPAN[starts-with(text(),'${params."Element (skip if verifying text)"}')]/../../../../../.."
        	}
            println("Verifying element via xPath: ${xPath}")
        }
        if(params."Should Exist" == true){
            sleep(5000)
            assert Exists.run(ID:xPath)==1, "Error - Element does not exist"
        }else{
            assert Exists.run(ID:xPath)==0, "Error - Element should not exist, but is displayed" 
        }
    }
}