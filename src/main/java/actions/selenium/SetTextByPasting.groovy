package actions.selenium;

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import java.awt.datatransfer.StringSelection
import java.awt.Toolkit

class SetTextByPasting{
    public static void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        if(params.Text){
            WebElement element = Elements.find(params,Browser.Driver)
            if (element == null) {
                println("Element not found")
            }
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
                String insertText = params.Text
                try {
                	ProcessBuilder processBuilder0 = new ProcessBuilder("/bin/bash", "-c", "sudo su -");
                    Process process0 = processBuilder0.start();
                    
                    ProcessBuilder processBuilder1 = new ProcessBuilder("/bin/bash", "-c", "DISPLAY=:10 echo Hello | xclip -sel -clipboard");
                    Process process1 = processBuilder1.start();
            		int exitCode1 = process1.waitFor();
                    System.out.println("Command 1 exited with code " + exitCode1);
                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
                    String line;
                    while ((line = reader.readLine())!=null){
                        System.out.print("LINE for setting: ${line}");
                    }
                }
                catch(NullPointerException | IOException | InterruptedException e) {
                	e.printStackTrace();
                }
                /*finally{
                	if (process != null) {
                		process.destroy();
            		}
                }*/
                element.click();
                element.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "v"), "");
				               
            } else {
                element = Elements.find(params,Browser.Driver)
                StringSelection str = new StringSelection(params."Text");
            	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            	element.click();
            	element.sendKeys(Keys.chord(Keys.CONTROL, "v"), "");
            }   
        }
    }
}