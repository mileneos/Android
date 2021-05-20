package ru.mirea.zernov.practice3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent2 = getIntent();
        String string = intent2.getStringExtra("m");

        TextView time = (TextView) findViewById(R.id.textView);
        time.setText(string);
    }
}