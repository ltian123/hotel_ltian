package vo;

import java.io.Serializable;
import java.util.Date;

public class RoomCriteria implements Serializable{

	
	
	private String roomStatus;
	private Integer categoryId;
	private Integer residetype;
	private Date sdate;
	private Date edate;
	
	
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getResidetype() {
		return residetype;
	}
	public void setResidetype(Integer residetype) {
		this.residetype = residetype;
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
		return "RoomCriteria [categoryId=" + categoryId + ", edate=" + edate
				+ ", residetype=" + residetype + ", roomStatus=" + roomStatus
				+ ", sdate=" + sdate + "]";
	}
	
	
}
