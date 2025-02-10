package actions.selenium;

import java.io.File;

class DeleteFile{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            assert new File(System.getProperty("user.home") + "/"+ params."File Name").delete(),"Error - Failed to delete the file"
        }else {
            assert new File(System.getProperty("user.home") + "\\"+params."File Location"+"\\"+ params."File Name").delete(),"Error - Failed to delete the file"
        }
    }
}