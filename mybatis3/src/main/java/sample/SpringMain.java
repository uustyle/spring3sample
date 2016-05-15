package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.biz.dao.PetDao;
import sample.biz.domain.Pet;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.SpringMain.xml");
        PetDao petDao = ctx.getBean(PetDao.class);
        
        Pet pet= petDao.findPetById(1);
        System.out.println(pet.getPetName());
    }
}
