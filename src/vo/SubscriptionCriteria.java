package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscriptionCriteria {

	
	private Integer categoryId;
	private String subscriptionStatus;
	private Date sdate;
	private Date edate;
	private String startDate;
	private String endDate;
	private String subscriptionNo;
	private String username;
	
	
	public String  getStartDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(sdate);
	}
	public void setStartDate(String startDate){
				try {
					if("".equals(startDate)){
						this.sdate=null;
					}else{
					this.sdate=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
		
	public String  getEndDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(edate);
	}
	public void setEndDate(String startDate){
		try {
			if("".equals(startDate)){
				this.edate=null;
			}else{
			this.edate=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getSubscirptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscirptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getSubscriptionNo() {
		return subscriptionNo;
	}
	public void setSubscriptionNo(String subscriptionNo) {
		this.subscriptionNo = subscriptionNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	@Override
	public String toString() {
		return "SubscriptionCriteria [categoryId=" + categoryId + ", edate="
				+ edate + ", endDate=" + endDate + ", sdate=" + sdate
				+ ", startDate=" + startDate + ", subscirptionStatus="
				+ subscriptionStatus + ", subscriptionNo=" + subscriptionNo
				+ ", username=" + username + "]";
	}
	public SubscriptionCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
