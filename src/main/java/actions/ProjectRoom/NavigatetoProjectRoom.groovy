package actions.ProjectRoom;

import actions.selenium.*
    
class NavigatetoProjectRoom{
    public void run(def params){

        //Deprecated code use  Verify and Access Project Room Card in Userhome
        /*
        if(params."Project Room Position"){
            Click.run(ID:"//A[contains(@class,'f-project-card f-userhomepage-card f-pr-card')][position()=${params."Project Room Position"}]//*[contains(@class,'f-card-title') and text()='${params."Project Room"}']/../..")
        } else {
            Click.run(ID:"//*[contains(@class,'f-card-title') and text()='${params."Project Room"}']/../..")
        }        */
    }
}