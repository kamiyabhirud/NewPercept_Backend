package controller;

import model.Status;

public class StatusController {

	public Status isValid(Boolean currentstatus) {
		Status statusobj = new Status();
		if (currentstatus) {
			statusobj.setStatus("success");
		} else if (!currentstatus) {
			statusobj.setStatus("failure");
		}
		return statusobj;
	}

}
