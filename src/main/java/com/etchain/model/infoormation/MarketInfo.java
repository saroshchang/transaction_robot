package com.etchain.model.infoormation;

import java.math.BigDecimal;

import com.etchain.base.entity.BaseEntity;

/**
 * @author ：zhanghua
 * 時間：2017/12/5.
 * 項目名稱 ：ktrade
 * 包名 ：tw.org.ktrade.robot.po
 * 功能描述 ：市場行情
 */
public class MarketInfo extends BaseEntity{
    /**
     * 交易時間
     */
    protected Long dealTime;

    /**
     * redis_Key標識時間
     */
    protected String kineTime;
    /**
     * 開盤價
     */
    protected BigDecimal firstPrice;
    /**
     * 收盤價
     */
    protected BigDecimal lastPrice;
    /**
     * 最高價
     */
    protected BigDecimal topPrice;
    /**
     * 最低價
     */
    protected BigDecimal lowPrice;

    /**
     * 成交數量
     */
    protected BigDecimal count;



    public Long getDealTime() {
        return dealTime;
    }

    public void setDealTime(Long dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public String getKineTime() {
        return kineTime;
    }

    public void setKineTime(String kineTime) {
        this.kineTime = kineTime;
    }

}
