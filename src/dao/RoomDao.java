package dao;

import java.util.List;

import vo.RoomCriteria;

import entity.Room;

public interface RoomDao {

	/**
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	public List<Room> selectAvailableRoom(RoomCriteria roomCriteria);
	
	/**
	 * 根据id 查找room
	 * @return
	 */
	public Room selectById(Integer id); 
	
	/**
	 * 单个房间
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	
	public List<Room> selectAvailableSingleRoom (RoomCriteria roomCriteria);
	
	/**
	 * 整个房间
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	
	public List<Room> selectAvailableWholeRoom (RoomCriteria roomCriteria);
	
	
}
