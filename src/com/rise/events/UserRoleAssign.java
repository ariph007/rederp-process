package com.rise.events;

import java.util.Properties;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.model.POWrapper;
import org.compiere.model.I_AD_User;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class UserRoleAssign extends AbstractEventHandler{
	private static CLogger log = CLogger.getCLogger(AbstractEventHandler.class);
	private static final  int GARDENWORLD_USER_ROLE = 103;
	
	@Override
	protected void doHandleEvent(Event event) {
            PO po = getPO(event);
            
            if (po instanceof MUser) {
                MUser user = (MUser) po;
                MUserRoles userRole = new MUserRoles(Env.getCtx(), 0, user.get_TrxName());
                userRole.setAD_User_ID(user.getAD_User_ID());
                userRole.setAD_Role_ID(GARDENWORLD_USER_ROLE);
                userRole.saveEx();
            }
	}
	
	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MUser.Table_Name);
	}

}
