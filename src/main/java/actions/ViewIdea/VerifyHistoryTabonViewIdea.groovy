package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.utils.Elements
import actions.selenium.Browser
import java.util.List

class VerifyHistoryTabonViewIdea{
    public void run(def params){
        
        if(params."Launch from View Idea 3"==false || params."Launch from View Idea 3"==null){
            ViewIdeaCommon.NavigateTab(Tab:"History Tab")
        }        
        sleep(2000)
        if(params."Event Record to Verify"){
            def records = []
            records = Elements.findAll(ID:"//*[@class='f-text']", Browser.Driver)
            //println("We are looking for ${params."Event Record to Verify"}")
            //println("Number of total records found: ${records.size()}")
            assert records.size()>0, "Error - record not found" 
            if(params."Total Number of Records"){assert records.size()==params."Total Number of Records".toInteger(), "Error - number of records is ${records.size()} "}
            if(params."Placement Number"){
                if(params."Event Record to Verify".contains("Owner changed")){
                    assert records.get(((params."Placement Number").toInteger())-1).getText().trim().contains(params."Event Record to Verify".trim()), "Error - record at ${params."Placement Number"} is ${records.get(params."Placement Number".toInteger()-1).getText()}"
                } else {
                    println("There is a placement num param. Here is actual record:")
                    assert records.get(((params."Placement Number").toInteger())-1).getText().trim().equals(params."Event Record to Verify".trim()), "Error - record at ${params."Placement Number"} is ${records.get(params."Placement Number".toInteger()-1).getText()}"
                }
            }
            if(params."Number of Matches"){
                def numOfMatches=0
                records.each{ record ->
                    //println("Printing record text: ${record.getText().trim()}")
                    if(params."Event Record to Verify".contains("Owner changed")){
                        if(record.getText().trim().contains(params."Event Record to Verify".trim())){
                            numOfMatches++
                                println("Found a match! ${numOfMatches}")
                        }
                    }else if(record.getText().trim().equals(params."Event Record to Verify".trim())){
                        numOfMatches++
                            println("Found a match! ${numOfMatches}")
                    }
                }
                assert numOfMatches==params."Number of Matches".toInteger(), "Error - number of records is ${numOfMatches}"
            }
        }
    }
}
