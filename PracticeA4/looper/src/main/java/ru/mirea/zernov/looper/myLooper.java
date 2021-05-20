package ru.mirea.zernov.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class myLooper extends Thread{
    public int number = 0;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("Name:Alexandra", 3 + "sec:"+ msg.getData().getString("KEY"));
                number++;
            }
        };
        Looper.loop();
    }
}
