package service;

import java.util.List;

import vo.RoomCriteria;

import entity.Category;
import entity.Room;

public interface RoomService {
	public List<Category> findAllCategory();
	
	
	/**
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	public List<Room> findAvailableRoom(RoomCriteria roomCriteria);
	/**
	 * 根据id 查找room
	 * @return
	 */
	public Room findById(Integer id);
	
	/**
	 * 单个房间
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	
	public List<Room> findAvailableSingleRoom (RoomCriteria roomCriteria);
	
	/**
	 * 整个房间
	 * 根据条件查询可入住的房间
	 * @param roomCriteria
	 * @return
	 */
	
	public List<Room> findAvailableWholeRoom (RoomCriteria roomCriteria);
	
	
}
