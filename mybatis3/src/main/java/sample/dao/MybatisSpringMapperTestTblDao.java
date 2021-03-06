package sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.biz.dao.TestTblDao;
import sample.biz.domain.TestTbl;

@Repository
public class MybatisSpringMapperTestTblDao implements TestTblDao {
    @Autowired
    private TestTblMapper testTblMapper;

    public TestTbl findPetById(Integer id) {
        return testTblMapper.selectTestTbl(id);
    }
}
