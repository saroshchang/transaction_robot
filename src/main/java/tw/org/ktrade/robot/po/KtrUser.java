package tw.org.ktrade.robot.po;

import java.util.Date;

public class KtrUser {
	
	private Integer id;

    private String username;

    private String moble;

    private String password;

    private String idcard;

    private String icoType;

    private Integer addtime;

    private Integer endtime;

    private Integer usertype;

    private String emailcode;

    private String city;

    private String province;

    private String zipCode;

    private Date createTime;

    private Date updateDate;

    private String currency;

    private String ga;

    private Boolean useotp;

    private Boolean firstLogin;

    private Boolean verifyEmail;

    private String sendConnwalletEthAddr;
    
    private String sendConnwalletTwdtAddr;

    private String countryCode;

    private String country;

    private String email;

    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble == null ? null : moble.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getIcoType() {
        return icoType;
    }

    public void setIcoType(String icoType) {
        this.icoType = icoType == null ? null : icoType.trim();
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getEmailcode() {
        return emailcode;
    }

    public void setEmailcode(String emailcode) {
        this.emailcode = emailcode == null ? null : emailcode.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga == null ? null : ga.trim();
    }

    public Boolean getUseotp() {
        return useotp;
    }

    public void setUseotp(Boolean useotp) {
        this.useotp = useotp;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Boolean getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(Boolean verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

	public String getSendConnwalletEthAddr() {
		return sendConnwalletEthAddr;
	}

	public void setSendConnwalletEthAddr(String sendConnwalletEthAddr) {
		this.sendConnwalletEthAddr = sendConnwalletEthAddr;
	}

	public String getSendConnwalletTwdtAddr() {
		return sendConnwalletTwdtAddr;
	}

	public void setSendConnwalletTwdtAddr(String sendConnwalletTwdtAddr) {
		this.sendConnwalletTwdtAddr = sendConnwalletTwdtAddr;
	}
	
}