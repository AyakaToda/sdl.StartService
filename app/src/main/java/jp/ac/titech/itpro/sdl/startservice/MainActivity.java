package jp.ac.titech.itpro.sdl.startservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private final static String TAG = MainActivity.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Log.d(TAG, "onReceive: " + action);
                //if (action == null) { return; }
                //Toast toast = Toast.makeText(MainActivity.this, intent.getStringExtra(Service3.EXTRA_ANSWER), Toast.LENGTH_LONG);
                Toast toast = Toast.makeText(MainActivity.this, "ロードラはいいぞ", Toast.LENGTH_LONG);
                toast.show();
            }
        };
        intentFilter = new IntentFilter();
        intentFilter.addAction(Service3.ACTION_ANSWER);
        registerReceiver(broadcastReceiver, intentFilter);

        Log.d(TAG, "onCreate in " + Thread.currentThread());
        setContentView(R.layout.activity_main);
    }

    public void onClickTest1(View v) {
        Log.d(TAG, "onClickTest1 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service1.class);
        intent.putExtra(Service1.EXTRA_MYARG, "Hello, Service1");
        startService(intent);
    }

    public void onClickTest2(View v) {
        Log.d(TAG, "onClickTest2 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service2.class);
        intent.putExtra(Service2.EXTRA_MYARG, "Hello, Service2");
        startService(intent);
    }

    public void onClickTest3(View v){
        Log.d(TAG, "onClickTest3 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service3.class);
        intent.putExtra(Service3.EXTRA_MYARG, "Hello, Service3");
        startService(intent);
    }
}
