package com.simrnpuri.foodorder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment_Cart_Layout extends Fragment {

    private TextView textViewTotal, textViewTax, textViewGrandTotal, textViewEmptyState, textViewTotalNumber, textViewGrandTotalNumber, textViewTaxNumber;
    private EditText editTextAddress;
    private Button buttonPlaceOrder;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TOTAL = "";
    public static final String ADDRESS = "";

    private String total = "";
    private String add = "";

    private ArrayList<String> listStrings ;
    private ListView list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment__cart__layout, container, false);

        textViewTotal = v.findViewById(R.id.textViewTotal);
        textViewGrandTotal = v.findViewById(R.id.textViewGrandTotal);
        textViewTax = v.findViewById(R.id.textViewTax);
        editTextAddress = v.findViewById(R.id.editTextTextPostalAddress);
        buttonPlaceOrder = v.findViewById(R.id.buttonPlaceOrder);
        textViewEmptyState = v.findViewById(R.id.Empty);
        textViewTotalNumber = v.findViewById(R.id.textViewTotalNumber);
        textViewGrandTotalNumber = v.findViewById(R.id.textViewGrandTotalNumber);
        textViewTaxNumber = v.findViewById(R.id.textViewTaxNumber);

        DisplayScreen();

        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ResetData();
                ResetViews();
                //SaveOrder();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    public void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOTAL, textViewTotalNumber.getText().toString());
        editor.putString(ADDRESS, editTextAddress.getText().toString());
        editor.apply();

    }

    public void ResetData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOTAL, "");
        editor.putString(ADDRESS, "");
        editor.apply();

    }

    @Override
    public void onResume(){
        super.onResume();
        loadData();
    }

    @Override
    public void onPause(){
        saveData();
        super.onPause();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        total = sharedPreferences.getString(TOTAL,"");
        add = sharedPreferences.getString(ADDRESS,"");

    }

    public void updateViews(){
        textViewTotalNumber.setText(total);
        editTextAddress.setText(add);
        updateTaxAndGrandTotal(total);
    }

    public void updateTaxAndGrandTotal(String totl){
        double tt = Integer.parseInt(totl);
        double tax =  tt *0.1 ;
        double gt = tt + tax;

        textViewTaxNumber.setText(""+tax);
        textViewGrandTotalNumber.setText(""+gt);
    }

    public void ResetViews(){

        textViewTaxNumber.setText("");
        textViewGrandTotalNumber.setText("");
        textViewTotalNumber.setText("");

    }

    public void DisplayScreen(){
        if(textViewTotalNumber.getText().toString().equals("")){
            textViewEmptyState.setVisibility(View.VISIBLE);
            textViewTotal.setVisibility(View.GONE);
            textViewGrandTotal.setVisibility(View.GONE);
            textViewTax.setVisibility(View.GONE);
            textViewTotalNumber.setVisibility(View.GONE);
            textViewGrandTotalNumber.setVisibility(View.GONE);
            textViewTaxNumber.setVisibility(View.GONE);
            buttonPlaceOrder.setVisibility(View.GONE);
            textViewEmptyState.bringToFront();
            editTextAddress.setVisibility(View.GONE);
        }
        else if (!textViewTotal.getText().toString().equals("")){
            textViewEmptyState.setVisibility(View.GONE);
            textViewTotal.setVisibility(View.VISIBLE);
            textViewGrandTotal.setVisibility(View.VISIBLE);
            textViewTax.setVisibility(View.VISIBLE);
            textViewTotalNumber.setVisibility(View.VISIBLE);
            textViewGrandTotalNumber.setVisibility(View.VISIBLE);
            textViewTaxNumber.setVisibility(View.VISIBLE);
            buttonPlaceOrder.setVisibility(View.VISIBLE);
            editTextAddress.setVisibility(View.VISIBLE);
        }
    }

}




/*
        String max length 2billion

        String curr = "{
            "crust": "thin",
            "pineapple": 0,
            "tomato": 5
        }";

        String orders = pref.getString("orders", "");
        orders = curr + ", " + orders;

        putString("crust", "thin");
        putInt("tomatoes", 5);
 */