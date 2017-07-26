package com.swu.fcm.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //토큰 저장 로직 - 송강가사 오늘 피곤하다. 잘하자!
        // 아아아아
        // 배고파 너무 고파
        String savedToken = PrefUtil.getPref(this, MyFirebaseInstanceIDService.PUSH_TOKEN);
        if(savedToken != null || savedToken.length() == 0) {
            savedToken = FirebaseInstanceId.getInstance().getToken();
            if(savedToken != null) {
                PrefUtil.setPref(this, MyFirebaseInstanceIDService.PUSH_TOKEN, savedToken);
                Log.e("TEST", savedToken);
            }
        }


    }
}
