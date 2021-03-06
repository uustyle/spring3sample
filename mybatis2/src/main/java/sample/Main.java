package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.biz.dao.TestTblDao;
import sample.biz.domain.TestTbl;


public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.mybatis.xml");
        
        TestTblDao testTblDao = ctx.getBean(TestTblDao.class);
        TestTbl testTbl = testTblDao.getTestTbl(1, "東京太郎");
        System.out.println(testTbl.getName());
        
        
//        FriendlyDao friendlyDao = ctx.getBean(FriendlyDao.class);
//        Owner owner = friendlyDao.getOwnerDynamic("1", "東京太郎");
//        System.out.println(owner.getOwnerName());
//        
//        Owner newOwner = new Owner();
//        newOwner.setOwnerName("newOwner");
//		friendlyDao.insertOwner(newOwner);
//        System.out.println(newOwner.getOwnerId());
//        
//		friendlyDao.deleteOwner(newOwner.getOwnerId());
      }
}
