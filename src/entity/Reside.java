package entity;

import java.io.Serializable;
import java.util.Date;

public class Reside implements Serializable{
	private Integer id;
	private SubscriptionDtl subscriptionDtl;
	private Date residedate;
	private String roomername;
	private String idcard;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SubscriptionDtl getSubscriptionDtl() {
		return subscriptionDtl;
	}
	public void setSubscriptionDtl(SubscriptionDtl subscriptionDtl) {
		this.subscriptionDtl = subscriptionDtl;
	}
	public Date getResidedate() {
		return residedate;
	}
	public void setResidedate(Date residedate) {
		this.residedate = residedate;
	}
	public String getRoomername() {
		return roomername;
	}
	public void setRoomername(String roomername) {
		this.roomername = roomername;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	@Override
	public String toString() {
		return "Reside [id=" + id + ", idcard=" + idcard + ", residedate="
				+ residedate + ", roomername=" + roomername
				+ ", subscriptionDtl=" + subscriptionDtl + "]";
	}
	
}
