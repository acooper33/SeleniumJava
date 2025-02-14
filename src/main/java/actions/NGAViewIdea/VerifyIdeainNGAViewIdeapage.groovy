package actions.NGAViewIdea;

import actions.common.*
import actions.selenium.*

class VerifyIdeainNGAViewIdeapage{
    public def run(def params){
        if(params."Idea Name"){sleep(2000)}
        NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        VerifyText.run(ID:"//*[@id='idea-title']","Contains Text":params."Idea Name")
        if(params."Idea Image"!=null){
            if(params."Idea Image"){assert Exists.run(ID:"//*[@id='idea-image-img' and contains(@src,'default-idea-image.jpg')]")==0,"Error - Expected idea image for idea is not found"}
            else{assert Exists.run(ID:"//*[@id='idea-image-img' and contains(@src,'default-idea-image.jpg')]")==1,"Error - Image for idea found but should NOT exist"}
        }
        VerifyText.run(ID:"//*[@id='votes']/DIV[1]/DIV[1]",Text:params."Points")
        VerifyText.run(ID:"//*[@id='idea-submitter-name']",Text:params."Creator username")
        VerifyText.run(ID:"//*[@id='idea-submission-date']","Contains Text":params."Submitted")
        VerifyText.run(ID:"//*[@id='idea-category-title']",Text:params."Category")
        VerifyText.run(ID:"//*[@id='idea-status-title']",Text:params."Status")
        VerifyText.run(ID:"//*[@class='owner-labels']","Contains Text":params."Owner")
        VerifyText.run(ID:"//*[@id='idea-step-title']",Text:params."Step")
        if (params.Tag){
            params.Tag.split(",").eachWithIndex{ name, x ->
                def found
                if(params."Tag Should Exist".split(",")[x]=="TRUE"){
                    found = false
                    if(Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name}']") == 1 ||
                      Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name.toUpperCase()}']") == 1){
                        found = true
                    }
                    assert found, "Error - Failed to find Tag ${name}"
                    //assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name}']") == 1,"Error - Failed to find Tag ${name}"
                }
                else{
                    found = true
                    if(Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name}']") == 0 &&
                      Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name.toUpperCase()}']") == 0){
                        found = false
                    }
                    assert !found, "Error - Tag ${name} found but should NOT exist"
                    //assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[text()='${name}']") == 0,"Error - Tag ${name} found but should NOT exist"
                }
            } 
        }
        //Anna: Verify video/image content in Description
        if (params."Description"=="Image"){
            println("Verifying Image")
            assert Exists.run(ID:"//*[@id='desc-text']//IMG[.]","Timeout":20)>0, "Error - Image for field ${params."Field Name"} not found"
        }else if(params."Description"=="Video - Youtube"){
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME[contains(@src,'www.youtube.com')]", "Timeout":20)>0, "Error - Video for Description field not found"
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME//*[contains(@class,'error')|contains(@id,'error')]", "Timeout":20)==0,"Error in the description"
        }else if(params."Description"=="Video - Microsoft Stream"){
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME[contains(@src,'microsoftstream.com')]", "Timeout":20)>0, "Error - Video for Description field not found"
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME//*[contains(@class,'error')|contains(@id,'error')]", "Timeout":20)==0,"Error in the description"
        }else if(params."Description"=="Video - Vimeo"){
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME[contains(@src,'vimeo.com')]", "Timeout":20)>0, "Error - Video for Description field not found"
            assert Exists.run(ID:"//*[@id='desc-text']//IFRAME//*[contains(@class,'error')]", "Timeout":20)==0,"Error in the description"
        }else {VerifyText.run(ID:"//*[@id='desc-text']",Text:params."Description")}

        //Return the code of the Idea
        def ideaValue = GetText.run(ID:"//*[@id='idea-code']")
        return ideaValue
    }
}