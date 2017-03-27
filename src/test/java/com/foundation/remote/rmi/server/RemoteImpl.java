package com.foundation.remote.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.foundation.Person;

public class RemoteImpl extends UnicastRemoteObject implements IRemote{

	private static final long serialVersionUID = 1L;

	protected RemoteImpl() throws RemoteException {
		super();
	}

	@Override
	public String show() throws RemoteException{
		return "RMI 远程方法调用";
	}

	@Override
	public Person getPsersion() throws RemoteException {
		Person p = new Person();
		p.setName("xxxx");
		return p;
	}

}
