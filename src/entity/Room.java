package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Room implements Serializable{
	private Integer id;
	private Category category;
	private String no;
	private String status;
	Set<SubscriptionDtl> subscriptionDtls= new HashSet<SubscriptionDtl>();
	public void addSubscription(SubscriptionDtl subscriptionDtl){
		subscriptionDtls.add(subscriptionDtl);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<SubscriptionDtl> getSubscriptionDtls() {
		return subscriptionDtls;
	}
	public void setSubscriptionDtls(Set<SubscriptionDtl> subscriptionDtls) {
		this.subscriptionDtls = subscriptionDtls;
	}
	@Override
	public String toString() {
		return "Room [category=" + category + ", id=" + id + ", no=" + no
				+ ", status=" + status + ", subscriptionDtls="
				+ subscriptionDtls + "]";
	}
	
}
