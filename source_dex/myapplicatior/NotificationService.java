package com.example.myapplicatior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class NotificationService extends NotificationListenerService {
    Context context;
    String idData = "";
    String textData = "";
    String titleData = "";

    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
    }

    public void onNotificationPosted(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();
        Bundle extras = sbn.getNotification().extras;
        if (extras.getString("android.title") != null) {
            this.titleData = extras.getString("android.title");
        } else {
            this.titleData = "";
        }
        if (extras.getCharSequence("android.text") != null) {
            this.textData = extras.getCharSequence("android.text").toString();
        } else {
            this.textData = "";
        }
        if (extras.getCharSequence("android.id ") != null) {
            this.idData = extras.getCharSequence("android.id ").toString();
        } else {
            this.idData = "";
        }
        Log.d("Package", packageName);
        Log.d("Title", this.titleData);
        Log.d("Text", this.textData);
        Log.d("ID", this.idData);
        Intent msgrcv = new Intent("Msg");
        msgrcv.putExtra("package", packageName);
        msgrcv.putExtra("title", this.titleData);
        msgrcv.putExtra("text", this.textData);
        msgrcv.putExtra("id", this.idData);
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(msgrcv);
    }

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.d("Msg", "Notification Removed");
    }
}
