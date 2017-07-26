package com.swu.fcm.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Push Message 가 날라오면 처리하는 콜백 메서드
        Map<String, String> data = remoteMessage.getData();

        if(data != null && data.size() > 0) {
            try {
                Gson gson = new Gson();
                //Map --> JSON
                String dataJson = gson.toJson(data);

                //JSON --> PushMsgBean.Data 로 변환
                PushMsgBean.Data pushMsgData = gson.fromJson(dataJson, PushMsgBean.Data.class);

                //Noti호출
                showNoti(pushMsgData);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }//end OnMessageReceived

    private void showNoti(PushMsgBean.Data data) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri dafSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setTicker( data.getTitle() )
                .setContentTitle( data.getTitle() )
                .setContentText( data.getMessage() )
                .setAutoCancel(true)
                .setSound( dafSoundUri )
                .setContentIntent( pendingIntent );

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify( (int)System.currentTimeMillis(), builder.build() );

    }







}
