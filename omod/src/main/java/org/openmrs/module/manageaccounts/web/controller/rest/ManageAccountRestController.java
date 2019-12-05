package org.openmrs.module.manageaccounts.web.controller.rest;
import org.json.JSONObject;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RequestMapping("/rest/v1/manage-accounts/")
@RestController
public class ManageAccountRestController extends MainResourceController {
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public ResponseEntity<String> updateUser(@RequestBody String jsonStr) throws Exception {
		String responseMessage = "";
		String userName = "";
		String password = "";
		JSONObject requestBody = new JSONObject(jsonStr);
			try {
				if (requestBody.has("userName")) {
					userName= requestBody.getString("userName");
				}
				if (requestBody.has("password")) {
					password = requestBody.getString("password");
				}
				User user = Context.getService(UserService.class).getUserByUsername(userName);
			if (user != null) {
					Context.getService(UserService.class).changePassword(user, password);
					responseMessage = "Successfully Changed the User requested password";
			}
			else
			{	
				responseMessage = "User name doesn't exists";
			}
			return new ResponseEntity<>(new Gson().toJson(responseMessage), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(new Gson().toJson(e.getMessage()), HttpStatus.OK);
		}
	}
}
