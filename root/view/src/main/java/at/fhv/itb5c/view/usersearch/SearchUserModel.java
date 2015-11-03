package at.fhv.itb5c.view.usersearch;

import at.fhv.itb5c.commons.dto.rmi.IDepartmentRMI;
import at.fhv.itb5c.commons.dto.rmi.IUserRMI;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchUserModel {

	private StringProperty _firstName;
	private StringProperty _lastName;
	private BooleanProperty _isPaid;
	private ObjectProperty<IDepartmentRMI> _department;
	private ObservableList<IUserRMI> _searchResult;
	
	public SearchUserModel() 
	{
		_firstName = new SimpleStringProperty();
		_lastName = new SimpleStringProperty();
		_isPaid = new SimpleBooleanProperty();
		_searchResult = FXCollections.observableArrayList();
		_department = new SimpleObjectProperty<>();
	}
	
	public StringProperty getFirstName() {
		return _firstName;
	}
	
	public StringProperty getLastName() {
		return _lastName;
	}
	
	public BooleanProperty getIsPaid() {
		return _isPaid;
	}
	
	public ObservableList<IUserRMI> getSearchResult() {
		return _searchResult;
	}
	
	public ObjectProperty<IDepartmentRMI> getDepartment() {
		return _department;
	}
}
