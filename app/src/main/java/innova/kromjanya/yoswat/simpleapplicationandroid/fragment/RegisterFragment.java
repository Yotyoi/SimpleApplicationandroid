package innova.kromjanya.yoswat.simpleapplicationandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import innova.kromjanya.yoswat.simpleapplicationandroid.MainActivity;
import innova.kromjanya.yoswat.simpleapplicationandroid.R;

/**
 * Created by ThinkPad on 10/10/2560.
 */

public class RegisterFragment extends Fragment {


    //    Explicit
    private String nameString, userString, passwordString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;
    }   // onCreate

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Toolbar controller

        toolbarController();
    }

    private void toolbarController() {

//        ConfigToolbar
        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

//        Setup title
        ((MainActivity) getActivity()).setTitle(getResources().getString(R.string.new_register));

//        BackController
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

//        Save Controller

        ImageView imageView = (ImageView) getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Get value From Edit Text
                EditText nameEditText = (EditText) getView().findViewById(R.id.editName);
                EditText userEditText = (EditText) getView().findViewById(R.id.editPassword);
                EditText passwordEditText = (EditText) getView().findViewById(R.id.editPassword);



            }  //onClick
        });

    }
} // main class
