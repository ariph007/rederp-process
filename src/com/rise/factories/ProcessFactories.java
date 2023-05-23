package com.rise.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

//import com.rise.processes.AssetTransfer;

public class ProcessFactories implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
//		
//		if(className.equals("com.rise.process.AssetTransfer"))
//			return new AssetTransfer();
		
		return null;
	}

}
