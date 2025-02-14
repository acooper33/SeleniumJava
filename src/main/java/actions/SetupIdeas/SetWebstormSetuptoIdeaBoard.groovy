package actions.SetupIdeas;

import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.Browser

class SetWebstormSetuptoIdeaBoard{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Idea Boards")
        if (params.Option){
            if(params.Option=="Idea Boards 20"){
                Click.run(ID:"//*[@id='select_idea_board_radio']/input[@value='idea_board_2']")
            }
            if(params.Option=="Idea Boards 10"){
                Click.run(ID:"//*[@id='select_idea_board_radio']/input[@value='idea_board_1']")
            }
            if(params.Option=="Idea Boards 30"){
                Click.run(ID:"//*[@id='select_idea_board_radio']/input[@value='idea_board_3']")
            }
        }
        
        //Page Attributes
        //SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_CARDS_FRACTAL_V2']", Check:params."New Idea Card Design")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_VOTING_ON_IDEA_BOARDS']", Check:params."Voting on Idea Boards")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_LIST_VIEW']", Check:params."List View")
        SetCheckBox.run(ID:"//*[@id='CB_PIPELINE_VIEW']", Check:params."Steps View for End Users") 
        if(params."Default View"){
            Click.run(ID:"//*[@class='default-view-name bold']//*[text()='${params."Default View"}']/../..//*[@name='CB_IDEA_BOARDS_DEFAULT_VIEW']")
        }
        //List View
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_INLINE_PINNED_COMMENTS']", Check:params."Inline Pinned Comments")
        //Steps View
        SetCheckBox.run(ID:"//*[@id='CB_PIPELINE_STAGES_VIEW']", Check:params."Stages") 
        SetCheckBox.run(ID:"//*[@id='CB_PIPELINE_STEPS_VIEW']", Check:params."Steps") 
        //Sorts
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Random']/../input", Check:params."Random")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Recent']/../input", Check:params."Recent")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Active']/../input", Check:params."Active")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Votes']/../input", Check:params."Votes")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Title']/../input", Check:params."Title")
        //Filters
        //Submission Attributes
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Search']/../input", Check:params."Search")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Status']/../input", Check:params."Status")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Stage']/../input", Check:params."Stage")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Category']/../input", Check:params."Category")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Investment-to-date']/../input", Check:params."Investment-to-date")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Projected Revenue']/../input", Check:params."Projected Revenue")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Tags']/../input", Check:params."Tags")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='Admin Tags']/../input", Check:params."Admin Tags")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_EXPERTISE_FILTER']", Check:params."Desired Expertise")
        //Additional Submission Questions
        if(params."Additional Submission Questions"){
            params."Additional Submission Questions".split(",").eachWithIndex{ question, x ->
                SetCheckBox.run(ID:"//*[@id='additional_submission_form_filters']//*[text()='${question}']/../INPUT",Check:params."Additional Submission Questions Check".split(",")[x].toBoolean())
                Click.run(ID:"//*[@id='idea_boards_save_button']", "Type of Click":"Javascript")     
            }
            sleep(2000)
        }
        //User-specific Attributes
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Favorites']/../input", Check:params."My Favorites")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Votes']/../input",Check:params."My Votes")
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='New To Me']/../input", Check:params."New To Me") 
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Submissions']/../input", Check:params."My Submissions") 
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Completed Evaluations']/../input", Check:params."My Completed Evaluations") 
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Subscriptions']/../input", Check:params."My Subscriptions") 
        SetCheckBox.run(ID:"//*[@id='idea_board_option_sort_filter_container']//input[@type='checkbox']/../label[text()='My Applications']/../input", Check:params."My Applications") 
        Click.run(ID:"//*[@id='idea_boards_save_button']", "Type of Click":"Javascript")     
    }
}
