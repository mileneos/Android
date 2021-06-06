package ru.mirea.zernov.mireaproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InfoSensors extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoSensors() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatchikiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoSensors newInstance(String param1, String param2) {
        InfoSensors fragment = new InfoSensors();
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
    private SensorManager sensorManager;
    private ListView listCountSensor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.infosensors_frag, container, false);
        listCountSensor = root.findViewById(R.id.list_view);
        SensorManager sensorManager =
                (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // создаем список для отображения в ListView найденных датчиков
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        HashMap<String, Object> sensorTypeList;
        for (int i = 0; i < sensors.size(); i++) {
            sensorTypeList = new HashMap<>();
            sensorTypeList.put("Name", sensors.get(i).getName());
            sensorTypeList.put("Value", sensors.get(i).getMaximumRange());
            arrayList.add(sensorTypeList);
        }
        // создаем адаптер и устанавливаем тип адаптера - отображение двух полей
        SimpleAdapter mHistory =
                new SimpleAdapter(getActivity(), arrayList, android.R.layout.simple_list_item_2,
                        new String[]{"Name", "Value"},
                        new int[]{android.R.id.text1, android.R.id.text2});
        listCountSensor.setAdapter(mHistory);
        return root;
    }
}