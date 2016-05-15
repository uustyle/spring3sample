package sample.customer.dao;

import sample.customer.biz.domain.TestTbl;

@MyMapper
public interface TestTblMapper {
	TestTbl selectTestTbl(int id);
}
