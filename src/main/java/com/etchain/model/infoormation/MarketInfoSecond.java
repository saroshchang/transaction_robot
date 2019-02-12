package com.etchain.model.infoormation;

import java.util.Date;

/**
 * @auth ：zhanghua
 * 時間：2017/12/7.
 * 項目名稱 ：ktrade
 * 包名 ：com.etchain.model.infoormation
 * 功能描述 ：${DESCRIPTION}
 */
public class MarketInfoSecond extends MarketInfo{
    private String type;

    private Date createTime;

    public MarketInfoSecond(){
    }
    public MarketInfoSecond(MarketInfo marketInfo){
        this.dealTime = marketInfo.dealTime;
        this.kineTime = marketInfo.kineTime;
        this.firstPrice = marketInfo.firstPrice;
        this.lastPrice = marketInfo.lastPrice;
        this.topPrice = marketInfo.topPrice;
        this.lowPrice = marketInfo.lowPrice;
        this.count = marketInfo.count;
    }

    /**
     * 交易時間
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return new Date(this.getDealTime());
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
