package at.fhv.itb5c.commons.dto.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import at.fhv.itb5c.commons.dto.ILeague;
import at.fhv.itb5c.commons.enums.TypeOfSport;

public interface ILeagueRMI extends ILeague, Remote {
	@Override
	void setId(Long id) throws RemoteException;

	@Override
	Long getId() throws RemoteException;

	@Override
	void setVersion(Long version) throws RemoteException;

	@Override
	Long getVersion() throws RemoteException;

	@Override
	void setName(String name) throws RemoteException;

	@Override
	String getName() throws RemoteException;

	@Override
	TypeOfSport getTypeOfSport() throws RemoteException;

	@Override
	void setTypeOfSport(TypeOfSport typeOfSport) throws RemoteException;
}