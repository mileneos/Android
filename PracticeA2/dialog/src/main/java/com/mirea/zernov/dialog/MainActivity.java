package com.mirea.zernov.dialog;


import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickShowDialog (View view)
    {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "MIREA");
    }
    public void onOkClicked(){
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!", Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked(){
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!", Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked(){
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!", Toast.LENGTH_LONG).show();
    }
    public void onClickShowTimeDialog(View v){
        MyTimeDialogFragment time = new MyTimeDialogFragment();
        time.show(getSupportFragmentManager(),"mirea");
    }
    public void onClickShowDateDialog(View v){
        MyDateDialogFragment time = new MyDateDialogFragment();
        time.show(getSupportFragmentManager(),"mirea");
    }
    public void onClickShowProgressDialog(View v){
        MyProgressDialogFragment time = new MyProgressDialogFragment(this);
        time.show();
    }
}