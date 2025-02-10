package actions.selenium;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Process
import java.io.IOException;
import java.util.Map;

class GetClipboardContent{
    public static String run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        String contents = "";
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")) { // if on linux
            Process process = null;
            def line
            try{
                ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", "DISPLAY=:10 xclip --clipboard -o");
                processBuilder.redirectErrorStream(true);
                process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            	contents = reader.readLine()
                while ((line = reader.readLine()) != null) {
                    System.out.print("LINE: ${line}");
                }
				int exitCode = process.waitFor();
            	System.out.println("Command exited with code " + exitCode);
            }
            catch(NullPointerException | IOException | InterruptedException e) {
                e.printStackTrace();
            }finally {
            	if (process != null) {
                	process.destroy();
            	}
        	}
        } else { //if on windows
            Toolkit toolkit = Toolkit.getDefaultToolkit();
       	 	Clipboard clipboard = toolkit.getSystemClipboard();
        	contents = (String) clipboard.getData(DataFlavor.stringFlavor);  
        }
        println("Clipboard contents: ${contents}")
        return contents
    }
}