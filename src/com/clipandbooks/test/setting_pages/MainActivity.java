package com.clipandbooks.test.setting_pages;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

   
    final static String TAG = "SETTING_TEST";
    Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context=this;
		Button btn1 = (Button)findViewById(R.id.action_settings);
		Button btn2 = (Button)findViewById(R.id.action_airplane_mode);
		Button btn3 = (Button)findViewById(R.id.action_wireless_settings);
		Button btn6 = (Button)findViewById(R.id.action_wifi_settings);
		Button btn4 = (Button)findViewById(R.id.action_nfc_settings);
		Button btn5 = (Button)findViewById(R.id.action_dummy);
		
		btn1.setOnClickListener(new onSettingClick());
		btn2.setOnClickListener(new onSettingClick());
		btn3.setOnClickListener(new onSettingClick());
		btn4.setOnClickListener(new onSettingClick());
		btn5.setOnClickListener(new onSettingClick());
		btn6.setOnClickListener(new onSettingClick());

		
	}

	class onSettingClick implements OnClickListener {
		@Override
		public void onClick(View v) {
		    Log.d(TAG, "onClick()");
			Intent intent;
			switch (v.getId()) {
			case R.id.action_settings :
				try {
				    intent = new Intent(Settings.ACTION_SETTINGS);
				    startActivity(intent);
				} catch (ActivityNotFoundException e) {
				    Log.d(TAG, " activity not found:ACTION_SETTINGS");
				    Toast.makeText(context, getString(R.string.error_activity_settings), Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.action_airplane_mode :
                try {
                    intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_AIRPLANE_MODE_SETTINGS");
                    Toast.makeText(context, getString(R.string.error_activity_airplane), Toast.LENGTH_SHORT).show();
                }
				break;
			case R.id.action_wireless_settings : 
			    
                try {
                    intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_WIRELESS_SETTINGS");
                    Toast.makeText(context, getString(R.string.error_activity_wireless), Toast.LENGTH_SHORT).show();
                }
				break;
            case R.id.action_wifi_settings : 
                
                try {
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_WIFI_SETTINGS");
                    Toast.makeText(context, getString(R.string.error_activity_wifi), Toast.LENGTH_SHORT).show();
                }
                break;
			case R.id.action_nfc_settings :
                try {
                    intent = new Intent("android.settings.NFC_SETTINGS");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_NFC_SETTINGS");
                    Toast.makeText(context, getString(R.string.error_activity_nfc), Toast.LENGTH_SHORT).show();
                }
				break;
				
			case R.id.action_dummy :
                try {
                    intent = new Intent("com.ubivelox.test.test");
                    Log.d(TAG, " activity call :ACTION_DUMMY");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_DUMMY");
                    Toast.makeText(context, getString(R.string.error_activity_dummy), Toast.LENGTH_SHORT).show();
                }
                break;
				
			}
		}
		
	}

}
