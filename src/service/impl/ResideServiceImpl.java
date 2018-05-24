package service.impl;

import dao.ResideDao;
import entity.Reside;
import factory.ObjectFactory;
import service.ResideService;

public class ResideServiceImpl implements ResideService {

	public void addReside(Reside reside) {
		ResideDao resideDao=(ResideDao) ObjectFactory.getObject("resideDao");
		resideDao.insertReside(reside);
	}

	public void removeByDtlid(Integer dtlid) {
		ResideDao resideDao=(ResideDao) ObjectFactory.getObject("resideDao");
		resideDao.deleteByDtlid(dtlid);
	}

}
