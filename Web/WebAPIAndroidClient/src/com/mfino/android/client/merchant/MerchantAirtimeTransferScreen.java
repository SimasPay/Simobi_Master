package com.mfino.android.client.merchant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mfino.android.client.R;
import com.mfino.android.client.common.HttpConnectionManager;
import com.mfino.android.client.common.Utils;

public class MerchantAirtimeTransferScreen extends Activity
{
    private EditText SourceMDNET;
    private EditText SourcePINET;
    private EditText DestMDNET;
    private EditText AmountET;
    
    private Button ActivateButton;
    private Button GoBackButton;    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.merchant_airtimetransfer);
	
	SourceMDNET = (EditText)findViewById(R.id.meatSourceMDNET);
	SourcePINET = (EditText)findViewById(R.id.meatSourcePINET);
	DestMDNET = (EditText)findViewById(R.id.meatDestinationMDNET);
	AmountET = (EditText)findViewById(R.id.meatAmountET);
	
	ActivateButton = (Button)findViewById(R.id.meatAirtimeTransferButton);
	ActivateButton.setOnClickListener(clickActivate);
	GoBackButton = (Button)findViewById(R.id.meatBackButton);
	GoBackButton.setOnClickListener(clickBack);
	
    }
    
    private OnClickListener clickActivate = new OnClickListener()
    {   
        @Override
        public void onClick(View v)
        {
    		List<NameValuePair> params = new ArrayList<NameValuePair>(7);
    		params.add(new BasicNameValuePair(Utils.SourceMDN,SourceMDNET.getText().toString()));
    		params.add(new BasicNameValuePair(Utils.SourcePIN, SourcePINET.getText().toString()));
    		params.add(new BasicNameValuePair(Utils.DestMDN, DestMDNET.getText().toString()));
    		params.add(new BasicNameValuePair(Utils.Amount, AmountET.getText().toString()));
    		params.add(new BasicNameValuePair(Utils.Mode,Utils.MerchantModeValue));
    		params.add(new BasicNameValuePair(Utils.ServiceName,Utils.AirtimeTransfer));
    		params.add(new BasicNameValuePair(Utils.ChannelID,Utils.ChannelIDValue));
    		String str=null;
    		try
                {
    		    HttpConnectionManager cm = new HttpConnectionManager(Utils.URL,params);
    		     
    		      
    		    cm.execute();    		    
    		    str = cm.getResponseContent();
                }                
    		catch(IOException e)
    		{
                    Toast.makeText(MerchantAirtimeTransferScreen.this,"Connection Error",Toast.LENGTH_LONG).show();
                    return;    		    
    		}
                catch(Exception ex)
                {
                    Toast.makeText(MerchantAirtimeTransferScreen.this,"Error",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent resultIntent  = new Intent(MerchantAirtimeTransferScreen.this,com.mfino.android.client.common.ShowResult.class);
                resultIntent.putExtra("result", str);
            	startActivity(resultIntent); 
            
            	MerchantAirtimeTransferScreen.this.finish();
        }
    };
    private OnClickListener clickBack = new OnClickListener()
    {
        
        @Override
        public void onClick(View v)
        {
            MerchantAirtimeTransferScreen.this.finish();
        }
    };
    
}
