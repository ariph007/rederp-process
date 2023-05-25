package com.rise.events;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
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

	@Override
	protected void doHandleEvent(Event event) {
		if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
            PO po = getPO(event);
            if (po.get_TableName().equals(MUser.Table_Name)) {
                int userIdCreated = Integer.parseInt(po.get_Value(I_AD_User.COLUMNNAME_AD_User_ID).toString());
                MUser user = MUser.get(Env.getCtx(), userIdCreated);
                if (user != null) {
                    MUserRoles userRole = new MUserRoles(Env.getCtx(), 0, null);
                    userRole.setAD_User_ID(userIdCreated);
                    userRole.setAD_Role_ID(MRole.getDefault().getAD_Role_ID());
                    userRole.saveEx();
                } else {
                    log.warning("AD_User not found for AD_User_ID: " + userIdCreated);
                }
            }
        }
	}

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MUser.Table_Name);
	}

}
