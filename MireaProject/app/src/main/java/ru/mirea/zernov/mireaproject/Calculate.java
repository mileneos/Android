package ru.mirea.zernov.mireaproject;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class Calculate extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculate() {
        // Required empty public constructor
    }
    public static Calculate newInstance(String param1, String param2) {
        Calculate fragment = new Calculate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    Button btS;
    Button btM;
    Button btU;
    Button btD;
    TextView textView;
    EditText editText;
    EditText editText1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.calculate_frag, container, false);
        btS = (Button) root.findViewById(R.id.button);
        btM = (Button) root.findViewById(R.id.button2);
        btU = (Button) root.findViewById(R.id.button3);
        btD = (Button) root.findViewById(R.id.button4);
        editText = (EditText) root.findViewById(R.id.editTextTextPersonName2);
        editText1 = (EditText) root.findViewById(R.id.editTextTextPersonName);
        textView = (TextView) root.findViewById(R.id.textView2);
        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k = a1 + b1;
                String str1 = Double.toString(k);
                textView.setText(str1);
            }
        });
        btM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());

                double k1 = a1 - b1;
                String str1 = Double.toString(k1);
                textView.setText(str1);
            }
        });
        btU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k2 = a1 * b1;
                String str1 = Double.toString(k2);
                textView.setText(str1);
            }
        });
        btD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                double a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                double b1 = Integer.parseInt(b.trim());
                if (b1 == 0)
                {
                    textView.setText("Error");
                }
                else
                {
                    double k3 = a1 / b1;
                    String str1 = Double.toString(k3);
                    textView.setText(str1);
                }

            }
        });
        return root;
    }
    @Override
    public void onClick(View v) {
    }
}