package actions.People;

import actions.selenium.Exists
import actions.selenium.Click

class VerifyLicenseDetailsinPeoplePillarPage{
    public void run(def params){
                 
        if(params."Open Details" == true || params."Open Details" == null){
            Click.run(ID:"//*[@class='admin-left-column' and text()='${params."Member Name"}']/../*[@class='admin-right-column']//*[contains(text(),'${params."Role"}')]")
        }
        
        assert Exists.run(ID:"//*[@class='wrapper-inner']//*[@class='f-member-name' and text()='${params."Member Name"}']")==1, "Error - 'Incorrect Name on the modal"
        assert Exists.run(ID:"//*[@class='wrapper-inner']//*[@class='f-member-license-type' and .='${params."License Type"}']")==1, "Error - Incorrect license type"
        
         if(params."Member Image"!=null){
            if(params."Member Image"){assert Exists.run(ID:"//*[@class='wrapper-inner']//*[contains(@class,'member-image-v1')]/*[contains(@src,'/ct/getfile.php')]")==1,"Error - Expected member image for idea is not found"}
            else{assert Exists.run(ID:"//*[@class='wrapper-inner']//*[contains(@class,'member-image-v1')]/*[contains(@class,'member-initial')]")==1,"Error - Image for member found but should NOT exist"}
        }
        if(params."Title"){
            assert Exists.run(ID:"//*[@class='wrapper-inner']//*[@class='f-member-title' and text()='${params."Title"}']")==1, "Error - 'Incorrect title in the modal"
        }
        
        if(params.Role){
         params."Role".split(",").eachWithIndex{role, x -> 
           def area = params."Area".split(",")
           def newarea = area[x]
             if(area[x].contains("https")){
                 newarea = area[x].substring(area[x].indexOf("https:") + 8, area[x].indexOf("."))
                 println(newarea)
             }
             assert Exists.run(ID:"//*[@class='wrapper-inner']//*[@class='administrators-modal-column-left' and text()='${role}']/..//*[@class='administrators-modal-area' and text()='${newarea}']")>0,"Incorrect info on License Details "
             if(params."Click on the area"==true){
                 Click.run(ID:"//*[@class='wrapper-inner']//*[@class='administrators-modal-column-left' and text()='${role}']/..//*[@class='administrators-modal-area' and text()='${newarea}']")}
             }     
        }
    }
}