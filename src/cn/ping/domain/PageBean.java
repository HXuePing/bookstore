package cn.ping.domain;

import java.util.List;

public class PageBean {
	private int currentpage;
	private List list;
	private int totalrecord;
	private int totalpage;
	private int pagesize;
	private int previouspage;
	private int nextpage;
	private int pagebar[];
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getTotalpage() {
		if(this.totalrecord%this.pagesize==0){
			this.totalpage=this.totalrecord/this.pagesize;
		}else{
			this.totalpage=this.totalrecord/this.pagesize+1;
		}
		return totalpage;
	}
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPrevioutpage() {
		if(this.previouspage-1<1){
			this.previouspage=1;
		}else{
			this.previouspage=this.currentpage-1;
		}		
		return previouspage;
	}
	
	public int getNextpage() {
		if(this.nextpage+1>this.totalpage){
			this.nextpage=this.totalpage;
		}else{
			this.nextpage=this.currentpage+1;
		}		
		return nextpage;
	}
	
public int[] getPagebar() {
		
		int startpage;
		int endpage;
		if(this.totalpage<=10){
			startpage = 1;
			endpage = this.totalpage;
		}else{
			startpage = this.currentpage -4;
			endpage = this.currentpage + 5;
			
			if(startpage<1){
				startpage = 1;
				endpage = 10;
			}
			if(endpage>totalpage){
				endpage = totalpage;
				startpage = totalpage -9;
			}
		}
		
		this.pagebar = new int[endpage-startpage+1];  //1  3
		int index = 0;
		for(int i=startpage;i<=endpage;i++){
			this.pagebar[index++] = i;
		}
		return pagebar;
	}
	
}
