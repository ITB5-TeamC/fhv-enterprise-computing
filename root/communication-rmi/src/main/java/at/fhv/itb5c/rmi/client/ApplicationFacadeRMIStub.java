package at.fhv.itb5c.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

import at.fhv.itb5c.commons.dto.rmi.IApplicationFacadeRMI;
import at.fhv.itb5c.commons.dto.rmi.IDepartmentRMI;
import at.fhv.itb5c.commons.dto.rmi.ILeagueRMI;
import at.fhv.itb5c.commons.dto.rmi.ITeamRMI;
import at.fhv.itb5c.commons.dto.rmi.IUserRMI;
import at.fhv.itb5c.commons.enums.TypeOfSport;
import at.fhv.itb5c.logging.ILogger;
import at.fhv.itb5c.rmi.server.RMIServant;

public class ApplicationFacadeRMIStub extends UnicastRemoteObject
		implements IApplicationFacadeRMI, RMIServant, RMIStub, ILogger {
	private static final long serialVersionUID = 5936681743587706578L;
	private IApplicationFacadeRMI _applicationFacadeRMI;

	protected ApplicationFacadeRMIStub() throws RemoteException {
		super();
	}

	@Override
	public void init(String host, String port) {
		Object obj;
		try {
			obj = Naming.lookup("rmi://" + host + ":" + port + "/ApplicationFacadeRMI");
			_applicationFacadeRMI = (IApplicationFacadeRMI) obj;
		} catch (MalformedURLException | NotBoundException | RemoteException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public IUserRMI createUser(String sessionId) throws RemoteException {
		return _applicationFacadeRMI.createUser(sessionId);
	}

	@Override
	public IUserRMI getUserById(String sessionId, Long id) throws RemoteException {
		return _applicationFacadeRMI.getUserById(sessionId, id);
	}

	@Override
	public Collection<IUserRMI> findUsers(String sessionId, String firstName, String lastName, Long departmentId,
			Boolean membershipFeePaid) throws RemoteException {
		return _applicationFacadeRMI.findUsers(sessionId, firstName, lastName, departmentId, membershipFeePaid);
	}

	@Override
	public Collection<IUserRMI> findUsersSimple(String sessionId, String name) throws RemoteException {
		return _applicationFacadeRMI.findUsersSimple(sessionId, name);
	}

	@Override
	public IUserRMI saveUser(String sessionId, IUserRMI user) throws RemoteException {
		return _applicationFacadeRMI.saveUser(sessionId, user);
	}

	@Override
	public IDepartmentRMI getDepartmentById(String sessionId, Long id) throws RemoteException {
		return _applicationFacadeRMI.getDepartmentById(sessionId, id);
	}

	@Override
	public Collection<IDepartmentRMI> getAllDepartments(String sessionId) throws RemoteException {
		return _applicationFacadeRMI.getAllDepartments(sessionId);
	}

	public ITeamRMI createTeam(String sessionId) throws RemoteException{
		return _applicationFacadeRMI.createTeam(sessionId);
	}
	
	@Override
	public ITeamRMI getTeamById(String sessionId, Long id) throws RemoteException {
		return _applicationFacadeRMI.getTeamById(sessionId, id);
	}

	@Override
	public Collection<ITeamRMI> findTeams(String sessionId, String name, TypeOfSport typeOfSport, Long departmentId, Long leagueId)
			throws RemoteException {
		return _applicationFacadeRMI.findTeams(sessionId, name, typeOfSport, departmentId, leagueId);
	}

	@Override
	public ITeamRMI saveTeam(String sessionId, ITeamRMI team) throws RemoteException {
		return _applicationFacadeRMI.saveTeam(sessionId, team);
	}

	@Override
	public ILeagueRMI getLeagueById(String sessionId, Long id) throws RemoteException {
		return _applicationFacadeRMI.getLeagueById(sessionId, id);
	}

	@Override
	public Collection<ILeagueRMI> getAllLeagues(String sessionId) throws RemoteException {
		return _applicationFacadeRMI.getAllLeagues(sessionId);
	}

	@Override
	public String loginLDAP(String username, String password) throws RemoteException {
		return _applicationFacadeRMI.loginLDAP(username, password);
	}

	@Override
	public IUserRMI getCurrentUser(String sessionId) throws RemoteException {
		return _applicationFacadeRMI.getCurrentUser(sessionId);
	}
}
