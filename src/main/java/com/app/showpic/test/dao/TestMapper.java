package com.app.showpic.test.dao;

import java.util.List;

import com.app.showpic.test.bean.Test1;
import com.app.showpic.test.bean.Test2;

public interface TestMapper {

	List<Test1> getAllTests();

	int saveTest1(Test1 t1);

	int saveTest2(Test2 t2);

}
