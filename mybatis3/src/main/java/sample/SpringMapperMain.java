package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.biz.dao.TestTblDao;
import sample.biz.domain.TestTbl;

public class SpringMapperMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.SpringMapperMain.xml");

        TestTblDao testTblDao = ctx.getBean(TestTblDao.class);
        
        TestTbl testTbl= testTblDao.findPetById(1);
        System.out.println(testTbl.getName());

        
//        PetDao petDao = ctx.getBean(PetDao.class);
//        
//        Pet pet= petDao.findPetById(1);
//        System.out.println(pet.getPetName());
    }
}
