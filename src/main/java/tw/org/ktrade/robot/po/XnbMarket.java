package tw.org.ktrade.robot.po;

import java.math.BigDecimal;

public class XnbMarket {
    private Integer id;

    private String name;

    private String feeBuy;

    private String round;

    private String vround;

    private String feeSell;

    private String buyMin;

    private String buyMax;

    private String sellMin;

    private String sellMax;

    private String tradeMin;

    private String tradeMax;

    private String invitBuy;

    private String invitSell;

    private String invit1;

    private String invit2;

    private String invit3;

    private String zhang;

    private String die;

    private String houPrice;

    private String tendency;

    private Integer trade;

    private BigDecimal newPrice;

    private BigDecimal buyPrice;

    private BigDecimal sellPrice;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private BigDecimal volume;

    private BigDecimal change;

    private BigDecimal apiMin;

    private BigDecimal apiMax;

    private String begintrade;

    private String endtrade;

    private Integer sort;

    private Integer addtime;

    private Integer endtime;

    private Byte status;

    private Boolean jiaoyiqu;

    private Float faxingjia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFeeBuy() {
        return feeBuy;
    }

    public void setFeeBuy(String feeBuy) {
        this.feeBuy = feeBuy == null ? null : feeBuy.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public String getVround() {
        return vround;
    }

    public void setVround(String vround) {
        this.vround = vround == null ? null : vround.trim();
    }

    public String getFeeSell() {
        return feeSell;
    }

    public void setFeeSell(String feeSell) {
        this.feeSell = feeSell == null ? null : feeSell.trim();
    }

    public String getBuyMin() {
        return buyMin;
    }

    public void setBuyMin(String buyMin) {
        this.buyMin = buyMin == null ? null : buyMin.trim();
    }

    public String getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(String buyMax) {
        this.buyMax = buyMax == null ? null : buyMax.trim();
    }

    public String getSellMin() {
        return sellMin;
    }

    public void setSellMin(String sellMin) {
        this.sellMin = sellMin == null ? null : sellMin.trim();
    }

    public String getSellMax() {
        return sellMax;
    }

    public void setSellMax(String sellMax) {
        this.sellMax = sellMax == null ? null : sellMax.trim();
    }

    public String getTradeMin() {
        return tradeMin;
    }

    public void setTradeMin(String tradeMin) {
        this.tradeMin = tradeMin == null ? null : tradeMin.trim();
    }

    public String getTradeMax() {
        return tradeMax;
    }

    public void setTradeMax(String tradeMax) {
        this.tradeMax = tradeMax == null ? null : tradeMax.trim();
    }

    public String getInvitBuy() {
        return invitBuy;
    }

    public void setInvitBuy(String invitBuy) {
        this.invitBuy = invitBuy == null ? null : invitBuy.trim();
    }

    public String getInvitSell() {
        return invitSell;
    }

    public void setInvitSell(String invitSell) {
        this.invitSell = invitSell == null ? null : invitSell.trim();
    }

    public String getInvit1() {
        return invit1;
    }

    public void setInvit1(String invit1) {
        this.invit1 = invit1 == null ? null : invit1.trim();
    }

    public String getInvit2() {
        return invit2;
    }

    public void setInvit2(String invit2) {
        this.invit2 = invit2 == null ? null : invit2.trim();
    }

    public String getInvit3() {
        return invit3;
    }

    public void setInvit3(String invit3) {
        this.invit3 = invit3 == null ? null : invit3.trim();
    }

    public String getZhang() {
        return zhang;
    }

    public void setZhang(String zhang) {
        this.zhang = zhang == null ? null : zhang.trim();
    }

    public String getDie() {
        return die;
    }

    public void setDie(String die) {
        this.die = die == null ? null : die.trim();
    }

    public String getHouPrice() {
        return houPrice;
    }

    public void setHouPrice(String houPrice) {
        this.houPrice = houPrice == null ? null : houPrice.trim();
    }

    public String getTendency() {
        return tendency;
    }

    public void setTendency(String tendency) {
        this.tendency = tendency == null ? null : tendency.trim();
    }

    public Integer getTrade() {
        return trade;
    }

    public void setTrade(Integer trade) {
        this.trade = trade;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getApiMin() {
        return apiMin;
    }

    public void setApiMin(BigDecimal apiMin) {
        this.apiMin = apiMin;
    }

    public BigDecimal getApiMax() {
        return apiMax;
    }

    public void setApiMax(BigDecimal apiMax) {
        this.apiMax = apiMax;
    }

    public String getBegintrade() {
        return begintrade;
    }

    public void setBegintrade(String begintrade) {
        this.begintrade = begintrade == null ? null : begintrade.trim();
    }

    public String getEndtrade() {
        return endtrade;
    }

    public void setEndtrade(String endtrade) {
        this.endtrade = endtrade == null ? null : endtrade.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getJiaoyiqu() {
        return jiaoyiqu;
    }

    public void setJiaoyiqu(Boolean jiaoyiqu) {
        this.jiaoyiqu = jiaoyiqu;
    }

    public Float getFaxingjia() {
        return faxingjia;
    }

    public void setFaxingjia(Float faxingjia) {
        this.faxingjia = faxingjia;
    }
}