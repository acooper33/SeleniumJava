package actions.selenium

class NavigateToURL{
  
  public static void run(def params){
      
      def link
      if(params."Link Number In Case Of Multiple URL"){
          link = params.URL.split(",")[params."Link Number In Case Of Multiple URL".toInteger()]          
      } else {
          link = params.URL
      }
      println("link -> ${link}")
      Browser.Driver.navigate().to("${link}")
      println("Navigated to URL")
  }
}