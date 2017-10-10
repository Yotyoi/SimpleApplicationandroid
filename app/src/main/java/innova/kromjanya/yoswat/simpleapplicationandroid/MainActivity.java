package innova.kromjanya.yoswat.simpleapplicationandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import innova.kromjanya.yoswat.simpleapplicationandroid.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment to Activity
        if (savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contentFragmentmain, new MainFragment()).commit();
        }

    } // main method

}// main class
