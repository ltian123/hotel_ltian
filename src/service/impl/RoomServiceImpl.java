package service.impl;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;

import service.RoomService;
import vo.RoomCriteria;
import dao.CategoryDao;
import dao.RoomDao;
import entity.Category;
import entity.Room;
import factory.ObjectFactory;

public class RoomServiceImpl implements RoomService {

	public List<Category> findAllCategory() {
		CategoryDao categoryDao=(CategoryDao) ObjectFactory.getObject("categoryDao");
		return categoryDao.selectAll();
	}

	public List<Room> findAvailableRoom(RoomCriteria roomCriteria) {
		RoomDao roomDao=(RoomDao) ObjectFactory.getObject("roomDao");
		List<Room> rooms = new ArrayList<Room>();
		rooms = roomDao.selectAvailableRoom(roomCriteria);
		return rooms;
	}

	public Room findById(Integer id) {
		RoomDao roomDao=(RoomDao) ObjectFactory.getObject("roomDao");
		return roomDao.selectById(id);
	}

	public List<Room> findAvailableSingleRoom(RoomCriteria roomCriteria) {
		RoomDao roomDao=(RoomDao) ObjectFactory.getObject("roomDao");
		List<Room> rooms = new ArrayList<Room>();
		roomCriteria.setRoomStatus(Constant.ROOM_STATUS_OPEN);
		rooms = roomDao.selectAvailableSingleRoom(roomCriteria);
		return rooms;
	}

	public List<Room> findAvailableWholeRoom(RoomCriteria roomCriteria) {
		RoomDao roomDao=(RoomDao) ObjectFactory.getObject("roomDao");
		List<Room> rooms = new ArrayList<Room>();
		roomCriteria.setRoomStatus(Constant.ROOM_STATUS_OPEN);
		rooms = roomDao.selectAvailableWholeRoom(roomCriteria);
		return rooms;
	}


}
