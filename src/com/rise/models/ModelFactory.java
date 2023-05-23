package com.rise.models;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class ModelFactory implements IModelFactory{
	CLogger log = CLogger.getCLogger(ModelFactory.class);

	@Override
	public Class<?> getClass(String tableName) {
		log.warning("------------------------------------------");
		if(tableName.equals(M_RED_Asset_Transfer.Table_Name))
			return M_RED_Asset_Transfer.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		log.warning("------------------------------------------");
		if(tableName.equals(M_RED_Asset_Transfer.Table_Name))
			return new M_RED_Asset_Transfer(Env.getCtx(), Record_ID, trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		log.warning("------------------------------------------");
		if(tableName.equals(M_RED_Asset_Transfer.Table_Name))
			return new M_RED_Asset_Transfer(Env.getCtx(), rs, trxName);
		return null;
	}

}
