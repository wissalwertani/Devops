package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository departmentRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		departmentRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Optional<Entreprise> entrepriseOpt = entrepriseRepoistory.findById(entrepriseId);
		Entreprise entreprise = null;
		if (entrepriseOpt.isPresent())
			entreprise = entrepriseOpt.get();
		Optional<Departement> departementOpt = departmentRepoistory.findById(depId);
		Departement departement = null;
		if (departementOpt.isPresent())
			departement = departementOpt.get();
		if (departement != null){		
		    departement.setEntreprise(entreprise);
	        departmentRepoistory.save(departement);
	        }
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> entrepriseOpt = entrepriseRepoistory.findById(entrepriseId);
		Entreprise entreprise = null;
		if (entrepriseOpt.isPresent())
			entreprise = entrepriseOpt.get();
		
		List<String> depNames = new ArrayList<>();
		if (entreprise != null)
		    for(Departement dep : entreprise.getDepartements()){
		    	depNames.add(dep.getName());
		    }
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseOpt = entrepriseRepoistory.findById(entrepriseId);
		Entreprise entreprise = null;
		if (entrepriseOpt.isPresent())
			entreprise = entrepriseOpt.get();
		if (entreprise != null)
		    entrepriseRepoistory.delete(entreprise);	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> departementOpt = departmentRepoistory.findById(depId);
		Departement departement = null;
		if (departementOpt.isPresent())
			departement = departementOpt.get();
		if (departement != null)
			departmentRepoistory.delete(departement);		
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseOpt = entrepriseRepoistory.findById(entrepriseId);
		Entreprise entreprise = null;
		if (entrepriseOpt.isPresent())
			entreprise = entrepriseOpt.get();
		return entreprise;
	}

}
