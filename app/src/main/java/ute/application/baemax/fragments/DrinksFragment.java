package ute.application.baemax.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ute.application.baemax.R;
import ute.application.baemax.adapters.MyAdapter;
import ute.application.baemax.dao.Item;


public class DrinksFragment extends Fragment {
    private ArrayList<Item> itemArrayList;
    private  String[] itemName,itemPrice,itemStar, itemDescribe ;
    private int[] itemImage;
    private  RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_drinks, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();

        recyclerView = view.findViewById(R.id.recyclerview_drinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(),itemArrayList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


    }

    private void dataInitialize(){
        itemArrayList = new ArrayList<>();

        itemName = new String[]{
                getString(R.string.name_10),
                getString(R.string.name_11),
                getString(R.string.name_12),
        };

        itemStar = new String[]{
                getString(R.string.star_1),
                getString(R.string.star_2),
                getString(R.string.star_3),
        };

        itemPrice = new String[]{
                getString(R.string.price_1),
                getString(R.string.price_2),
                getString(R.string.price_3),
        };

        itemDescribe = new String[]{
                getString(R.string.describe_1),
                getString(R.string.describe_2),
                getString(R.string.describe_3),
        };

        itemImage = new int[]{
                R.drawable.drink_keto,
                R.drawable.drink_fancy,
                R.drawable.drink_cocktail
        };

        for (int i = 0; i<itemName.length; i++){
            Item item = new Item(itemName[i],itemDescribe[i],itemStar[i], itemPrice[i], itemImage[i]);
            itemArrayList.add(item);
        }

    }
}