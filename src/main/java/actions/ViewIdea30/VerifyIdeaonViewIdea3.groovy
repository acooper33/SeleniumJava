package actions.ViewIdea30;

import actions.selenium.VerifyText
import actions.selenium.Exists

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import java.util.*
import java.util.regex.Pattern;
import java.util.regex.Matcher;



class VerifyIdeaonViewIdea3{
    public void run(def params){
     
        sleep(5000)
        def path
        
        if(params."Template"=="Memo Record"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-memo-record')]"
        }else if(params."Template"=="Small Header"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-modern-small')]"
        } else if(params."Template"=="Large Header"){
            path = "//*[@class='f-idea-page-main']/*[contains(@class,'f-modern-large')]"       
        } else {
            path = "//*[@class='f-idea-page-main' and //*[contains(@class,'-medium')]]"  
        }
        
        VerifyText.run(ID:"${path}//*[contains(@class,'f-idea-inner-row')]//*[@class='f-static-title']","Contains Text":params."Idea Name")
        
        if(params."Idea Code"){
            //WebElement tool = Elements.find(ID:"${path}//*[contains(@class,'f-idea-inner-row')]//*[@class='f-static-title']/*[@class='link']",Browser.Driver)
            //println("Idea Code: ${tool.getText()}")
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-inner-row')]//*[@class='f-static-title']/*[@class='link']/A[contains(.,'${params."Idea Code"}')]")>0, "Error - unexpected idea code"
        }
        if(params."Description"){
        	VerifyText.run(ID:"//DIV[@id='f-edit-description']",Text:params."Description")
        }
        if(params."Idea Image"!=null){
            if(params."Template" == "Small Header"){
                assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-image')]")==0,"Image displayed for Small header"
            } else {
                if(params."Idea Image"==true){assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-image') and contains(@style,'/ct/getfile.php')]")==1,"Error - Expected idea image for idea is not found"}
                else{assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-image') and contains(@style,'default-idea-image.jpg')]")==1,"Error - Image for idea found but should NOT exist"}
            }
        }
        if(params."Submitter Name"){
            if(params."Submitter Name".startsWith("Team")){
                WebElement team = Elements.find(ID:"${path}//*[@class='f-idea-inner-row']//*[@class='f-idea-team-wrapper']",Browser.Driver)
                println("Team Submitter text: ${team.getText()}")
                assert Exists.run(ID:"${path}//*[@class='f-idea-inner-row']//*[@class='f-idea-team-wrapper' and contains(translate(., ' ', ''),translate('${params."Submitter Name"}', ' ', ''))]//*[contains(@class,'fas fa-users f-member-icon')]")==1,"Error - Incorrect team displayed"
            } else if(params."Submitter Name".contains("Anonymous")){
                assert Exists.run(ID:"${path}//*[@class='f-idea-inner-row']//*[contains(@class,'f-member-anonymous') and .='${params."Submitter Name"}']")==1,"Error in displaying anonymous submission"
            } else if(params."Does it have team submission name"==true){
                assert Exists.run(ID:"${path}//*[@class='f-idea-inner-row']//*[contains(@class,'f-member-icon-wrapper f-team-icon-wrapper')]/..//span[2][text()='${params."Submitter Name"}']")==1,"Error in displaying team submission name"
            } else {
                VerifyText.run(ID:"${path}//*[@class='f-idea-inner-row']//*[contains(@class,'f-member-name')]",Text:params."Submitter Name")
                if(params."Submitter Image"!=null){
                    if(params."Submitter Image"==true){
                        println("submitter image is true")
                        assert Exists.run(ID:"${path}//*[@class='f-idea-inner-row']//DIV[contains(@class,'member-image')]//IMG")>0, "Error - Expected submitter image for submitter is not found"
                    }
                    else{assert Exists.run(ID:"${path}//*[@class='f-idea-inner-row']//DIV[@class='member-initial']")==1,"Error - Image for submitter found but should NOT exist"}
                }
            }
        }
        VerifyText.run(ID:"${path}//*[contains(@class,'f-idea-inner-row f-idea-row-mobile')]//*[@class='f-vote-count']",Text:params."Vote Count")
    	if(params."Category"){
            if(params."View As"=="End User" || params."Category"=="Quick Add"){
                assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Category']/..//*[text()='${params."Category"}']")==1,"Incorrect Category"
            } else {
                assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Category']/..//*[@data-test='f-test-dropdown']//A[text()='${params."Category"}']")==1,"Incorrect Category"
                }
            }
        if(params."Status"){
            if(params."View As"=="End User"){
                assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Status']/..//*[contains(@class,'f-status-indicator f-status-indicator-primary f-status-indicator-outline') and starts-with(text(),'${params."Status"}')]")==1,"Incorrect Status"
            } else {
                 assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Status']/..//*[@data-test='f-test-dropdown']//*[contains(@class,'f-status-indicator f-status-indicator-primary f-status-indicator-outline') and starts-with(text(),'${params."Status"}')]")==1,"Incorrect Status"
            }
        }
    	if(params."Owner"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Owner']/..//*[contains(@class,'f-member-name') and .='${params."Owner"}']")==1,"Incorrect Owner"
        }
    	if(params."Submitted"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-component-title') and text()='Submitted']/../*[text()='${params."Submitted"}']")==1,"Incorrect submitted date"        
        }
        if(params."Stats Points"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-stats')]//*[text()='Points']/following-sibling::DD[text()='${params."Stats Points"}'][1]")==1,"Incorrect Points"        
    	}
         if(params."Stats Votes"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-stats')]//*[text()='Votes']/following-sibling::DD/*[contains(@class,'fractal-button fractal-button-link f-votes-btn-link') and text()='${params."Stats Votes"}']")==1,"Incorrect Votes"        
    	}
        if(params."Stats Rank"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-stats')]//*[text()='Rank']/following-sibling::DD[text()='${params."Stats Rank"}'][1]")==1,"Incorrect Rank"        
    	}
        if(params."Stats Comments"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-stats')]//*[text()='Comments']/following-sibling::DD[text()='${params."Stats Comments"}'][1]")==1,"Incorrect comment count"        
    	}
        if(params."Stats Favorited"){
            assert Exists.run(ID:"${path}//*[contains(@class,'f-idea-stats')]//*[text()='Favorited']/following-sibling::DD[text()='${params."Stats Favorited"}'][1]")==1,"Incorrect Favorited count"        
    	}
        if(params.Tag){
            def found
            List <WebElement> tags
            if(params."View As"=="End User"){
            	tags = Elements.findAll(ID:"${path}//*[@class='f-tag']",Browser.Driver)
            } else {
            	tags = Elements.findAll(ID:"${path}//*[contains(@class,'react-tags__tag') and not(contains(@class,'f-admin-tag'))]//*[@class='f-tag-name']",Browser.Driver)
            } 
            params.Tag.split(",").eachWithIndex{ name, x ->
                //anna:
                println("Looking for tag ${name}")
                found = false
                tags.each{value -> 
                    println("Inspecting tag ${value.getText()}")
                        if(value.getText().contains(name)){
                            println("Tag Found")
                            found = true}
                }
                if(params."Tag Should Exist".split(",")[x]=="TRUE"){
                    assert found, "Error - Failed to find Tag ${name}"
                } else {
                    assert !found, "Error - Found Tag ${name}"
                }
            }
        }
        if(params."Admin Tag"){
            params."Admin Tag".split(",").eachWithIndex{ name, x ->
                if(params."Admin Tag Should Exist".split(",")[x]=="TRUE"){
                    if(params."View As"=="End User"){
                        assert Exists.run(ID:"${path}//*[contains(@class,'f-tag f-admin-label') and text()='${name}']") == 1,"Error - Failed to find Admin Tag ${name}"
                    } else {
                        assert Exists.run(ID:"${path}//*[contains(@class,'react-tags__tag') and (contains(@class,'f-admin-tag'))]//*[text()='${name}']") == 1,"Error - Failed to find Admin Tag ${name}"
                    } 
                } else {
                    if(params."View As"=="End User"){
                        assert Exists.run(ID:"${path}//*[contains(@class,'f-tag f-admin-label') and text()='${name}']") == 0,"Error - Admin Tag ${name} found but should NOT exist"
                    } else {
                        assert Exists.run(ID:"${path}//*[contains(@class,'react-tags__tag') and (contains(@class,'f-admin-tag'))]//*[text()='${name}']") == 0,"Error - Admin Tag ${name} found but should NOT exist" 
                    }
                }
            } 
        } 
        if(params."Expertise"){
            params."Expertise".split(",").eachWithIndex{ name, x ->
                if(params."Expertise Should Exist".split(",")[x]=="TRUE"){
                    if(params."View As"=="End User"){
                        assert Exists.run(ID:"${path}//DIV[contains(@class,'f-component f-idea-expertise')]//A[contains(@classs,'f-expertise') and text()='${name}']") == 1,"Error - Failed to find Expertise ${name}"
                        //assert Exists.run(ID:"${path}//*[contains(@class,'f-admin-tag')]//*[text()='${name}']") == 1,"Error - Failed to find Admin Tag ${name}"
                    } else {
                        assert Exists.run(ID:"${path}//DIV[contains(@class,'f-component f-idea-expertise')]//*[contains(@class,'react-tags__tag')]//*[text()='${name}']") == 1,"Error - Failed to find Expertise ${name}"
                        //assert Exists.run(ID:"${path}//*[contains(@class,'react-tags__tag') and (contains(@class,'f-admin-tag'))]//*[text()='${name}']") == 1,"Error - Failed to find Admin Tag ${name}"
                    } 
                } else {
                    if(params."View As"=="End User"){
                        assert Exists.run(ID:"${path}//DIV[contains(@class,'f-component f-idea-expertise')]//A[contains(@classs,'f-expertise') and text()='${name}']") == 0,"Error - Expertise ${name} found but should NOT exist"
                    } else {
                        assert Exists.run(ID:"${path}//DIV[contains(@class,'f-component f-idea-expertise')]//*[contains(@class,'react-tags__tag')]//*[text()='${name}']") == 0,"Error - Expertise ${name} found but should NOT exist" 
                    }
                }
            } 
        } 
        /*if(params."Click on the idea code?"==true){
            WebElement title =  Elements.find(ID:"${path}//*[contains(@class,'f-idea-inner-row')]//*[@class='f-static-title']",Browser.Driver).getText()
            println("Our title: ${title}")
            Pattern pattern = Pattern.compile("\\((.*?)\\)")
            Matcher matcher = pattern.matcher(title)
            while (matcher.find()) {
            	String ideaURL = matcher.group(1).replaceAll("\"", "")
            	System.out.println("Our idea code: " + textWithinParentheses);
                Click.run(ID:"//A[starts-with(.,'${ideaURL}')]")
        	}
        }*/
    }
}