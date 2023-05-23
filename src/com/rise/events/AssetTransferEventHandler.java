package com.rise.events;

import javax.management.RuntimeErrorException;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.osgi.service.event.Event;

import com.rise.models.M_RED_Asset_Transfer;


public class AssetTransferEventHandler extends AbstractEventHandler{

	@Override
	protected void doHandleEvent(Event event) {
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_COMPLETE)) {
			
			//Check Asset Transfer Line is empty or not
			throw new RuntimeException("Asset Transfer Line can't be empty !");
		}
		
	}

	@Override
	protected void initialize() {
		registerEvent(IEventTopics.DOC_BEFORE_COMPLETE, M_RED_Asset_Transfer.Table_Name);
		
	}

}
