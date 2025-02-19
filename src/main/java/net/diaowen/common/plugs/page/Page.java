/**
 * Copyright (c) 2005-2011 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: Page.java 1547 2011-05-05 14:43:07Z calvinxiu $
 */
package net.diaowen.common.plugs.page;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.common.collect.Lists;

/**
 * Pagination query result encapsulation
 *
 *
 */
public class Page<T> extends PageRequest implements Iterable<T> {

	protected List<T> result = null;
	protected long totalItems = -1;
	
	public Page() {
	}

	public Page(PageRequest request) {
		this.pageNo = request.pageNo;
		this.pageSize = request.pageSize;
		this.countTotal = request.countTotal;
		this.orderBy = request.orderBy;
		this.orderDir = request.orderDir;
	}

	/**
	 * Get the list of records within the page.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * Set the list of records within the page.
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * Get total number of records
	 */
	public long getTotalItems() {
		return totalItems;
	}

	/**
	 * Set total number of records
	 */
	public void setTotalItems(final long totalItems) {
		this.totalItems = totalItems;
//		getSlider(this.pageNoSize);
		setStartEndPageNo();
	}

	/** 
	 * Utilize the iterator
	 */
	@Override
	public Iterator<T> iterator() {
		return result.iterator();
	}

	/**
	 * get the totalpage number
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) totalItems / (double) getPageSize());

	}

	/**
	 * The next page function
	 */
	public boolean hasNextPage() {
		return (getPageNo() + 1 <= getTotalPages());
	}

	public boolean isLastPage() {
		return !hasNextPage();
	}

	/**
	 * obtain the next page
	 */
	public int getNextPage() {
		if (hasNextPage()) {
			return getPageNo() + 1;
		} else {
			return getPageNo();
		}
	}

	public boolean hasPrePage() {
		return (getPageNo() > 1);
	}

	public boolean isFirstPage() {
		return !hasPrePage();
	}


	public int getPrePage() {
		if (hasPrePage()) {
			return getPageNo() - 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * calcualte the page number
	 */
	public List<Integer> getSlider(int count) {
		int halfSize = count / 2;
		totalPage = getTotalPages();

		int startPageNo = Math.max(getPageNo() - halfSize, 1);
		int endPageNo = Math.min(startPageNo + count - 1, totalPage);

		if (endPageNo - startPageNo < count) {
			startPageNo = Math.max(endPageNo - count, 1);
		}

		List<Integer> result = Lists.newArrayList();
		for (int i = startPageNo; i <= endPageNo; i++) {
			result.add(i);
		}
		this.pageNos=result;
		return result;
	}
	
	private int startpage;
	private int endpage;
	
	public void setStartEndPageNo(){
		totalPage = getTotalPages();
		startpage = pageNo
				- (pageNoSize % 2 == 0 ? pageNoSize / 2 - 1
						: pageNoSize / 2);
		endpage = pageNo + pageNoSize / 2;
		if (startpage < 1) {
			startpage = 1;
			if (totalPage >= pageNoSize) {
				endpage = pageNoSize;
			} else {
				endpage = totalPage;
			}
		}
		if (endpage > totalPage) {
			endpage = totalPage;
			if ((endpage - pageNoSize) > 0) {
				startpage = endpage - pageNoSize + 1;
			} else {
				startpage = 1;
			}
		}
//		return new PageIndexUtil(startpage, endpage);
	}
	
	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
