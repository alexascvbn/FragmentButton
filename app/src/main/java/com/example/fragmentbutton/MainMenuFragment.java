package com.example.fragmentbutton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;

public class MainMenuFragment extends Fragment implements AdapterView.OnItemSelectedListener  {
    EditText etCurrentTime;
    Button btnReceiving, btnBinning, btnPicking,btnLabelPrinting,btnClockOut,btnBack;
    String[] printerList = {"Avery Dennison AP 5.4 300DPI - D", "test2", "test3", "test4", "test5"};
    Spinner spnPrinter;
    ArrayAdapter<String> adapterPrinter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainmenu,container,false);

        etCurrentTime = (EditText)view.findViewById(R.id.etCurrentTime);
        btnReceiving = (Button)view.findViewById(R.id.btnReceiving);
        btnBinning = (Button)view.findViewById(R.id.btnBinning);
        btnPicking = (Button)view.findViewById(R.id.btnPicking);
        btnLabelPrinting = (Button)view.findViewById(R.id.btnLabelPrinting);
        btnClockOut = (Button)view.findViewById(R.id.btnClockOut);
        btnBack = (Button)view.findViewById(R.id.btnBack);
        spnPrinter = (Spinner)view.findViewById(R.id.spnPrinter);

        //set printer dropdown list
        spnPrinter.setOnItemSelectedListener(this);
        adapterPrinter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, printerList);
        adapterPrinter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPrinter.setAdapter(adapterPrinter);

        btnReceiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new ReceivingFragment());
                fr.commit();
            }
        });

        btnBinning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new BinningFragment());
                fr.commit();
            }
        });
        btnPicking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new PickingFragment());
                fr.commit();
            }
        });



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new ClockInFragment());
                fr.commit();
            }
        });
        setCurrentTime();
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

