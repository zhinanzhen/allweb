package com.mq.client2;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration("/applicationContext-mq2.xml")   
public class ProducerConsumerSessionTest {
	@Autowired
    private ProducerService producerService;   
    @Autowired
    @Qualifier("sessionAwareQueue")   
    private Destination sessionAwareQueue;   
       
    @Test  
    public void testSessionAwareMessageListener() {   
        producerService.sendMessage(sessionAwareQueue, "测试SessionAwareMessageListener");   
    }   
}
