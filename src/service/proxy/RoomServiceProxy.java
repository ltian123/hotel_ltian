package service.proxy;

import java.util.ArrayList;
import java.util.List;

import service.RoomService;
import transaction.TransactionManager;
import vo.RoomCriteria;
import entity.Category;
import entity.Room;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;

public class RoomServiceProxy implements RoomService {
	
	private RoomService roomService;
	
	public RoomServiceProxy() {
		roomService=(RoomService) ObjectFactory.getObject("roomServiceTarget");
		
	}

	public List<Category> findAllCategory() {
		List<Category> categories=new ArrayList<Category>();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			categories=roomService.findAllCategory();
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return categories;
	}

	public List<Room> findAvailableRoom(RoomCriteria roomCriteria) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Room> rooms = new ArrayList<Room>();
		try {
			transactionManager.beginTransaction();
			
			rooms = roomService.findAvailableRoom(roomCriteria);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return rooms;
	}

	public Room findById(Integer id) {
		
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		Room room = new Room();
		try {
			transactionManager.beginTransaction();
			
			room = roomService.findById(id);

			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return room;
	}

	public List<Room> findAvailableSingleRoom(RoomCriteria roomCriteria) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Room> rooms = new ArrayList<Room>();
		try {
			transactionManager.beginTransaction();
			
			rooms = roomService.findAvailableSingleRoom(roomCriteria);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return rooms;
	}

	public List<Room> findAvailableWholeRoom(RoomCriteria roomCriteria) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		List<Room> rooms = new ArrayList<Room>();
		try {
			transactionManager.beginTransaction();
			
			rooms = roomService.findAvailableWholeRoom(roomCriteria);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return rooms;
	}

}
