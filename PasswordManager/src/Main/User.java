package Main;

public class User {
    private int tem_num;
    private String page_id;
	private String page_password;
    private String page_name;
    private String page_email;
    private String singupdate;
    private String division;
    private String pageaddress;
    private String websitename;
    private String remarks;
	
    public User( int tem_num,String page_id, String page_password,String page_name,String page_email,String singupdate,
			String division,String pageaddress,String websitename,String remarks)
	{
		this.tem_num=tem_num;
		this.page_id=page_id;
		this.page_password=page_password;
		this.page_name=page_name;
		this.page_email=page_email;
		this.singupdate=singupdate;
		this.division=division;
		this.pageaddress=pageaddress;
		this.websitename = websitename;
		this.remarks =remarks;
	}
	   public String getWebsitename() {
		return websitename;
	}
	public void setWebsitename(String websitename) {
		this.websitename = websitename;
	}
	public int getTem_num() {
           return tem_num;
       }
       public void setTem_num(int tem_num) {
           this.tem_num = tem_num;
       }
       public String getPage_id() {
   		return page_id;
   	}
   	public void setPage_id(String page_id) {
   		this.page_id = page_id;
   	}
   	public String getPage_password() {
   		return page_password;
   	}
   	public void setPage_password(String page_password) {
   		this.page_password = page_password;
   	}
   	public String getPage_name() {
   		return page_name;
   	}
   	public void setPage_name(String page_name) {
   		this.page_name = page_name;
   	}
   	public String getPage_email() {
   		return page_email;
   	}
   	public void setPage_email(String page_email) {
   		this.page_email = page_email;
   	}
   	public String getSingupdate() {
   		return singupdate;
   	}
   	public void setSingupdate(String singupdate) {
   		this.singupdate = singupdate;
   	}
   	public String getDivision() {
   		return division;
   	}
   	public void setDivision(String division) {
   		this.division = division;
   	}
   	public String getPageaddress() {
   		return pageaddress;
   	}
   	public void setPageaddress(String pageaddress) {
   		this.pageaddress = pageaddress;
   	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

       
	
	
}
