package at.fhv.itb5c.view.user;

import at.fhv.itb5c.app.AppState;
import at.fhv.itb5c.application.dto.UserDTO;
import at.fhv.itb5c.communication.CommunicationErrorException;
import at.fhv.itb5c.communication.CommunicationFacadeProvider;
import at.fhv.itb5c.logging.ILogger;
import at.fhv.itb5c.view.user.UserViewController.UserViewState;
import at.fhv.itb5c.view.util.factories.AbstractViewFactory;
import at.fhv.itb5c.view.util.popup.ErrorPopUp;

public class UserViewFactory extends AbstractViewFactory implements ILogger{

	public UserViewFactory() {
		super("/view/fxml/user/UserView.fxml", createController(UserViewState.addState, null));
	}
	
	public UserViewFactory(UserViewState userViewState, UserDTO user) {
		super("/view/fxml/user/UserView.fxml", createController(userViewState, user));
	}

	public static Object createController(UserViewState userViewState, UserDTO user) {
		try {
			UserModel userModel;
			if (userViewState == UserViewState.addState) {
				userModel = UserModel.createUserModel(CommunicationFacadeProvider.getInstance().getCurrentFacade().createUser(AppState.getInstance().getSessionID()));
			} else {
				userModel = UserModel.createUserModel(user);
			}
			UserViewController userViewController = new UserViewController(userModel, userViewState);
			return userViewController;
		} 
		catch (CommunicationErrorException e)
		{
			ErrorPopUp.connectionError();
			log.error(e.getMessage());
			return null;
		}
	}
}
