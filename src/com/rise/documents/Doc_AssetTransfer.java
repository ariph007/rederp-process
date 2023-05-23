package com.rise.documents;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.compiere.acct.Doc;
import org.compiere.acct.Fact;
import org.compiere.model.MAcctSchema;

import com.rise.models.M_RED_Asset_Transfer;

public class Doc_AssetTransfer extends Doc{

	public Doc_AssetTransfer (MAcctSchema as, ResultSet rs, String trxName)
	{
		super (as, M_RED_Asset_Transfer.class, rs, null, trxName);
		log.warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
 
	@Override
	protected String loadDocumentDetails() {
		log.warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return null;
	}
 
	@Override
	public BigDecimal getBalance() {
		log.warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return BigDecimal.ZERO;
	}
 
	@Override
	public ArrayList<Fact> createFacts(MAcctSchema as) {
		log.warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		ArrayList<Fact> facts = new ArrayList<Fact>();
		return facts;
	}
}
