package com.example.Final;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

		
	    private static final String TAG = SmsReceiver.class.getSimpleName();
		//private SharedPreferences preferences;
		private String msgBody;
		//private String senderPhoneNumber;
	    @Override
	    public void onReceive(Context context, Intent intent) {
	        // TODO Auto-generated method stub
	    	String passCode = intent.getStringExtra("code");
	        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
	            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
	            SmsMessage[] msgs = null;
	            String msg_from;
	            String check= SetAtt.ds;
	            if (bundle != null){
	                //---retrieve the SMS message received---
	                try{
	                	
	                    Object[] pdus = (Object[]) bundle.get("pdus");
	                   
	                    msgs = new SmsMessage[pdus.length];
	                    for(int i=0; i<msgs.length; i++){
	                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
	                        msg_from = msgs[i].getOriginatingAddress();
	                        msgBody = msgs[i].getMessageBody();
	                        
	                    }
	                    
	                    Log.d(TAG,"Message : "+msgBody);
	                    int i = 9;
	                    boolean bool = true;
	                    
	                    
	                    
	                    char[] sms = msgBody.toCharArray();
	                    char[] code = check.toCharArray();
	                    for(int j = 0; j < code.length; j++){
	                    	if(code[j]!=sms[j]){
	                    		bool = false;
	                    	}
	                    }
	                    
	                    if(bool){
	                    	
	                    	
	                    	SmsManager smsMng = SmsManager.getDefault();
	                    	smsMng.sendTextMessage(msgs[0].getOriginatingAddress(), null, "Your phone mode is changed to normal", null, null);
	                    	AudioManager audioManager = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

	                    	
	             	        int j=0;
	             			
	             	        while(j<5){
	             				j++;
	             				audioManager.adjustVolume(1, 10);
	             	        }
	             			audioManager.setStreamVolume(1, audioManager.getStreamMaxVolume(1), 10);
	                    }
	                    
	                    
	                }catch(Exception e){
//	                            Log.d("Exception caught",e.getMessage());
	                }
	                
	            }else{
	            	
	            }
	        }
	        
	    }
	}