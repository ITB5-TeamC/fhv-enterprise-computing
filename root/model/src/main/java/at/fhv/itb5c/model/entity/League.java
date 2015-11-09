package at.fhv.itb5c.model.entity;

import javax.persistence.Column;

import at.fhv.itb5c.commons.enums.TypeOfSport;

public class League extends PersistableObject {
	@Column(name = "name", nullable = false)
	private String _name;
	
	@Column(name = "typeOfSport", nullable = false)
	private TypeOfSport _typeOfSport;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public TypeOfSport getTypeOfSport() {
		return _typeOfSport;
	}

	public void setTypeOfSport(TypeOfSport typeOfSport) {
		_typeOfSport = typeOfSport;
	}
}