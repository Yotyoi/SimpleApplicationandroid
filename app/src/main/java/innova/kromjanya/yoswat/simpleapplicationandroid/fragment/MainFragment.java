package innova.kromjanya.yoswat.simpleapplicationandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import innova.kromjanya.yoswat.simpleapplicationandroid.R;
import innova.kromjanya.yoswat.simpleapplicationandroid.utility.GetAllData;
import innova.kromjanya.yoswat.simpleapplicationandroid.utility.MyAlert;
import innova.kromjanya.yoswat.simpleapplicationandroid.utility.MyConstant;

/**
 * Created by ThinkPad on 10/10/2560.
 */

public class MainFragment extends Fragment {

    String userString;     //
    private String passwordString;    //

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller

        registerController();

//        SignIn Controller

        signInController();


    }

    private void signInController() {
        Button button = (Button) getView().findViewById(R.id.btnSignIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userEditText = (EditText) getView().findViewById(R.id.editUser);
                EditText passwordEdittext = (EditText) getView().findViewById(R.id.editPassword);

                userString = userEditText.getText().toString().trim();
                passwordString = passwordEdittext.getText().toString().trim();

                if (userString.equals("") || passwordString.equals("")) {
//                    Have space

                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "please Fill All Blank");
                } else {
//                  No space

                    checkUserAndPassword();
                }

            }
        });
    }

    private void checkUserAndPassword() {

        String tag = "12octV1";

        Log.d(tag, "Check Working");

        try {


            GetAllData getAllData = new GetAllData(getActivity());
            MyConstant myConstant = new MyConstant();
            getAllData.execute(myConstant.getUrlGetData());
            String resultJason = getAllData.get();
            Log.d(tag, "JSON ==> " + resultJason);

        } catch (Exception e) {
            Log.d(tag, "e check ==> " + e.toString());
        }

    }


    private void registerController() {
        TextView textView = (TextView) getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Move to register

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentmain, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
} // Main class
