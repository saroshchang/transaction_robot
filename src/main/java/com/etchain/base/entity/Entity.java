/**
 * 
 */
package com.etchain.base.entity;

import org.apache.commons.lang3.StringUtils;
/**
 * @author zhanghua
 * 
 */
public abstract class Entity implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852540751755466319L;

	/**
	 * 每頁顯示的條數
	 */
	private int pageSize = 10;

	/**
	 * 總條數
	 */
	private long totalCount = 0;

	/**
	 * 每頁默認條數
	 */
	private int DEF_COUNT = 10;

	/**
	 * 遊標位置
	 */
	private Integer currentPage = 0;

	/**
	 * 排序字段
	 */
	private String orderCols;

	/**
	 * 默認排序
	 */
	private String direction = "desc";

	/**
	 * 升序
	 */
	private static final String DIRECTION_ASC = "asc";

	/**
	 * 降序
	 */
	private static final String DIRECTION_DESC = "desc";

	private Integer limitBefore;

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		if (StringUtils.isEmpty(direction)
				|| direction.equalsIgnoreCase(DIRECTION_ASC)) {
			return DIRECTION_ASC;
		}
		return DIRECTION_DESC;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the orderCols
	 */
	public String getOrderCols() {
		return orderCols;
	}

	/**
	 * @param orderCols
	 *            the orderCols to set
	 */
	public void setOrderCols(String orderCols) {
		this.orderCols = orderCols;
	}

	/**
	 * @return the dEF_COUNT
	 */
	public int getDEF_COUNT() {
		if (getPageSize() > 0) {
			return pageSize;
		} else {
			return DEF_COUNT;
		}
	}

	/**
	 * @param def_count
	 *            the dEF_COUNT to set
	 */
	public void setDEF_COUNT(int def_count) {
		DEF_COUNT = def_count;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCurrentPage() {
		if(currentPage==null ||  currentPage<1){
			currentPage = 1;
		}
		return currentPage;
	}

	public Integer getLimitBefore() {
		Integer limitBefore = (getCurrentPage() - 1) * getPageSize();
		return limitBefore;
	}

	public void setLimitBefore(Integer limitBefore) {
		this.limitBefore = limitBefore;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
