package com.app.showpic.test.sercive.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.showpic.test.bean.Test1;
import com.app.showpic.test.bean.Test2;
import com.app.showpic.test.dao.TestMapper;
import com.app.showpic.test.sercive.ITestSercive;

@Service
public class TestSercive implements ITestSercive {
	@Autowired
	private TestMapper testMapper;

	@Override
	public List<Test1> getValue() {
		return testMapper.getAllTests();
	}

	@Transactional(rollbackFor={Exception.class},readOnly = false)
	@Override
	public void saveBean(Test1 t1, Test2 t2) {
		testMapper.saveTest1(t1);
		System.out.println("save------11:"+t1.getId());
		testMapper.saveTest2(t2);
		System.out.println("save------22:"+t2.getId());
	}

}
