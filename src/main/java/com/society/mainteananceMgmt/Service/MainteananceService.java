package com.society.mainteananceMgmt.Service;

import com.society.mainteananceMgmt.Model.MainteanceInfo;

public interface MainteananceService {

	MainteanceInfo insertResident(MainteanceInfo mainteanceInfo);

	MainteanceInfo getDatabyOwner(String owner);

	String deleteByOwner(String owner);

	String deleteAll();

	MainteanceInfo updateStatus(String owner, String status);

}
