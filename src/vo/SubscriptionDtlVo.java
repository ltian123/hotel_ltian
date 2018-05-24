package vo;

import java.util.Date;

public class SubscriptionDtlVo {

	private Integer id;
	private Integer sid;
	private String categoryName;
	private String roomNo;
	private String residetype;
	private double price;
	private Date sdate;
	private Date edate;
	
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getResidetype() {
		return residetype;
	}
	public void setResidetype(String residetype) {
		this.residetype = residetype;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	@Override
	public String toString() {
		return "SubscriptionDtlVo [categoryName=" + categoryName + ", roomNo="
				+ roomNo + ", residetype=" + residetype + ", price=" + price
				+ ", sdate=" + sdate + ", edate=" + edate + "]";
	}
	
	
	
}
