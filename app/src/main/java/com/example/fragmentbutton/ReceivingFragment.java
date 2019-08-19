package com.example.fragmentbutton;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class ReceivingFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spnFranchise, spnDept;
    EditText etCaseNo;
    Button btnClose;
    String[] FranchiseList = {"Toyota", "Lexus", "Hino", "User car", "商用車"};
    String[] DeptList = {"Material Handler", "Loader", "Warehouse Clerk", "Operator"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receiving, container, false);

        spnFranchise = (Spinner) view.findViewById(R.id.spnFranchise);
        spnDept = (Spinner) view.findViewById(R.id.spnDept);
        etCaseNo = (EditText) view.findViewById(R.id.etCaseNo);
        btnClose = (Button) view.findViewById(R.id.btnClose);

        ArrayAdapter<String> adapterFranchise;
        ArrayAdapter<String> adapterDept;
        // set company dropdown list

        spnFranchise.setOnItemSelectedListener(this);
        adapterFranchise = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, FranchiseList);
        adapterFranchise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFranchise.setAdapter(adapterFranchise);

        // set company dropdown list
        spnDept.setOnItemSelectedListener(this);
        adapterDept = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, DeptList);
        adapterDept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDept.setAdapter(adapterDept);
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
