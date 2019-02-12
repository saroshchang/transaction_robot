package tw.org.ktrade.robot.po;

import java.math.BigDecimal;

public class RobotTrade {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 交易方ID
     */
    private Integer userId;
    /**
     * 市场交易对
     */
    private String market;
    /**
     * 交易成交价
     */
    private BigDecimal price;
    /**
     * 挂单数量
     */
    private BigDecimal num;
    /**
     * 已成交数量
     */
    private BigDecimal deal;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 需要消耗的资产总量
     */
    private BigDecimal mum;
    private Integer sort;
    /**
     * 1，买入；2，卖出
     */
    private Integer type;

    private Long addtime;

    private Long endtime;
    /**
     * 0，挂单；1，成交；2，撤单。
     */
    private Integer status;
    /**
     * 新增排序字段
     */
    private Long sortNum;

    private String feeType;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getDeal() {
        return deal;
    }

    public void setDeal(BigDecimal deal) {
        this.deal = deal;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMum() {
        return mum;
    }

    public void setMum(BigDecimal mum) {
        this.mum = mum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Long getSortNum() {
        return sortNum;
    }

    public void setSortNum(Long sortNum) {
        this.sortNum = sortNum;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
}