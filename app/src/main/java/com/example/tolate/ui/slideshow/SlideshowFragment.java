package com.example.tolate.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tolate.R;

public class SlideshowFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
      //  final TextView textView = root.findViewById(R.id.text_slideshow);
        final Button button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String sharebody = "Download this application now!-https://drive.google.com/file/d/1MY9DaLCLWAT55RR21Po-hNhI6SACuyrP/view?usp=sharing&hl=en";
                String sharesub = "Tolet app";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                shareIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(shareIntent,"Share Using"));
            }
        });


        return root;
    }
}