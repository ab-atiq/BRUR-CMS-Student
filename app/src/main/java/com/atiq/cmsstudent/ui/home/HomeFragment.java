package com.atiq.cmsstudent.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atiq.cmsstudent.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ImageSlider imageSlider;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        imageView = view.findViewById(R.id.map);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://www.bssnews.net/assets/news_photos/2022/04/24/image-57658-1650807255.jpg","Begum Rokeya University, Rangpur", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://brur.ac.bd/wp-content/uploads/2021/11/BRUR-Photo-5-10.11.2021-400x200.jpg","International Accounting Day Celebration",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzzBRszjz0NDoebCacXaMwP8dBlcDjxjhu60jr8-5OBX52NM5pIgQsH6GloVfpOWzzOZ8&usqp=CAU","Meeting with all teachers",ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(imageList);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0, 0?q=BRUR");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        return view;
    }
}