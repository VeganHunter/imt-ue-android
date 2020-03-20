package fr.example.imt_atlantique.myfirstapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewLastNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewLastNameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView lastNameTextView;
    private String lastname;

    public ViewLastNameFragment(String lastname) {
        // Required empty public constructor
        this.lastname = lastname;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewLastNameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewLastNameFragment newInstance(String param1, String param2) {
        ViewLastNameFragment fragment = new ViewLastNameFragment("thomas");
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

        View rootview =  inflater.inflate(R.layout.fragment_view_last_name, container, false);
        lastNameTextView = rootview.findViewById(R.id.lastNameTextView);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //lastNameTextView.setText(((MainActivity)getActivity()).getLastNameField().getText().toString());
        lastNameTextView.setText(lastname);

    }

}
