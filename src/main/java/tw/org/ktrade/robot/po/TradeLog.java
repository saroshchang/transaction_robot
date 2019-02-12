package tw.org.ktrade.robot.po;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;



/**
 * @author ：zhanghua
 * 时间：2017/12/1.
 * 项目名称 ：ktrade
 * 包名 ：com.etchain.model.deal
 * 功能描述 ：成交记录
 */
public class TradeLog {
	 @Id
    private long id;
    /**
     * 买或卖方ID
     */
    private Integer userid;

    /**
     * 交易方ID
     */
    private Integer peerid;
    /**
     * 市场交易对
     */
    private String market;
    /**
     * 成交价
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal num;

    /**
     * 交易总价格
     */
    private BigDecimal mum;
    /**
     * 买入费用
     */
    private BigDecimal feeBuy;
    /**
     * 卖出费用
     */
    private BigDecimal feeSell;
    /**
     * 交易类型
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 开始时间
     */
    private Long addtime;
    /**
     * 结束时间
     */
    private Long endtime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 挂单ID
     */
    private Long tradeId;
    /**
     * 流水号
     */
    private Long serialNumber;
    
    /**
     * 新增排序字段
     */
    private Long sortNum;
    
    private String _class;
    
    private Long totalCount;
    
    private int DEF_COUNT;
    
    private int currentPage;
    
    private String desc;
//    "totalCount" : NumberLong(0),
//    "DEF_COUNT" : 10,
//    "currentPage" : 0,
//    "direction" : "desc"	
    
    private BigDecimal fee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPeerid() {
        return peerid;
    }

    public void setPeerid(Integer peerid) {
        this.peerid = peerid;
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

    public BigDecimal getMum() {
        return mum;
    }

    public void setMum(BigDecimal mum) {
        this.mum = mum;
    }

    public BigDecimal getFeeBuy() {
        return feeBuy;
    }

    public void setFeeBuy(BigDecimal feeBuy) {
        this.feeBuy = feeBuy;
    }

    public BigDecimal getFeeSell() {
        return feeSell;
    }

    public void setFeeSell(BigDecimal feeSell) {
        this.feeSell = feeSell;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    

    public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Long getSortNum() {
		return sortNum;
	}

	public void setSortNum(Long sortNum) {
		this.sortNum = sortNum;
	}

	public String get_class() {
		return _class;
	}

	public void set_class(String _class) {
		this._class = _class;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getDEF_COUNT() {
		return DEF_COUNT;
	}

	public void setDEF_COUNT(int dEF_COUNT) {
		DEF_COUNT = dEF_COUNT;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
    
}
