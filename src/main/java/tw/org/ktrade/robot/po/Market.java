package tw.org.ktrade.robot.po;



import java.io.Serializable;
import java.math.BigDecimal;

public class Market {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     *  价格小数精度
     */
    private String round;
    /**
     *  数量小数精度
     */
    private String vround;
    /**
     * 买入费率
     */
    private String feeBuy;
    /**
     * 卖出费率
     */
    private String feeSell;
    /**
     * 最少买入
     */
    private String buyMin;
    /**
     * 最多买入
     */
    private String buyMax;
    /**
     * 最少卖出
     */
    private String sellMin;
    /**
     * 最多卖出
     */
    private String sellMax;
    /**
     * 最少交易
     */
    private String tradeMin;
    /**
     * 最大交易
     */
    private String tradeMax;
    /**
     *
     */
    private String invitBuy;
    /**
     *
     */
    private String invitSell;
    /**
     *
     */
    private String invit1;
    /**
     *
     */
    private String invit2;
    /**
     *
     */
    private String invit3;
    /**
     *
     */
    private String zhang;
    private String die;
    private String houPrice;
    private String tendency;

    private Integer trade;

    /**
     * 最新价格
     */
    private BigDecimal newPrice;
    /**
     * 买入价格
     */
    private BigDecimal buyPrice;
    /**
     * 卖出价格
     */
    private BigDecimal sellPrice;
    /**
     * 最小价格
     */
    private BigDecimal minPrice;
    /**
     * 最大价格
     */
    private BigDecimal maxPrice;
    /**
     *
     */
    private BigDecimal volume;
    /**
     *
     */
    private BigDecimal change;
    /**
     *
     */
    private BigDecimal apiMin;
    /**
     *
     */
    private BigDecimal apiMax;

    private String begintrade;
    private String endtrade;

    private Integer sort;
    private Long addtime;
    private Long endtime;
    private Integer status;

    /**
     * 这俩字段有毒啊
     */
    private Integer jiaoyiqu;
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
        this.name = name;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getVround() {
        return vround;
    }

    public void setVround(String vround) {
        this.vround = vround;
    }

    public String getFeeBuy() {
        return feeBuy;
    }

    public void setFeeBuy(String feeBuy) {
        this.feeBuy = feeBuy;
    }

    public String getFeeSell() {
        return feeSell;
    }

    public void setFeeSell(String feeSell) {
        this.feeSell = feeSell;
    }

    public String getBuyMin() {
        return buyMin;
    }

    public void setBuyMin(String buyMin) {
        this.buyMin = buyMin;
    }

    public String getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(String buyMax) {
        this.buyMax = buyMax;
    }

    public String getSellMin() {
        return sellMin;
    }

    public void setSellMin(String sellMin) {
        this.sellMin = sellMin;
    }

    public String getSellMax() {
        return sellMax;
    }

    public void setSellMax(String sellMax) {
        this.sellMax = sellMax;
    }

    public String getTradeMin() {
        return tradeMin;
    }

    public void setTradeMin(String tradeMin) {
        this.tradeMin = tradeMin;
    }

    public String getTradeMax() {
        return tradeMax;
    }

    public void setTradeMax(String tradeMax) {
        this.tradeMax = tradeMax;
    }

    public String getInvitBuy() {
        return invitBuy;
    }

    public void setInvitBuy(String invitBuy) {
        this.invitBuy = invitBuy;
    }

    public String getInvitSell() {
        return invitSell;
    }

    public void setInvitSell(String invitSell) {
        this.invitSell = invitSell;
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

    public String getZhang() {
        return zhang;
    }

    public void setZhang(String zhang) {
        this.zhang = zhang;
    }

    public String getDie() {
        return die;
    }

    public void setDie(String die) {
        this.die = die;
    }

    public String getHouPrice() {
        return houPrice;
    }

    public void setHouPrice(String houPrice) {
        this.houPrice = houPrice;
    }

    public String getTendency() {
        return tendency;
    }

    public void setTendency(String tendency) {
        this.tendency = tendency;
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
        this.begintrade = begintrade;
    }

    public String getEndtrade() {
        return endtrade;
    }

    public void setEndtrade(String endtrade) {
        this.endtrade = endtrade;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getAddtime() {
        return addtime;
    }

    public void setAddtime(Long addtime) {
        this.addtime = addtime;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getJiaoyiqu() {
        return jiaoyiqu;
    }

    public void setJiaoyiqu(Integer jiaoyiqu) {
        this.jiaoyiqu = jiaoyiqu;
    }

    public Float getFaxingjia() {
        return faxingjia;
    }

    public void setFaxingjia(Float faxingjia) {
        this.faxingjia = faxingjia;
    }
}