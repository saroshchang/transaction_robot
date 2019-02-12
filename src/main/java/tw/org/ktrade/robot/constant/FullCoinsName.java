package tw.org.ktrade.robot.constant;

import org.apache.commons.lang3.StringUtils;

import freemarker.template.utility.StringUtil;

public enum FullCoinsName {
	
	fto("futurocoin"),nuls("nuls"),xrp("ripple"),btc("bitcoin"),hlc("halalchain")
	,eth("ethereum"),dash("dash"),xmr("monero"),twdt("twdt"),bch("bitcoin-cash");
	
	private String value;
	 
    private FullCoinsName(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return this.value;
    }
    
    public static String of(String coin){
    	FullCoinsName coins[] = FullCoinsName.values();
        for(FullCoinsName statu:coins){
            if(StringUtils.equals(statu.toString(), coin)){
                return statu.value;
            }
        }
        return null;
    }
}
