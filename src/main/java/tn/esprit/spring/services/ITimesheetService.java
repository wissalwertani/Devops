package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;



public interface ITimesheetService {
	
	
	public void affecterMissionADepartement(long missionId, int depId);
	public void ajouterTimesheet(long missionId, int employeId, Date dateDebut, Date dateFin);
	public void validerTimesheet(long missionId, int employeId, Date dateDebut, Date dateFin, int validateurId);
	public List<Mission> findAllMissionByEmployeJPQL(int employeId);
	public List<Employe> getAllEmployeByMission(long missionId);
}
