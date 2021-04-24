package com.simrnpuri.foodorder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class Fragment_Menu_Layout extends Fragment{


    //a list to store all the products
    private List<FoodItems> foodItemsList;

    //the recyclerview
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment__menu__layout, container, false);

        //getting the recyclerview from xml
        recyclerView = view.findViewById(R.id.rv);

        foodItemsList = new ArrayList<>();

        foodItemsList.add(
                new FoodItems(
                        1,
                        getString(R.string.Pizza),
                        "Thin crust pizza topped with onions, tomatoes, capsicum, olives and jalapenos",
                        18,
                        R.drawable.pizza));

        foodItemsList.add(
                new FoodItems(
                        2,
                        "Cold Drink",
                        "Carbonated canned Drink Coca Cola 300 ml in a can",
                        8,
                        R.drawable.coldrink));

        foodItemsList.add(
                new FoodItems(
                        3,
                        "Fried Chicken",
                        "Deep Fried Chicken with Salsa sauce served with salad and chips",
                        15,
                        R.drawable.friedchicken));

        foodItemsList.add(
                new FoodItems(
                        4,
                        "Hamburger",
                        "Burger with thick Ham patty, vegetables and cheese and vegetables",
                        15,
                        R.drawable.hamburger));

        foodItemsList.add(
                new FoodItems(
                        5,
                        "Hash Brown",
                        "Hash Brown Potato Patty, fried and crispy, served hot",
                        5,
                        R.drawable.hashbrowns));

        foodItemsList.add(
                new FoodItems(
                        6,
                        "Cheese Sandwich",
                        "Grilled Cheese Sandwich with onions, tomatoes, lettuce, olives, capsicum",
                        10,
                        R.drawable.sandwich));

        //creating recyclerview adapter
        // we are initializing our adapter class and passing our arraylist to it.
        FoodItemsAdapter adapter = new FoodItemsAdapter(getActivity(), foodItemsList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv);
    }


}