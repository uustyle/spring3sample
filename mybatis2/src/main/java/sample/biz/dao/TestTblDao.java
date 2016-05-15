package sample.biz.dao;

import sample.biz.domain.TestTbl;

public interface TestTblDao {
	TestTbl getTestTbl(Integer id, String name);
    
}
