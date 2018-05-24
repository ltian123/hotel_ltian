package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Subscription implements Serializable{
	private Integer id;
	private Member member;
	private String no;
	private String linkman;
	private String email;
	private String phone;
	private String status;
	private Date cretime;
	private String remark;
	Set<SubscriptionDtl> subscriptionDtls = new HashSet<SubscriptionDtl>();
	public void addSubscriptionDtl(SubscriptionDtl subscriptionDtl){
		subscriptionDtls.add(subscriptionDtl);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCretime() {
		return cretime;
	}
	public void setCretime(Date cretime) {
		this.cretime = cretime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Subscription [cretime=" + cretime + ", email=" + email
				+ ", id=" + id + ", linkman=" + linkman + ", member=" + member
				+ ", no=" + no + ", phone=" + phone + ", remark=" + remark
				+ ", status=" + status + "]";
	}
	
}
