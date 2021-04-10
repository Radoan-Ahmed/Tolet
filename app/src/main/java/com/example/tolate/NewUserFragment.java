package com.example.tolate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewUserFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText price,phonenum,location;
    private RadioGroup radio1,radio2;
    private Button bt;
    public String rFValue,rSValue;
    private FirebaseDatabase database;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewUserFragment newInstance(String param1, String param2) {
        NewUserFragment fragment = new NewUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_user, container, false);
        price = view.findViewById(R.id.price);
        phonenum = view.findViewById(R.id.phoneNum);
        location = view.findViewById(R.id.location);
        radio1 = view.findViewById(R.id.radio1);
        radio2 = view.findViewById(R.id.radio2);
        bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(this);

        allValue();

        return view;
    }

    private void allValue() {
        radio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd1:
                        rFValue = "1";
                        break;
                    case R.id.rd2:
                        rFValue = "2";
                        break;
                    case R.id.rd3:
                        rFValue = "3";
                        break;
                    case R.id.rd4:
                        rFValue = "4";
                        break;
                }
            }
        });

        radio2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbt1:
                        rSValue = "1";
                        break;
                    case R.id.rdbt2:
                        rSValue = "2";
                        break;
                    case R.id.rdbt3:
                        rSValue = "3";
                        break;
                    case R.id.rdbt4:
                        rSValue = "4";
                        break;

                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt:
                String priceValue = price.getText().toString();
                String PhoneNumber = phonenum.getText().toString();
                String locationValue = location.getText().toString();

                if(locationValue.isEmpty()){
                    location.setError("Enter location!");
                    location.requestFocus();
                }

                NewUserGetValue newUserGetValue =new NewUserGetValue(priceValue,PhoneNumber,locationValue,rFValue,rSValue);
                database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("HomeInfo")
                        .child(PhoneNumber);
                reference.setValue(newUserGetValue);

                Toast.makeText(getContext(),"Your data is save",Toast.LENGTH_SHORT).show();


        }
    }
}