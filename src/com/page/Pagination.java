/**
 * ��ʱ�������ڿͻ����޸ķ�ҳ��
 * 
 * @author xujunyu
 *
 */
package com.page;
public class Pagination {
	private int totalRecords;
	private int numPerPage;


	private int totalPages;//��ҳ��
	private int offset;// ��ǰҳ����ʼ������ǰһ�� Ҳ����˵����offsetΪ4ʱ����ôҳ�潫�ӵ�������ʼ��ʾ
	private int previousPage;// ��һҳ����ʼ����
	private int nextPage;// ��һҳ����ʼ����
	private int page;//��ǰҳ��
	
	
	/**
	 * �ڳ�ʼ��ʱ���ܲ�����Ȼ��������Ҫʹ�õ��Ĳ���ȫ����ֵ�� 
	 * ��jspҳ����Ҫ�ж�nextPage��previousPage�����Ϊ-1���ܵ��
	 */
	public Pagination(int totalRecords, int offset, int numPerPage) {
		this.totalRecords = totalRecords;
		this.offset = offset;
		this.numPerPage = numPerPage;

		// �����ǰҳ֮ǰ���д���numPerPage�����ݣ���ô����ʹ����һҳ
		if (offset - numPerPage > 0) {
			previousPage = offset - numPerPage;
		} else if (offset - numPerPage == 0) {// �����ǰҳ֮ǰû�����ݻ�С��numPerPage����ô��0��ʼ
			previousPage = 0;
		} else {
			previousPage = -1;
		}

		// �����ǰҳ֮���д���numPerPage�����ݣ���ô����ʹ����һҳ
		if (offset + numPerPage < totalRecords) {
			nextPage = offset + numPerPage;
		} else {// �����ǰҳ��ȥ����ʾ�����ݺ�û��ʣ�£���ô����-1
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
