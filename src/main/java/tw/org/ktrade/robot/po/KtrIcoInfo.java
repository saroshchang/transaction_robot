package tw.org.ktrade.robot.po;

import java.math.BigDecimal;

public class KtrIcoInfo {
	
	 private String icoType;

	    private BigDecimal privateValue;

	    private BigDecimal publicValue;

	    private BigDecimal expectSoftValue;

	    private BigDecimal expectHardValue;

	    private BigDecimal btcToIco;

	    private BigDecimal ethToIco;

	    private BigDecimal kcoinToIco;

	    private BigDecimal nulsToIco;

	    public String getIcoType() {
	        return icoType;
	    }

	    public void setIcoType(String icoType) {
	        this.icoType = icoType == null ? null : icoType.trim();
	    }

	    public BigDecimal getPrivateValue() {
	        return privateValue;
	    }

	    public void setPrivateValue(BigDecimal privateValue) {
	        this.privateValue = privateValue;
	    }

	    public BigDecimal getPublicValue() {
	        return publicValue;
	    }

	    public void setPublicValue(BigDecimal publicValue) {
	        this.publicValue = publicValue;
	    }

	    public BigDecimal getExpectSoftValue() {
	        return expectSoftValue;
	    }

	    public void setExpectSoftValue(BigDecimal expectSoftValue) {
	        this.expectSoftValue = expectSoftValue;
	    }

	    public BigDecimal getExpectHardValue() {
	        return expectHardValue;
	    }

	    public void setExpectHardValue(BigDecimal expectHardValue) {
	        this.expectHardValue = expectHardValue;
	    }

	    public BigDecimal getBtcToIco() {
	        return btcToIco;
	    }

	    public void setBtcToIco(BigDecimal btcToIco) {
	        this.btcToIco = btcToIco;
	    }

	    public BigDecimal getEthToIco() {
	        return ethToIco;
	    }

	    public void setEthToIco(BigDecimal ethToIco) {
	        this.ethToIco = ethToIco;
	    }

	    public BigDecimal getKcoinToIco() {
	        return kcoinToIco;
	    }

	    public void setKcoinToIco(BigDecimal kcoinToIco) {
	        this.kcoinToIco = kcoinToIco;
	    }

	    public BigDecimal getNulsToIco() {
	        return nulsToIco;
	    }

	    public void setNulsToIco(BigDecimal nulsToIco) {
	        this.nulsToIco = nulsToIco;
	    }
	
}