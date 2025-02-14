package actions.selenium

import actions.selenium.utils.Elements

class WaitForElement{
  public static void run (def params){
    
    int count = params."Timeout In Seconds".toInteger()
    while(count >= 0){
      def elements = Elements.findAll(params,Browser.Driver)
        println("Found ${elements.size()} elements")
      if(elements.size() > 0) break
        println("Waiting on element, ${count}... Found ${elements.size()} elements so far")
      sleep(1000)
      count--
    }
    if(count <= 0){
      assert false,"Element was not found in ${params."Timeout In Seconds"} seconds."
    }

  }
}