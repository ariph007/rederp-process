package com.rise.events;


import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import com.rise.models.M_RED_Asset_Transfer;


public class AssetTransferEventHandler extends AbstractEventHandler{
	CLogger log = CLogger.getCLogger(AssetTransferEventHandler.class);

	@Override
	protected void doHandleEvent(Event event) {
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_PREPARE)) {
			M_RED_Asset_Transfer assetTransfer = new M_RED_Asset_Transfer(Env.getCtx(), 0, null);
			//Check Asset Transfer Line is empty or not
			log.warning("Error : DOC_BEFORE_PREPARE");
			System.out.println("Error : DOC_BEFORE_PREPARE");
			
			PO po = getPO(event);
			if(po.get_TableName().equals(M_RED_Asset_Transfer.Table_Name)) {
				log.warning("Error : DOC_BEFORE_PREPARE");
				System.out.println("Error : DOC_BEFORE_PREPARE");
			}
			
			
			
			throw new RuntimeException("Asset Transfer Line can't be empty : DOC_BEFORE_PREPARE");
		}
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_COMPLETE)) {
			M_RED_Asset_Transfer assetTransfer = new M_RED_Asset_Transfer(Env.getCtx(), 0, null);
			//Check Asset Transfer Line is empty or not
			log.warning("Error : DOC_BEFORE_COMPLETE");
			PO po = getPO(event);
			if(po.get_TableName().equals(M_RED_Asset_Transfer.Table_Name)) {
				log.warning("Error : DOC_BEFORE_COMPLETE");
				System.out.println("Error : DOC_BEFORE_COMPLETE");
			}
			
			throw new RuntimeException("Asset Transfer Line can't be empty : DOC_BEFORE_COMPLETE");
		}
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_CLOSE)) {
			M_RED_Asset_Transfer assetTransfer = new M_RED_Asset_Transfer(Env.getCtx(), 0, null);
			//Check Asset Transfer Line is empty or not
			log.warning("Error : DOC_BEFORE_CLOSE");
			
			PO po = getPO(event);
			if(po.get_TableName().equals(M_RED_Asset_Transfer.Table_Name)) {
				log.warning("Error : DOC_BEFORE_CLOSE");
				System.out.println("Error : DOC_BEFORE_CLOSE");
			}
			throw new RuntimeException("Asset Transfer Line can't be empty : DOC_BEFORE_CLOSE");
		}
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_POST)) {
			M_RED_Asset_Transfer assetTransfer = new M_RED_Asset_Transfer(Env.getCtx(), 0, null);
			//Check Asset Transfer Line is empty or not
			log.warning("Error : DOC_BEFORE_POST");
			
			PO po = getPO(event);
			if(po.get_TableName().equals(M_RED_Asset_Transfer.Table_Name)) {
				log.warning("Error : DOC_BEFORE_POST");
				System.out.println("Error : DOC_BEFORE_POST");
			}
			throw new RuntimeException("Asset Transfer Line can't be empty : DOC_BEFORE_POST");
		}
		
	}

	@Override
	protected void initialize() {
		registerEvent(IEventTopics.DOC_BEFORE_PREPARE, M_RED_Asset_Transfer.Table_Name);
		registerEvent(IEventTopics.DOC_BEFORE_COMPLETE, M_RED_Asset_Transfer.Table_Name);
		registerEvent(IEventTopics.DOC_BEFORE_CLOSE, M_RED_Asset_Transfer.Table_Name);
		registerEvent(IEventTopics.DOC_BEFORE_POST, M_RED_Asset_Transfer.Table_Name);
	}

}
