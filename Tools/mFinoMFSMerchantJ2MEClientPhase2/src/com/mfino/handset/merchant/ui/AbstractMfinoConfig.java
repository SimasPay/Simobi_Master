package com.mfino.handset.merchant.ui;

import javax.microedition.lcdui.Alert;

import com.mfino.handset.merchant.util.MfinoConfigData;

public abstract class AbstractMfinoConfig implements MfinoConfig{
	
	public MfinoConfigData mFinoConfigData;
	public Alert alert;
	
	public AbstractMfinoConfig(){
		
	}
	
	public AbstractMfinoConfig(MfinoConfigData mFinoConfigData){
		this.mFinoConfigData = mFinoConfigData;
	}
	
	public void setConfigData(MfinoConfigData mFinoConfigData) {
		this.mFinoConfigData = mFinoConfigData;
	}

	public MfinoConfigData getMfinoConfigData() {
		return this.mFinoConfigData;
	}

}
