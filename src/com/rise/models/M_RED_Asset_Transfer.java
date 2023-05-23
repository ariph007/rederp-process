package com.rise.models;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;

@SuppressWarnings("serial")
public class M_RED_Asset_Transfer extends X_RED_Asset_Transfer implements DocAction, DocOptions{

	public M_RED_Asset_Transfer(Properties ctx, int RED_Asset_Transfer_ID, String trxName) {
		super(ctx, RED_Asset_Transfer_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	 public M_RED_Asset_Transfer (Properties ctx, ResultSet rs, String trxName){
	      super (ctx, rs, trxName);
	      log.warning("------------------------------------------");
	    }

	@Override
	public boolean processIt(String action) throws Exception {
		log.warning("Process action = " + action + " -DocStatus = " + getDocStatus() + " - DocAction " + getDocAction());
		DocumentEngine engine = new DocumentEngine(this, getDocAction());
		
		return engine.processIt(action, getDocAction());
	}

	@Override
	public boolean unlockIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean invalidateIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public String prepareIt() {
		setC_DocType_ID(getC_DocType_ID());
		return DocAction.STATUS_InProgress;
	}

	@Override
	public boolean approveIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean rejectIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public String completeIt() {
		log.warning("------------------------------------------");
		return DocAction.ACTION_Complete;
	}

	@Override
	public boolean voidIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean closeIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean reverseCorrectIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean reverseAccrualIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public boolean reActivateIt() {
		log.warning("------------------------------------------");
		return true;
	}

	@Override
	public String getSummary() {
		log.warning("------------------------------------------");
		return null;
	}

	@Override
	public String getDocumentInfo() {
		log.warning("------------------------------------------");
		return null;
	}

	@Override
	public File createPDF() {
		log.warning("------------------------------------------");
		return null;
	}

	@Override
	public String getProcessMsg() {
		log.warning("------------------------------------------");
		return null;
	}

	@Override
	public int getDoc_User_ID() {
		log.warning("------------------------------------------");
		return 0;
	}

	@Override
	public int getC_Currency_ID() {
		log.warning("------------------------------------------");
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		log.warning("------------------------------------------");
		return BigDecimal.ZERO;
	}

	@Override
	public int customizeValidActions(String docStatus, Object processing, String orderType, String isSOTrx,
			int AD_Table_ID, String[] docAction, String[] options, int index) {
		
		if(options == null)
			throw new IllegalArgumentException("Option array is empty");
		
		if(docAction == null)
			throw new IllegalAccessError("Doc action is empty");
		
		// if a document is drafted  or invalid, the users are able to complete, prepare or void
		if(docStatus.equals(DocumentEngine.STATUS_Drafted) || docStatus.equals(DocumentEngine.STATUS_Invalid)) {
			options[index++] = DocumentEngine.ACTION_Complete;
			options[index++] = DocumentEngine.ACTION_Void;
			options[index++] = DocumentEngine.ACTION_Prepare;
			
		// if the document is already complete, we also want to be able to reactivate or voit it instead of only closing
		}else if(docStatus.equals(DocumentEngine.ACTION_Complete)){
			options[index++] = DocumentEngine.ACTION_Void;
			options[index++] = DocumentEngine.ACTION_ReActivate;
		}
		
		return index;
	}

}
 