package com.app.showpic.test.sercive;

import java.util.List;

import com.app.showpic.test.bean.Test1;
import com.app.showpic.test.bean.Test2;

public interface ITestSercive {

	List<Test1> getValue();

	void saveBean(Test1 t1, Test2 t2);

}
