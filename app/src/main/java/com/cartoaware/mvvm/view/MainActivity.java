package com.cartoaware.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.cartoaware.mvvm.adapter.PixabayPhotosAdapter;
import com.cartoaware.mvvm.data.Hit;
import com.cartoaware.mvvm.viewmodel.PixabayPhotosViewModel;
import com.cartoaware.mvvmdemo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Hit> pixabayPhotosList = new ArrayList<>();
    PixabayPhotosAdapter pixabayPhotosAdapter;
    RecyclerView pixabayPhotosRecyclerView;
    PixabayPhotosViewModel pixabayPhotosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        pixabayPhotosRecyclerView = findViewById(R.id.pixabay_photos_recyclerview);

        setupRecyclerView();

        pixabayPhotosViewModel = ViewModelProviders.of(this).get(PixabayPhotosViewModel.class);
        pixabayPhotosViewModel.init();
        pixabayPhotosViewModel.getPixabayRepository().observe(this, pixabayResponse ->{
            if(pixabayResponse == null){
                Toast.makeText(getBaseContext(), "Errors base response", Toast.LENGTH_LONG).show();
            }else {
                if (pixabayResponse.getHits() != null) {
                    pixabayPhotosList.addAll(pixabayResponse.getHits());
                    pixabayPhotosAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getBaseContext(), "Errors loading photo hits!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
    }
    private void setupRecyclerView() {
        if (pixabayPhotosAdapter == null) {
            pixabayPhotosAdapter = new PixabayPhotosAdapter(pixabayPhotosList);
            pixabayPhotosRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            pixabayPhotosRecyclerView.setAdapter(pixabayPhotosAdapter);
        } else {
            pixabayPhotosAdapter.notifyDataSetChanged();
        }
    }
}
