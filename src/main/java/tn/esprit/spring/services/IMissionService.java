package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	public Mission addMission(Mission mission);
	public List<Mission> retrieveAllMission();
	public void remove(String idMission);
	public Mission updateMission(Mission mission);
	public Mission retrieveMission(String id);
}
