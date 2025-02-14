package actions.EnterpriseBlogs;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import java.nio.file.Paths
import actions.selenium.SendKeys
import actions.selenium.SetFocus

class SetBlogPost{
    public void run(def params){
        if(params."Add or Edit"){
            if(params."Add or Edit"=="Add"){
                Click.run(ID:"//*[@class='post_blog_button']/A")
            }else {Click.run(ID:"//*[@id='quoteAlt1']//a[text()='edit']")}
        }
        if(params."Title"){
            SetText.run(Text:params."Title", ID:"//*[@id='blog_subject_title']")
        }
        if(params."Tags") {
            params."Tags".split(",").eachWithIndex{ tag, x ->
                if(params."Add or Delete Tags".split(",")[x]=="Add") {
                    SetText.run(Text:tag, ID:"//*[@id='txtIdeaTag']")
                    Click.run(ID:"//*[@id='btnAddTag']")
                } else {Click.run(ID:"//*[@id='${tag}']/IMG")}
            }
        }
        if(params."Content"){
            Click.run(ID:"//*[@id='elm1_ifr']")
            SetFocus.run(ID:"//*[@id='elm1_ifr']")
            SetText.run(Text:params."Content", ID:"//*[@id='elm1_ifr']", "Type of Clear":"Cut")
        }
        SelectItem.run(ID:"//*[@class='input_dropdown']","Visible Text":params."Blog Topic")
        if(params."Action"){
            if(params."Action"=="Preview"){
                Click.run(ID:"//*[@id='bi-preview-btn']")  
            } else if(params."Action"=="Save Draft"){
                Click.run(ID:"//*[@id='post-blog-draft-button']")
            } else if(params."Action"=="Save Changes"){
                Click.run(ID:"//*[@id='bi-save-btn']")
            } else {Click.run(ID:"//*[@id='bi-post-btn']")}
        }
    }
}