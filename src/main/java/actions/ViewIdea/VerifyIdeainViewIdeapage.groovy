package actions.ViewIdea;

import actions.selenium.VerifyText
import actions.selenium.GetText
import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By;

class VerifyIdeainViewIdeapage{
    public def run(def params){

        if(params."Idea Name"){sleep(5000)}
        VerifyText.run(ID:"//*[@id='idea-title']",Text:params."Idea Name")
        if(params."Idea Image"!=null){
            if(params."Idea Image"){assert Exists.run(ID:"//*[@id='idea-image-img' and contains(@src,'default-idea-image.jpg')]")==0,"Error - Expected idea image for idea is not found"}
            else{assert Exists.run(ID:"//*[@id='idea-image-img' and contains(@src,'default-idea-image.jpg')]")==1,"Error - Image for idea found but should NOT exist"}
        }
        VerifyText.run(ID:"//*[@id='idea-submitter-name']",Text:params."Creator username")
        VerifyText.run(ID:"//*[@id='idea-category-title']",Text:params."Category")
        VerifyText.run(ID:"//*[@id='idea-status-title']",Text:params."Status")
        VerifyText.run(ID:"//*[@class='owner-labels']","Contains Text":params."Owner")
        if (params.Tag){
            params.Tag.split(",").eachWithIndex{ name, x ->
                if(params."Tag Should Exist".split(",")[x]=="TRUE"){
                    assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[@class='tag_left']//*[starts-with(translate(., '${name.toUpperCase()}', '${name}'), '${name}')]") == 1,"Error - Failed to find Tag ${name}"
                }else{
                    assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']//*[starts-with(translate(., '${name.toUpperCase()}', '${name}'), '${name}')]") == 0,"Error - Tag ${name} found but should NOT exist"
                }
            } 
        }
        if(params."Admin Tag"){
            println("Verifying Admin Tags")
            params."Admin Tag".split(",").eachWithIndex{ name, x ->
                if(params."Admin Tag Should Exist".split(",")[x]=="TRUE"){
                    assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']/*[@id='idea-admin-label-container']//*[text()='${name}']") == 1, "Error - Failed to find Tag ${name}"
                }
                else {
                    assert Exists.run(ID:"//*[@id='idea-tags-wrapper']//*[@id='idea-tags-container']/*[@id='idea-admin-label-container']//*[text()='${name}']")== 0, "Error - Tag ${name} found but should NOT exist"
                }
            }
        }
        //Anna: Verify video/image content in Description
            if (params."Description"=="Image"){
                assert Exists.run(ID:"//*[@id='desc-text']/IMG[.]", "Timeout":20)>0, "Error - Image for field ${params."Field Name"} not found"
            }else if (params."Description"=="Video") {
                assert Exists.run(ID:"//*[@id='desc-text']//IFRAME[contains(@src,'www.youtube.com') or contains(@src,'vimeo.com') or contains(@src,'microsoftstream.com')]", "Timeout":20)>0, "Error - Video for Description field not found"
            	assert Exists.run(ID:"//*[@id='desc-text']//IFRAME//*[contains(@id,'error')|contains(@class,'error')]", "Timeout":20)==0,"Error in the description"
            }else if(params."Description"=="Video - Microsoft Stream"){
                assert Exists.run(ID:"//*[@id='desc-text']//IFRAME[contains(@src,'microsoftstream.com')]", "Timeout":20)>0, "Error - Video for Description field not found"
            }else {VerifyText.run(ID:"//DIV[@id='desc-text']","Contains Text":params."Description")}
  
        VerifyText.run(ID:"//*[@id='stage_wrapper']/div[@class='stage-title']","Contains Text":params."Stage")
        VerifyText.run(ID:"//*[@id='idea_details_points']/TD[2]",Text:params."Points")
        VerifyText.run(ID:"//*[@id='idea_details_votes']/TD[2]",Text:params."Votes")
        VerifyText.run(ID:"//*[@id='total_chips']",Text:params."Chips Total")
        VerifyText.run(ID:"//*[@id='invested_chips']",Text:params."Chips Invested")
        VerifyText.run(ID:"//*[@id='idea_details_rank']/TD[2]",Text:params."Rank")
        VerifyText.run(ID:"//*[@id='idea_details_unique_views']/TD[2]",Text:params."Unique Views")
        VerifyText.run(ID:"//*[@id='idea_details_total_views']/TD[2]",Text:params."Total Views")
        VerifyText.run(ID:"//*[@id='idea_details_comments']/TD[2]",Text:params."Comments")
        VerifyText.run(ID:"//*[@id='idea_details_favorited']/TD[2]",Text:params."Favorited")
        VerifyText.run(ID:"//*[@class='f-vote-count']",Text:params."Vote Count on Voting UI")

        //Return the code of the Idea
        def ideaValue = GetText.run(ID:"//*[@id='idea-code']")
        return ideaValue.substring(ideaValue.indexOf("(") + 1, ideaValue.indexOf(")"))

    }
}