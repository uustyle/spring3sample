package jp.co.kenshu.mapper;

import java.util.List;

import jp.co.kenshu.entity.Test;

public interface TestMapper {
    Test getTest(int id);
    
    List<Test> getTestAll(); 
    
    int insertTest(String name);
    
    int deleteTest(int id);
    
 // トランザクションテスト用の失敗メソッド
    int insertFailTest(Object object);
}