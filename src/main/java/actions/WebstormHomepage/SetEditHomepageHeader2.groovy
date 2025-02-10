package actions.WebstormHomepage;

import actions.selenium.DoubleClick

class SetEditHomepageHeader2{
    public void run(def params){
        
        DoubleClick.run(ID:"//*[@id='homepage-htmlpreview-name']")
        
    }
}