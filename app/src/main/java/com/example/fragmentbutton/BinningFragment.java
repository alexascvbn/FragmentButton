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
import android.widget.Spinner;


public class BinningFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    String[] FranchiseList = {"Toyota", "Lexus", "Hino", "User car", "商用車"};
    Spinner spnFranchise;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_binning, container, false);
        spnFranchise = (Spinner)view.findViewById(R.id.spnFranchise);
        ArrayAdapter<String> adapterFranchise;

        spnFranchise.setOnItemSelectedListener(this);
        adapterFranchise = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, FranchiseList);
        adapterFranchise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFranchise.setAdapter(adapterFranchise);

        return view;
    }
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
