package actions.Widgets;

import actions.selenium.Click

class AccessIdeaDraftfromMyIdeaDraftWidget{
    public void run(def params){
   
        Click.run(ID:"//*[@id='my_idea_drafts_container']//A[starts-with(text(),'${params."Idea Draft"}')]")
    }
}