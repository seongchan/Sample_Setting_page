/**
 * Copyright 2014 Hong,SeongChan (seongchan116@gmail.com)
 * 
 * 코드 작성에 대해서만 저작권한을 가지고 있습니다. 
 * 코드 참조에 대해서는 어떠한 관여하지 않습니다.
 * 
 * Create on $$Date$$
 * 
 * product : $(prject_name)
 * $$Source$$
 * $$Author$$
 * 
 * 안드로이드 세팅 페이지 이동에 대한 테스트용 코드입니다.
 */

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

/**
 * @version 1.0.1
 * @author Hong, SeongChan
 * 
 * 이 클래스는 메인 클래스이다. <br>
 * 
 */
public class MainActivity extends Activity {

    
    static final String TAG = "SETTING_TEST";       // Log TAG 
    
    private Context mContext = this;                // Context
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext=this;
		
		// Button 정의
		Button btn1 = (Button)findViewById(R.id.action_settings);
		Button btn2 = (Button)findViewById(R.id.action_airplane_mode);
		Button btn3 = (Button)findViewById(R.id.action_wireless_settings);
		Button btn6 = (Button)findViewById(R.id.action_wifi_settings);
		Button btn4 = (Button)findViewById(R.id.action_nfc_settings);
		Button btn5 = (Button)findViewById(R.id.action_dummy);
		
		// Button Click Listener 등록
		btn1.setOnClickListener(new onSettingClick());
		btn2.setOnClickListener(new onSettingClick());
		btn3.setOnClickListener(new onSettingClick());
		btn4.setOnClickListener(new onSettingClick());
		btn5.setOnClickListener(new onSettingClick());
		btn6.setOnClickListener(new onSettingClick());
		
	}

	/**
	 * 버튼 Click Listener 클래
	 * @author Hong, SeongChan
	 *
	 */
	class onSettingClick implements OnClickListener {
		@Override
		public void onClick(View v) {
		    Log.d(TAG, "onClick()");
			Intent intent;
			switch (v.getId()) {
			case R.id.action_settings :              // 환경 설정 페이지 이동
				try {
				    intent = new Intent(Settings.ACTION_SETTINGS);
				    startActivity(intent);
				} catch (ActivityNotFoundException e) {
				    Log.d(TAG, " activity not found:ACTION_SETTINGS");
				    Toast.makeText(mContext, getString(R.string.error_activity_settings), Toast.LENGTH_SHORT).show();
				}
				break;
				
			case R.id.action_airplane_mode :         // 비행기 모드 설정 페이지 이동 
                try {
                    intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_AIRPLANE_MODE_SETTINGS");
                    Toast.makeText(mContext, getString(R.string.error_activity_airplane), Toast.LENGTH_SHORT).show();
                }
				break;
				
			case R.id.action_wireless_settings :     // 무선 인터넷 설정 페이지 이동
                try {
                    intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_WIRELESS_SETTINGS");
                    Toast.makeText(mContext, getString(R.string.error_activity_wireless), Toast.LENGTH_SHORT).show();
                }
				break;
				
            case R.id.action_wifi_settings :        // WiFi 설정 페이지 이동 
                try {
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_WIFI_SETTINGS");
                    Toast.makeText(mContext, getString(R.string.error_activity_wifi), Toast.LENGTH_SHORT).show();
                }
                break;
                
			case R.id.action_nfc_settings :          // NFC 설정 페이지 이동 
                try {
                    intent = new Intent("android.settings.NFC_SETTINGS");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_NFC_SETTINGS");
                    Toast.makeText(mContext, getString(R.string.error_activity_nfc), Toast.LENGTH_SHORT).show();
                }
				break;
				
			case R.id.action_dummy :                 // 더미 Action : 안내 Noti 팝업 뜨는지 여부 확인용 
                try {
                    intent = new Intent("com.ubivelox.test.test");
                    Log.d(TAG, " activity call :ACTION_DUMMY");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d(TAG, " activity not found:ACTION_DUMMY");
                    Toast.makeText(mContext, getString(R.string.error_activity_dummy), Toast.LENGTH_SHORT).show();
                }
                break;
				
			}
		}
		
	}

}
