package tw.org.ktrade.robot.po;

import java.io.Serializable;
import java.math.BigDecimal;

import tw.org.ktrade.robot.po.TradeLog;

public class TradeVo implements Serializable{

    private BigDecimal price;  //价格
    private BigDecimal amount; //数量
    private Long sortNum;     //交易ID，用于排序
    private Integer type;   //类型 1：buy 2：sell
    private String symbol;  //交易对名称
    private TradeLog trade;
    public TradeVo() {

    }

//    public TradeVo(BigDecimal price, BigDecimal amount, Long sortNum, Integer type, String symbol) {
//        this.price = price;
//        this.amount = amount;
//        this.sortNum = sortNum;
//        this.type = type;
//        this.symbol = symbol;
//    }
    public TradeVo(BigDecimal price, BigDecimal amount, Long sortNum, Integer type, String symbol,TradeLog trade) {
        this.price = price;
        this.amount = amount;
        this.sortNum = sortNum;
        this.type = type;
        this.symbol = symbol;
        this.trade=trade;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getSortNum() {
        return sortNum;
    }

    public void setSortNum(Long sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TradeLog getTrade() {
        return trade;
    }

    public void setTrade(TradeLog trade) {
        this.trade = trade;
    }

    @Override
    public String toString() {
        return "TradeVo{" +
                "price=" + price +
                ", sortNum=" + sortNum +
                ", amount=" + amount +
                ", type=" + type +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeVo tradeVo = (TradeVo) o;
        //如果序号相同就是为同一个对象
        return this.getSortNum().equals(tradeVo.getSortNum());
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + sortNum.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + symbol.hashCode();
        result = 31 * result + trade.hashCode();
        return result;
    }
}
