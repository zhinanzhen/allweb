package com.foundation.remote.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.foundation.Person;

public interface IRemote extends Remote{
	String show() throws RemoteException;
	Person getPsersion() throws RemoteException;
}
