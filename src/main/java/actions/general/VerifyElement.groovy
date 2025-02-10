package actions.general;

import actions.selenium.Exists

class VerifyElement{
    public void run(def params){
                
        if(params."Number of Matches" ){
            println(params."Number of Matches".toInteger())
            def elements = Exists.run(ID:params.ID)
            if(params."Should Element Exist"==true){
                assert elements>0, "Error - Element does not exists"
                if(params."Number of Matches"){
                    assert elements == params."Number of Matches".toInteger(), "Error - Number of matches ${elements} is not expected ${params."Number of Matches".toInteger()}"
                }
            }else if(params."Should Element Exist"==false){
                assert elements==0, "Error - Element exists"
            }
        }
    }
}