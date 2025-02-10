package actions.general;


class ReturnAffiliateName{
    public String run(def params){
        if(params."Affiliate URL"){
            return params."Affiliate URL".replaceAll("https://", "").substring(0,17)
         }
        
    }
}