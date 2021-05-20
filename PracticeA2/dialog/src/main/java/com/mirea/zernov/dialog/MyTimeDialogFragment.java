package com.mirea.zernov.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment {
    public Calendar DateAndTime;
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            DateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            DateAndTime.set(Calendar.MINUTE, minute);
            ToastBar();
        }
    };

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new TimePickerDialog(getActivity(), t,
                DateAndTime.get(Calendar.HOUR_OF_DAY),
                DateAndTime.get(Calendar.MINUTE), true);

    }

    public MyTimeDialogFragment(){ // конструктор
        DateAndTime = Calendar.getInstance();
    }

    public void ToastBar(){
        String x = "";
        if(DateAndTime.get(Calendar.MINUTE) < 10 ){
            x = String.valueOf(DateAndTime.get(Calendar.HOUR_OF_DAY)) +" : 0" + String.valueOf(DateAndTime.get(Calendar.MINUTE));
        }
        else{
            x = String.valueOf(DateAndTime.get(Calendar.HOUR_OF_DAY)) +" : " + String.valueOf(DateAndTime.get(Calendar.MINUTE));
        }

        Toast.makeText(getActivity(), x,
                Toast.LENGTH_LONG).show();
    }
}
