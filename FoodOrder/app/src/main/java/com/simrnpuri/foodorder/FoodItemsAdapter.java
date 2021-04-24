package com.simrnpuri.foodorder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemsAdapter.FoodItemsViewHolder>{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FoodItems> foodItemsList;

    //getting the context and product list with constructor
    public FoodItemsAdapter(Context mCtx, List<FoodItems> foodItemsList) {
        this.mCtx = mCtx;
        this.foodItemsList = foodItemsList  ;
    }

    @Override
    public FoodItemsAdapter.FoodItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.menu_card_layout, null);
        return new FoodItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodItemsViewHolder holder, int position) {

        FoodItems product = foodItemsList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewPrice.setText("$"+String.valueOf(product.getPrice()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        //holder.addButton.setVisibility(View.VISIBLE);
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  // add food to order
                String name = product.getTitle();
                double price = product.getPrice();

            }
        });


    }


    @Override
    public int getItemCount()
    // this method is used for showing number
    // of card items in recycler view.
    {
        return foodItemsList.size();
    }


    class FoodItemsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewShortDesc, textViewPrice;
        private ImageView imageView;
        private Button addButton;

        public FoodItemsViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.foodItemName);
            textViewShortDesc = itemView.findViewById(R.id.foodDescription);
            textViewPrice = itemView.findViewById(R.id.foodItemPrice);
            imageView = itemView.findViewById(R.id.foodImage);
            addButton = itemView.findViewById(R.id.tvb);
            //addButton.setVisibility(View.VISIBLE);

        }
    }

}
