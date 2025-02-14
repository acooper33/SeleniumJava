package actions.Widgets;

import actions.selenium.Click
import actions.selenium.VerifyText

class VerifyandAccessoptionsonEnterpriseMyLandingpageWidget{
    public void run(def params){

        if (params."Username"){
            Click.run(ID:"//*[@id='user_name']/A")}
        if (params."Edit Profile"== true){
            Click.run(ID:"//*[@id='user_name']/DIV/A")}
        if (params."Activity Feed"== true){
            Click.run(ID:"//*[@id='activity_feed']/A")}
        if(params."Action Items Count"){
            VerifyText.run(ID:"//*[@id='action_items_count']",Text:params."Action Items Count")}
        if (params."Action Items"== true){
            Click.run(ID:"//*[@id='action_items']/A")}
        if (params."Messages"== true){
            Click.run(ID:"//*[@id='messages']/A")}
        if(params."Message Count"){
            VerifyText.run(ID:"//*[@id='messages_count']",Text:params."Message Count")}
         if (params."Submissions"== true){
            Click.run(ID:"//*[@id='idea']/A")}
        if(params."Submission Count"){
            VerifyText.run(ID:"//*[@id='idea_count']",Text:params."Submission Count")}
        if (params."Proposals"== true){
            Click.run(ID:"//*[@id='proposals']/A")}
        if(params."Proposal Count"){
            VerifyText.run(ID:"//*[@id='proposal_count']",Text:params."Proposal Count")}
        if (params."Subscription"== true){
            Click.run(ID:"//*[@id='subscription']/A")}   
    }
}