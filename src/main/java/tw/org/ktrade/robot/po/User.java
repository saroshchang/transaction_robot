package tw.org.ktrade.robot.po;

public class User{
    /**
     * 主键
     */
    private Integer id;

    private String username;

    private String moble;

    private Integer mobletime;

    private String password;
    /**
     * 交易密码输入设置
     */
    private String tpwdsetting;

    private String paypassword;
    private String invit1;
    private String invit2;
    private String invit3;
    private String truename;
    /**
     * 证件号
     */
    private String idcard;
    /**
     * 是否实名认证，0，未提交；1，未审核（已提交），2：审核未通过，3：审核通过；
     */
    private Integer idcardauth;
    /**
     * 证件类型1,台湾身份证；2，护照；3，内地身份证
     */
    private Integer idcardtype;

    private String idcardimg1;
    private String idcardimg2;
    private String idcardimg3;
    private String idcardinfo;
    /**
     * 国家
     */
    private String country;
    /**
     * 市
     */
    private String city;
    /**
     * 省
     */
    private String province;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 街道地址
     */
    private String streetAddr;

    private Integer logins;

    private String ga;
    /**
     * 是否进行二次登录保护
     */
    private Integer bothProtect;

    private String addip;
    private String addr;

    private Integer sort;
    private Integer addtime;
    private Integer endtime;

    private Integer status;

    private String email;
    private String alipay;
    private String invit;
    private String token;

    private Integer awardid;

    private Integer awardstatus;

    private String awardname;

    private Integer awardNumAll;
    private Integer awardNumToday;
    private Integer awardTotalToday;
    private Integer awardtime;

    private Integer regaward;
    private Integer usertype;

    private String emailcode;
    private String emailverify;
    private String emailexpiretime;

    private Integer isInvitgroupuser;
    private Integer isInvit;
    private Integer allowTrade;
    private Integer allowInto;
    private Integer allowOut;
    private Integer autoInto;

    private String autoIntoVal;
    private String edittime;

    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getIsInvitgroupuser() {
        return isInvitgroupuser;
    }

    public void setIsInvitgroupuser(Integer isInvitgroupuser) {
        this.isInvitgroupuser = isInvitgroupuser;
    }

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
        this.username = username;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    public Integer getMobletime() {
        return mobletime;
    }

    public void setMobletime(Integer mobletime) {
        this.mobletime = mobletime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTpwdsetting() {
        return tpwdsetting;
    }

    public void setTpwdsetting(String tpwdsetting) {
        this.tpwdsetting = tpwdsetting;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public String getInvit1() {
        return invit1;
    }

    public void setInvit1(String invit1) {
        this.invit1 = invit1;
    }

    public String getInvit2() {
        return invit2;
    }

    public void setInvit2(String invit2) {
        this.invit2 = invit2;
    }

    public String getInvit3() {
        return invit3;
    }

    public void setInvit3(String invit3) {
        this.invit3 = invit3;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getIdcardauth() {
        return idcardauth;
    }

    public void setIdcardauth(Integer idcardauth) {
        this.idcardauth = idcardauth;
    }

    public Integer getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(Integer idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getIdcardimg1() {
        return idcardimg1;
    }

    public void setIdcardimg1(String idcardimg1) {
        this.idcardimg1 = idcardimg1;
    }

    public String getIdcardimg2() {
        return idcardimg2;
    }

    public void setIdcardimg2(String idcardimg2) {
        this.idcardimg2 = idcardimg2;
    }

    public String getIdcardimg3() {
        return idcardimg3;
    }

    public void setIdcardimg3(String idcardimg3) {
        this.idcardimg3 = idcardimg3;
    }

    public String getIdcardinfo() {
        return idcardinfo;
    }

    public void setIdcardinfo(String idcardinfo) {
        this.idcardinfo = idcardinfo;
    }

    public Integer getLogins() {
        return logins;
    }

    public void setLogins(Integer logins) {
        this.logins = logins;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public Integer getBothProtect() {
        return bothProtect;
    }

    public void setBothProtect(Integer bothProtect) {
        this.bothProtect = bothProtect;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getInvit() {
        return invit;
    }

    public void setInvit(String invit) {
        this.invit = invit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getAwardid() {
        return awardid;
    }

    public void setAwardid(Integer awardid) {
        this.awardid = awardid;
    }

    public Integer getAwardstatus() {
        return awardstatus;
    }

    public void setAwardstatus(Integer awardstatus) {
        this.awardstatus = awardstatus;
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }

    public Integer getAwardNumAll() {
        return awardNumAll;
    }

    public void setAwardNumAll(Integer awardNumAll) {
        this.awardNumAll = awardNumAll;
    }

    public Integer getAwardNumToday() {
        return awardNumToday;
    }

    public void setAwardNumToday(Integer awardNumToday) {
        this.awardNumToday = awardNumToday;
    }

    public Integer getAwardTotalToday() {
        return awardTotalToday;
    }

    public void setAwardTotalToday(Integer awardTotalToday) {
        this.awardTotalToday = awardTotalToday;
    }

    public Integer getAwardtime() {
        return awardtime;
    }

    public void setAwardtime(Integer awardtime) {
        this.awardtime = awardtime;
    }

    public Integer getRegaward() {
        return regaward;
    }

    public void setRegaward(Integer regaward) {
        this.regaward = regaward;
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
        this.emailcode = emailcode;
    }

    public String getEmailverify() {
        return emailverify;
    }

    public void setEmailverify(String emailverify) {
        this.emailverify = emailverify;
    }

    public String getEmailexpiretime() {
        return emailexpiretime;
    }

    public void setEmailexpiretime(String emailexpiretime) {
        this.emailexpiretime = emailexpiretime;
    }

    public Integer getIsInvit() {
        return isInvit;
    }

    public void setIsInvit(Integer isInvit) {
        this.isInvit = isInvit;
    }

    public Integer getAllowTrade() {
        return allowTrade;
    }

    public void setAllowTrade(Integer allowTrade) {
        this.allowTrade = allowTrade;
    }

    public Integer getAllowInto() {
        return allowInto;
    }

    public void setAllowInto(Integer allowInto) {
        this.allowInto = allowInto;
    }

    public Integer getAllowOut() {
        return allowOut;
    }

    public void setAllowOut(Integer allowOut) {
        this.allowOut = allowOut;
    }

    public Integer getAutoInto() {
        return autoInto;
    }

    public void setAutoInto(Integer autoInto) {
        this.autoInto = autoInto;
    }

    public String getAutoIntoVal() {
        return autoIntoVal;
    }

    public void setAutoIntoVal(String autoIntoVal) {
        this.autoIntoVal = autoIntoVal;
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
    }
}