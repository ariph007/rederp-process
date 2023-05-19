package com.rise.process;

import org.compiere.model.MAsset;
import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.Msg;

public class AssetTransfer extends SvrProcess{
	private int p_A_Asset_ID = 0;			// Asset
	private int p_M_Locator_ID = 0;			// Current Locator Asset
	private int p_M_LocatorTo_ID = 0 ;		// Target Transfer Locator
	
	
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter para : paras) {
			String name = para.getParameterName();
			
			if (name.equals("A_Asset_ID"))
				p_A_Asset_ID = para.getParameterAsInt();
			else if(name.equals("M_Locator_ID"))
				p_M_Locator_ID = para.getParameterAsInt();
			else if(name.equals("M_LocatorTo_ID"))
				p_M_LocatorTo_ID = para.getParameterAsInt();
			else
				MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), para);
		}
		
	}

	@Override
	protected String doIt() throws Exception {
		if (p_A_Asset_ID == 0)
			throw new AdempiereUserError(Msg.parseTranslation(getCtx(), "@FillMandatory@ @A_Asset_ID@"));
		if (p_M_Locator_ID == 0)
			throw new AdempiereUserError(Msg.parseTranslation(getCtx(), "@FillMandatory@ @M_Locator_ID@"));
		if (p_M_LocatorTo_ID == 0)
			throw new AdempiereUserError(Msg.parseTranslation(getCtx(), "@FillMandatory@ @p_M_LocatorTo_ID@"));
		if (p_M_Locator_ID == p_M_LocatorTo_ID)
			throw new AdempiereUserError (Msg.getMsg(getCtx(), "LocatorFromToMustDiffer"));
		
		MREDAssetTransfer transfer = new MREDAssetTransfer(getCtx(), 0, get_TrxName());
		transfer.setA_Asset_ID(p_A_Asset_ID);
		transfer.setM_Locator_ID(p_M_Locator_ID);
		transfer.setM_LocatorTo_ID(p_M_LocatorTo_ID);
		transfer.saveEx();
		
		
		MAsset asset = new MAsset(null, p_A_Asset_ID, null);
		final String assetName = asset.getName();
		
		final String msg = "Asset " + p_A_Asset_ID + " : " +assetName + " successful transfered";
		return msg;
	}

}
