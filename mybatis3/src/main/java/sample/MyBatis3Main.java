package sample;

import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.biz.domain.Owner;
import sample.biz.domain.Pet;
import sample.dao.tmp.PetMapper;

public class MyBatis3Main {

	public static void main(String[] args) throws Exception {
		String resource = "sample/mybatis.MyBatis3Main.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlMapper.openSession();
		
		// パラメータが1 つのバインディング
		Pet pet = session.selectOne("sample.dao.PetMapper.selectPet", 1);
		System.out.println(pet.getPetName());
		
		// JavaBeansを使用したパラメータのバインディング&キーの自動生成
		Pet newPet = new Pet();
		newPet.setPetName("たま");
		newPet.setOwnerName("東京太郎");
		newPet.setPrice(3000);
		newPet.setBirthDate(new Date());
		session.insert("sample.dao.PetMapper.insertPet", newPet);
		
		// 複数のJavaBeans のバインディング
		Map<String, Object> map = new HashMap<String, Object>();
		pet = new Pet();
		pet.setPetName("たま");
		map.put("pet", pet);
		Owner owner = new Owner();
		owner.setOwnerName("東京太郎");
		map.put("owner", owner);
		Pet result = session.selectOne("sample.dao.PetMapper.selectPetByNames", map);
		System.out.println(pet.getPetName());

		// resultMap を使用した複雑なマッピング
		owner = session.selectOne("sample.dao.PetMapper.selectOwner", "東京太郎");
		for (Pet p: owner.getPetList()) {
			System.out.println(p.getPetName());
		}
		
		// 動的なSQL
		pet = new Pet();
		pet.setPrice(1000);
		List<Pet> list = session.selectList("sample.dao.PetMapper.findPet", pet);
		for (Pet p : list) {
			System.out.println(p.getPetName());
		}
		
		// Mapperインタフェース
		PetMapper mapper = session.getMapper(PetMapper.class);
		pet = mapper.selectPet(1);
		System.out.println(pet.getPetName());
		
		
		
		session.delete("sample.dao.PetMapper.deletePet", "たま");
		
		session.commit();
		session.close();
	}
	
}
