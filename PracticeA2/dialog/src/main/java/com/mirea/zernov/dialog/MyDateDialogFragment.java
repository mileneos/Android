package com.mirea.zernov.dialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {
    public Calendar Date;

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Date.set(Calendar.YEAR, year);
            Date.set(Calendar.MONTH, monthOfYear);
            Date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            ToastBar();
        }
    };

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new DatePickerDialog(getActivity(), d,
                Date.get(Calendar.YEAR),
                Date.get(Calendar.MONTH),
                Date.get(Calendar.DAY_OF_MONTH));
    }

    public MyDateDialogFragment(){
        Date = Calendar.getInstance();
    }

    public void ToastBar(){
        String x = "";
        String a;
        if(Date.get(Calendar.DAY_OF_MONTH) < 10)
            a = "0" + Date.get(Calendar.DAY_OF_MONTH);
        else
            a = String.valueOf(Date.get(Calendar.DAY_OF_MONTH));

        String b;
        if(Date.get(Calendar.MONTH) < 10)
            b = "0" + Date.get(Calendar.MONTH);
        else
            b = String.valueOf(Date.get(Calendar.MONTH));

        x = a + "." + b + "." + Date.get(Calendar.YEAR);

        Toast.makeText(getActivity(), x,
                Toast.LENGTH_LONG).show();
    }
}
