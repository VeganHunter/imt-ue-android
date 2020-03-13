package fr.example.imt_atlantique.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.ClipboardManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import static android.content.Context.MODE_PRIVATE;
import static android.text.InputType.TYPE_CLASS_PHONE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InputFragment() {
        // Required empty public constructor
        Log.i("Fragment Lifecycle", "empty constructor method");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InputFragment newInstance(String param1, String param2) {
        Log.i("Fragment Lifecycle", "constructor method");
        InputFragment fragment = new InputFragment();
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

    /* Fonction pour charger des les données des prefs */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity) getActivity()).onFragmentInput();

        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);

        String savedPrenom = prefs.getString("firstName", "");
        ((MainActivity) getActivity()).getFirstNameField().setText(savedPrenom);

        String savedNom = prefs.getString("lastName", "");
        ((MainActivity) getActivity()).getLastNameField().setText(savedNom);

        String saveBirthdate = prefs.getString("birthdate", "");
        ((MainActivity) getActivity()).getBirthdateField().setText(saveBirthdate);

        String savedVille = prefs.getString("ville", "");
        ((MainActivity) getActivity()).getCityField().setText(savedVille);

        int numdep = prefs.getInt("numDep", 0);
        ((MainActivity) getActivity()).getDepartmentField().setSelection(numdep);

        int nbPhones = prefs.getInt("nbPhones",0);
        for (int i=0; i<nbPhones; i++) {
            String phone = prefs.getString("phone"+i, "");
            ((MainActivity) getActivity()).addPhoneNumber(((MainActivity) getActivity()).getTable());
            TableRow r = (TableRow) ((MainActivity) getActivity()).getTable().getChildAt(i);
            EditText t = (EditText) r.getChildAt(0);
            t.setText(phone);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_input, container, false);
        return rootView;

    }

}
