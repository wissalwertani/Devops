package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import org.junit.Assert;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessionTests {
	@Autowired
	IMissionService ms;
	
	
	/* @Test
	public void testRetrieveAllMission() {
		List<Mission> listMissions = ms.retrieveAllMission();
		// if there are 2 users in DB : 
	  Assert.assertEquals(5, listMissions.size());
	}
*/
	@Test
	public void testAddMission() throws ParseException {
		

		Mission m = new Mission("skksks","test111");



		Mission missionadded = ms.addMission(m) ;
		Assert.assertEquals(m.getName(), missionadded.getName());
	}
	
	@Test
	public void testModifyMission() throws ParseException   {
				Mission m = new Mission("hhh","test1");



		Mission missionModified = ms.updateMission(m) ;
		Assert.assertEquals(m.getName(), missionModified.getName());
	}
	
	@Test
	public void testDeleteMission() {

		ms.remove("12");		
	//	Assert.assertNull(ms.retrieveMission("5"));


	
}
}
