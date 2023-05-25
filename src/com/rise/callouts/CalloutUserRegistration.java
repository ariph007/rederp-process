package com.rise.callouts;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.X_AD_User;

public class CalloutUserRegistration extends CalloutEngine implements IColumnCallout{

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
//		X_AD_User newUser = new X_AD_User(ctx, WindowNo, ARG_SEPARATOR)
		
		return null; 
	}
	
}
