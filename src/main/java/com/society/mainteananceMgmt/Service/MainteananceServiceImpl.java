package com.society.mainteananceMgmt.Service;

import java.util.Arrays;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.society.mainteananceMgmt.Dao.DataRepo;
import com.society.mainteananceMgmt.Model.MainteanceInfo;

@Service
public class MainteananceServiceImpl implements MainteananceService{
	
	@Autowired
	  private RestTemplate restTemplate;
	  
	  @Autowired
	  private DataRepo dataRepo;

	@Override
	public MainteanceInfo insertResident(MainteanceInfo mainteanceInfo) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
		 String ownerData = restTemplate.exchange("http://localhost:9091/society/residents/"+mainteanceInfo.getOwner(), HttpMethod.GET, entity, String.class).getBody();
		if(ownerData!=null) {
			 return dataRepo.save(mainteanceInfo);
		}
		throw new ServiceException("Owner not found");
	}

	@Override
	public MainteanceInfo getDatabyOwner(String owner) {
		MainteanceInfo data = dataRepo.findByOwner(owner);
		if(data == null) {
			throw new ServiceException("No Record Found");
		}
			return data;
	}

	@Override
	public MainteanceInfo updateStatus(String owner, String status) {
		MainteanceInfo data = dataRepo.findByOwner(owner);
		if(data!=null) {
			data.setIssueStatus(status);
			return dataRepo.save(data);
		}
		 throw new ServiceException("No issue parking found");
	}

	@Override
	public String deleteByOwner(String owner) {
		MainteanceInfo data = dataRepo.findByOwner(owner);
		if(data!=null) {
			if(data.getIssueStatus().equalsIgnoreCase("Resolved")) {
				dataRepo.deleteById(data.getId());
				 return " Deleted Successfully";
			}
			else {
				 throw new ServiceException("Active issue found,can't be deleted");
			}
		}
		 throw new ServiceException("No Active parking found");
	}

	@Override
	public String deleteAll() {
		dataRepo.deleteAll();
		return "Deleted Succesfully";
	}

}
