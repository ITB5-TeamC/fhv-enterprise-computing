package at.fhv.itb5c.view.view.usersearch;

import at.fhv.itb5c.view.view.util.factories.AbstractViewFactory;

public final class SearchUserViewFactory extends AbstractViewFactory {
	
	public SearchUserViewFactory() {
		super("/view/fxml/SearchUserView.fxml", new SearchUserController());
	}
}