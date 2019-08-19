package com.example.fragmentbutton;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;


public class ClockInFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    EditText etCurrentTime;
    Button btnClockIn, btnBack;
    Spinner spnCountry, spnJob;
    String[] companyList = {"01 Crown Motors Ltd.", "05 Nova Motors Limited", "08 Future Motors Limited", "09 British Motors Limited"};
    String[] jobList = {"D02D - Receing Sea", "D03D - Binning", "D04D - Picking", "|01| - Warehouse Maintenance", "|02| - Stock Check",
            "|03| - Delivery", "|04| - Training", "|05| - Meeting"};
    ArrayAdapter<String> adapterCountry;
    ArrayAdapter<String> adapterJob;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clockin, container, false);

        spnCountry = (Spinner) view.findViewById(R.id.spnCountry);
        spnJob = (Spinner) view.findViewById(R.id.spnJob);
        btnClockIn = (Button) view.findViewById(R.id.btnClockIn);
        btnBack = (Button) view.findViewById(R.id.btnBack);
        etCurrentTime = (EditText) view.findViewById(R.id.etCurrentTime);

        setCurrentTime();

        btnClockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new MainMenuFragment());
                fr.commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new LoginFragment());
                fr.commit();
            }
        });

        //set company dropdown list
        spnCountry.setOnItemSelectedListener(this);
        adapterCountry = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, companyList);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCountry.setAdapter(adapterCountry);

        //set job dropdown list
        spnJob.setOnItemSelectedListener(this);
        adapterJob = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, jobList);
        adapterJob.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJob.setAdapter(adapterJob);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void setCurrentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        etCurrentTime.setFocusable(false);
        etCurrentTime.setText(date);
    }
}
