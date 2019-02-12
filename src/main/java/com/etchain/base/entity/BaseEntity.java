package com.etchain.base.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 由於反序列化，所以必須用com.etchain.....這兩個package，才能在交易所上使用
 * @author Sarosh
 * 
 */
public abstract class BaseEntity extends Entity implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9213313747215751818L;

	/**
	 * 創建信息者----一般為系統登陸者
	 */
	protected String insertBy;

	/**
	 * 創建信息時間----例如：當前系統時間
	 */
	protected Date insertDate;

	/**
	 * 更新信息者----一般為系統登陸者
	 */
	protected String modifiedBy;
	
	/**
	 * 日期類型
	 */
	private Integer timeType;
	
	/**
	 * 查詢集合參數
	 */
	protected List<String> parameList;
	
	protected Boolean effectivity;
	
	/**
	 * 更新信息時間
	 */
	protected Date modifiedDate;
	protected String orderBy;
	/**
	 * 版本號
	 * <p>
	 * 不存儲在數據庫中
	 * </p>
	 */
	private String version = "1.0.0";

	private Date startTime;
	
	private Date endTime;
	
	public String getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<String> getParameList() {
		return parameList;
	}

	public void setParameList(List<String> parameList) {
		this.parameList = parameList;
	}

	public Boolean getEffectivity() {
		return effectivity;
	}

	public void setEffectivity(Boolean effectivity) {
		this.effectivity = effectivity;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		if(endTime!=null){
			
			String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(endTime);
			dateStr +=" 23:59:59";
			try {
				endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		this.endTime = endTime;
	}
	
}
