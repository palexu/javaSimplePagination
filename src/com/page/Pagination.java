/**
 * 暂时不考虑在客户端修改分页数
 * 
 * @author xujunyu
 *
 */
package com.page;
public class Pagination {
	private int totalRecords;
	private int numPerPage;


	private int totalPages;//总页数
	private int offset;// 当前页的起始条数的前一条 也就是说，当offset为4时，那么页面将从第五条开始显示
	private int previousPage;// 下一页的起始条数
	private int nextPage;// 上一页的起始条数
	private int page;//当前页码
	
	
	/**
	 * 在初始化时接受参数，然后将所有需要使用到的参数全部赋值好 
	 * 在jsp页面需要判断nextPage和previousPage，如果为-1则不能点击
	 */
	public Pagination(int totalRecords, int offset, int numPerPage) {
		this.totalRecords = totalRecords;
		this.offset = offset;
		this.numPerPage = numPerPage;

		// 如果当前页之前还有大于numPerPage条数据，那么可以使用上一页
		if (offset - numPerPage > 0) {
			previousPage = offset - numPerPage;
		} else if (offset - numPerPage == 0) {// 如果当前页之前没有数据或小于numPerPage，那么从0开始
			previousPage = 0;
		} else {
			previousPage = -1;
		}

		// 如果当前页之后还有大于numPerPage条数据，那么可以使用下一页
		if (offset + numPerPage < totalRecords) {
			nextPage = offset + numPerPage;
		} else {// 如果当前页除去已显示的数据后，没有剩下，那么返回-1
			nextPage = -1;
		}
		
		this.page=offset/numPerPage+1;
		
		this.totalPages=getTotalPages(totalRecords,numPerPage);
		
	}
	
	@Override
	public String toString() {
		return "Pagination [totalRecords=" + totalRecords + ", numPerPage=" + numPerPage + ", totalPages=" + totalPages
				+ ", offset=" + offset + ", previousPage=" + previousPage + ", nextPage=" + nextPage + ", page=" + page
				+ "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private int getTotalPages(int Records,int n){
		int Pages;
		if(Records%n==0){
			Pages=Records/n;
		}else{
			Pages=Records/n+1;
		}
		return Pages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getoffset() {
		return offset;
	}

	public void setoffset(int offset) {
		this.offset = offset;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

}
