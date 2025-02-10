package actions.Utils;

class SystemManagerHelper{
    
	private static systemid =  null
    private static affiliatename = null
    private static affiliateid = null
    private static affiliateURL = null
        
    public static void setAffiliateURL(String value) {
    	this.affiliateURL = value;
    }
    public static void setSystemId(String value) {
    	this.systemid = value;
    }
    public static void setAffiliatename(String value) {
        this.affiliatename = value;
    }
    public static void setAffiliateId(String value) {
    	this.affiliateid = value;
    }
    
    public static String getSystemId() {
    	return this.systemid
    }
    public static String getAffiliatename() {
        return this.affiliatename
    }
    public static String getAffiliateId() {
    	return this.affiliateid
    } 
    public static String getAffiliateURL() {
    	return this.affiliateURL
    }
}