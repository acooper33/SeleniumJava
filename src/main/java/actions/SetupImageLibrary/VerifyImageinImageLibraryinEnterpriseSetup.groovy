package actions.SetupImageLibrary;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
    
class VerifyImageinImageLibraryinEnterpriseSetup{
    public void run(def params){

        SetCheckBox.run(ID:"//*[@id='no-preview-checkbox']",Check:params."Hide Image Preview")
        def verify = [:]
        verify.ID = "//*[@id='image_list']//A[text()='${params."FileName"}']"
        verify.IDChildren = []
        if(params."Description"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR/TD[2][contains(text(),'${params."Description"}')]"}
        if(params."Type"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR/TD[3][contains(text(),'${params."Type"}')]"}
        if(params."Filesize"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR/TD[4][contains(text(),'${params."Filesize"}')]"}
        if(params."Updated"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR/TD[5][contains(text(),'${params."Updated"}')]"}
        if(params."Owner"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR/TD[6][contains(text(),'${params."Owner"}')]"}
        if(params."URL"){verify.IDChildren << "./parent::DIV/parent::TD/parent::TR//INPUT[@class='input_box' and @value='${params."URL"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
    }
}