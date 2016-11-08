package cn.ping.domain;

public class QueryInfo {
	private int currentpage=1;
	private int pagesize=4;
	private int  startindex;
	
	private String where; //where = "where category_id=?"
	
	private String queryname;
	private String queryvalue;
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		startindex=(currentpage-1)*pagesize;
		return startindex;
	}

	

	public String getQueryname() {
		return queryname;
	}
	public void setQueryname(String queryname) {
		this.queryname = queryname;
	}
	public String getQueryvalue() {
		return queryvalue;
	}
	public void setQueryvalue(String queryvalue) {
		this.queryvalue = queryvalue;
	}
	
	
	public String getWhere() {
		if(this.queryname==null || this.queryname.trim().equals("")){
			return "";
		}else{
			// this.where = "where category_id=?"
			this.where = "where " + queryname + "=?";
		}
		return where;
	}	
	
}
