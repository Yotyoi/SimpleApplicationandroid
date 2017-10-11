package innova.kromjanya.yoswat.simpleapplicationandroid.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import innova.kromjanya.yoswat.simpleapplicationandroid.MainActivity;
import innova.kromjanya.yoswat.simpleapplicationandroid.R;
import innova.kromjanya.yoswat.simpleapplicationandroid.utility.MyAlert;

/**
 * Created by ThinkPad on 10/10/2560.
 */

public class RegisterFragment extends Fragment {


    //    Explicit
    private String nameString, userString, passwordString;
    private Uri uri;
    private ImageView imageView;
    private boolean aBoolean = true;
    private String tag = "11octV1";


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
//        Humen Controller
        humenController();

    }      //main method

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {


            Log.d(tag, "Result OK");

            aBoolean = false;

            try {
                uri = data.getData();
                Bitmap bitmap = BitmapFactory
                        .decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // if

    }   // on ActivityResult

    private void humenController() {
        imageView = (ImageView) getView().findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Please Choose Application"), 1);


            }   // on Click
        });
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

//                CheckData type
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();


//                    check spec
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {

//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please Fill All Every Blank");


                } else if (aBoolean) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("No Image", "Please Choose Image");
                } else {

                    upLoadValuetoSever();

                }

            }  //onClick
        });

    }

    private void upLoadValuetoSever() {


        //find path image
        String strPathImage = "";
        String[] strings = new String[]{MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, strings,
                null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            strPathImage = cursor.getString(index);
        }
        else
        {
            strPathImage = uri.getPath();
        }

        Log.d(tag, "Path of Image ==> " + strPathImage);
    }  //upload


} // main class
