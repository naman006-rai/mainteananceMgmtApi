package com.society.mainteananceMgmt.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.mainteananceMgmt.Model.MainteanceInfo;

public interface DataRepo extends JpaRepository<MainteanceInfo,Integer>{

	MainteanceInfo findByOwner(String owner);

}
