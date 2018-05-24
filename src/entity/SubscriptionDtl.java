package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SubscriptionDtl implements Serializable{
	private Integer id;
	private Room room;
	private Subscription subscription;
	private Date sdate;
	private Date edate;
	private Integer residetype;
	private Double price;
	Set<Reside> resides= new HashSet<Reside>();
	public void addReside(Reside reside){
		resides.add(reside);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
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
	public Integer getResidetype() {
		return residetype;
	}
	public void setResidetype(Integer residetype) {
		this.residetype = residetype;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SubscriptionDtl [id=" + id + ", room=" + room
				+ ", subscription=" + subscription + ", sdate=" + sdate
				+ ", edate=" + edate + ", residetype=" + residetype
				+ ", price=" + price + ", resides=" + resides + "]";
	}
	

}
