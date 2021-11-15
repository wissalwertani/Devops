package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MissionServiceImp implements IMissionService {
	private static final Logger l = LogManager.getLogger(MissionServiceImp.class);
	@Autowired
	MissionRepository ie;

	

	@Override
	public Mission addMission(Mission mission)
	{
		return ie.save(mission); 
		
	}
	
	@Override
	public List<Mission> retrieveAllMission(){
		List<Mission> missions = null; 
		try {
	
			l.info("In retrieveAllMission() : ");
			missions = (List<Mission>) ie.findAll();  
			for (Mission mission : missions) {
				l.debug("mission+++ : " + mission);
			} 
			l.info("Out of retrieveAllMission() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMission() : " + e);
		}

		return missions;
		
	}
	
	
	@Override
	public void remove(String idMission)
	{
		ie.deleteById(Long.parseLong(idMission));
	}
	
	@Override
	public Mission updateMission(Mission mission)
	{
		return ie.save(mission);

	}
	@Override
	public Mission retrieveMission(String id) {
		l.info("in  retrieveMission id = " + id);
		Mission e =  ie.findById(Long.parseLong(id)).orElse(null);
		l.info("mission returned : " + e);
		return e; 
	

	}

}
