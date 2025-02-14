package actions.Search;

import actions.selenium.*
    
class ClicklinkonSearchPageresultssection{
    public void run(def params){
        if(params."Search Results Type"){
            sleep(2000)
            Click.run(ID:"//A[text()='${params."Search Results Type"}']")}
        Click.run(ID:"//A[.='${params."Link name"}']")
    }
}