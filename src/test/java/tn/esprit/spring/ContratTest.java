package tn.esprit.spring;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	
	@Autowired
	IEmployeService empl ;
	
	@Autowired
	ContratRepository contratRepository;
	

	private static final Logger l = LogManager.getLogger(ContratTest.class);
	
	@Test
	public void tests() {
		
	  //ajouterContratTest();
	  // affecterContratAEmployeTest();
      deleteContratByIdTest();
      // deleteAllContratJPQLTest();
        
	}

	public void ajouterContratTest() {
	   try{
			Date d = new Date();
			Contrat c = new Contrat(d,"CDI",3000);
			empl.ajouterContrat(c);
			Assert.assertTrue(c.getReference() > 0);
			l.info("Out AjouterContrat() without errors.");	
	      
		}catch (Exception e) {
		   l.error("Erreur dans l'ajout du contrat : " , e);
		}
	}

	public void affecterContratAEmployeTest() {
		try{
			int idc = 2;
			int idemp = 1;
			empl.affecterContratAEmploye(idc, idemp);
			Contrat c =contratRepository.findById(idc).orElseThrow(null);
			Assert.assertTrue(c.getEmploye().getId()==idemp);
			l.info("Out AffecterContratAEmploye() without errors.");	
	      
		}catch (Exception e) {
		   l.error("Erreur dans l'affectation du contrat : " , e);
	    }
	}

	

	public void deleteContratByIdTest() {
		try{
			int contratId = 2;
			empl.deleteContratById(contratId);
			Optional<Contrat> cont = contratRepository.findById(contratId);
			Assert.assertFalse(cont.isPresent());
			l.info("Out DeleteContratById() without errors.");	
	      
		}catch (Exception e) {
		   l.error("Erreur dans la suppression du contrat : " , e);
	    }
	}
	
	public void deleteAllContratJPQLTest() {
		
		try{
			empl.deleteAllContratJPQL();
			List<Contrat> cont = (List<Contrat>) contratRepository.findAll();
			Assert.assertTrue(cont.size()==0);
			l.info("Out deleteAllContratJPQL() without errors.");	
			
		}catch (Exception e) {
		   l.error("Erreur dans la suppression du liste des contrats : " ,e);
	    }
	}

}
