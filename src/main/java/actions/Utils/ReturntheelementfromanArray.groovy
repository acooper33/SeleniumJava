package actions.Utils;

class ReturntheelementfromanArray{
    public static run(def params){
                
        def listElement = params."List".split(",\\|\\|\\|,")
        println(listElement[params."Element Location Number".toInteger()])
        def listEle = listElement[params."Element Location Number".toInteger()] 
        return listEle
    }
}