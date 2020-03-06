package com.example.fragmentapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText wordfield;
    private Activity activity;


    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */



    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment Lifecycle", "onCreate method");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Fragment Lifecycle", "onCreateView method");
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_blank, container, false);
        wordfield = rootView.findViewById(R.id.editText);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.i("Fragment Lifecycle", "onActivityCreated method");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
        Log.i("Fragment Lifecycle", "onAttach method");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Fragment Lifecycle", "onDetach method");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment Lifecycle", "onStart method");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Fragment Lifecycle", "onResume method");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment Lifecycle", "onPause method");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Fragment Lifecycle", "onStop method");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment Lifecycle", "onDestroy method");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Fragment Lifecycle", "onDestroyView method");
    }

}
