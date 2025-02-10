package actions.selenium

import actions.selenium.Browser

class SwitchWindow{
    
  public static run(def params){
  	println("In Switch Window")
   	int iTimeout = 20

    if(params."Window Name" == "Default Window"){
      Browser.Driver.switchTo().window(Browser.MainWinHandle)
      return
    }
    /*if(params."Close Current Tab"==true){
    	println("Tab closed")
      	Browser.Driver.close()
    }*/
    def handles = Browser.Driver.getWindowHandles();
    if(params."Window Name"){
    	while(iTimeout > 0){
        	for (handle in handles){
          		println(Browser.Driver.getTitle())
                Browser.Driver.switchTo().window(handle)
            	if (Browser.Driver.getTitle().contains("${params."Window Name"}")) {
          			return;
        		}
      		}
      	iTimeout--
      	sleep(1000)
    	}
        assert false,"Window: ${params."Window Name"} does not exist."
 	}
    else if(params."Tab (start from 0)"){
        println("Selecting another tab")
        def numOfTabs = handles.size()
        println("number of tabs ${numOfTabs}")
        def hanldesArray = handles.toArray(new String[numOfTabs])
        def tab = params."Tab (start from 0)".toInteger()
        Browser.Driver.switchTo().window(handles[tab])
    }
  }
}