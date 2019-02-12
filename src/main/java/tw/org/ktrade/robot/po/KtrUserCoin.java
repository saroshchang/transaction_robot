package tw.org.ktrade.robot.po;

import java.math.BigDecimal;
import java.util.Date;

public class KtrUserCoin {
	
	 private Integer id;

	    private Integer userid;

	    private BigDecimal btc;

	    private BigDecimal btcd;

	    private String btcb;

	    private String secretKey;

	    private String passWord;

	    private BigDecimal eth;

	    private BigDecimal ethd;

	    private String ethb;

	    private BigDecimal kcoin;

	    private BigDecimal kcoind;

	    private String kcoinb;

	    private BigDecimal twdt;

	    private BigDecimal twdtd;

	    private String twdtb;

	    private BigDecimal usdt;

	    private BigDecimal usdtd;

	    private String usdtb;

	    

	    private Date createTime;

	    private Date updateDate;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getUserid() {
	        return userid;
	    }

	    public void setUserid(Integer userid) {
	        this.userid = userid;
	    }

	    public BigDecimal getBtc() {
	        return btc;
	    }

	    public void setBtc(BigDecimal btc) {
	        this.btc = btc;
	    }

	    public BigDecimal getBtcd() {
	        return btcd;
	    }

	    public void setBtcd(BigDecimal btcd) {
	        this.btcd = btcd;
	    }

	    public String getBtcb() {
	        return btcb;
	    }

	    public void setBtcb(String btcb) {
	        this.btcb = btcb == null ? null : btcb.trim();
	    }

	    public String getSecretKey() {
	        return secretKey;
	    }

	    public void setSecretKey(String secretKey) {
	        this.secretKey = secretKey == null ? null : secretKey.trim();
	    }

	    public String getPassWord() {
	        return passWord;
	    }

	    public void setPassWord(String passWord) {
	        this.passWord = passWord == null ? null : passWord.trim();
	    }

	    public BigDecimal getEth() {
	        return eth;
	    }

	    public void setEth(BigDecimal eth) {
	        this.eth = eth;
	    }

	    public BigDecimal getEthd() {
	        return ethd;
	    }

	    public void setEthd(BigDecimal ethd) {
	        this.ethd = ethd;
	    }

	    public String getEthb() {
	        return ethb;
	    }

	    public void setEthb(String ethb) {
	        this.ethb = ethb == null ? null : ethb.trim();
	    }

	    public BigDecimal getKcoin() {
	        return kcoin;
	    }

	    public void setKcoin(BigDecimal kcoin) {
	        this.kcoin = kcoin;
	    }

	    public BigDecimal getKcoind() {
	        return kcoind;
	    }

	    public void setKcoind(BigDecimal kcoind) {
	        this.kcoind = kcoind;
	    }

	    public String getKcoinb() {
	        return kcoinb;
	    }

	    public void setKcoinb(String kcoinb) {
	        this.kcoinb = kcoinb == null ? null : kcoinb.trim();
	    }

	    

	    public BigDecimal getTwdt() {
			return twdt;
		}

		public void setTwdt(BigDecimal twdt) {
			this.twdt = twdt;
		}

		public BigDecimal getTwdtd() {
			return twdtd;
		}

		public void setTwdtd(BigDecimal twdtd) {
			this.twdtd = twdtd;
		}

		public String getTwdtb() {
			return twdtb;
		}

		public void setTwdtb(String twdtb) {
			this.twdtb = twdtb;
		}

		public BigDecimal getUsdt() {
			return usdt;
		}

		public void setUsdt(BigDecimal usdt) {
			this.usdt = usdt;
		}

		public BigDecimal getUsdtd() {
			return usdtd;
		}

		public void setUsdtd(BigDecimal usdtd) {
			this.usdtd = usdtd;
		}

		public String getUsdtb() {
			return usdtb;
		}

		public void setUsdtb(String usdtb) {
			this.usdtb = usdtb;
		}

		public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }

	    public Date getUpdateDate() {
	        return updateDate;
	    }

	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;
	    }
	
}