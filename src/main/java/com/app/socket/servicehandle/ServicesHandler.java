package com.app.socket.servicehandle;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;
@Component
public class ServicesHandler extends IoHandlerAdapter {
	
	private final static Logger logger = Logger.getLogger(ServicesHandler.class);
	
	@Override
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
        session.close(true);
    }

	@Override
    public void messageReceived( IoSession session, Object object ) {
		IoBuffer ioBuffer = (IoBuffer) object;
		byte[] b = new byte[ioBuffer.limit()];
		ioBuffer.get(b);
		byte[] responseStr = "sgsgsgsg".getBytes();//响应内容
		this.response(session, responseStr);
    }
	
	/**
	 * 响应
	 * @param session
	 * @param responseStr
	 */
	private void response(IoSession session, byte[] responseStr){
		System.out.println("响应结果报文："+responseStr);
		IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
		try {
			buf.put(responseStr);
			logger.info("对本次响应编码成功！");
			logger.info("返回的报文为：【" + new String(responseStr,"UTF-8") + "】");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		buf.flip();
		session.write(buf);
		session.close(true);
        logger.info("=======================链接已关闭=======================");
	}
	
    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception{
    	session.close(true);
    }

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("incomeing client:"+session.getRemoteAddress()+"...");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.info(session.getRemoteAddress() + "is disconnection!");
	}
  
}
