package innova.kromjanya.yoswat.simpleapplicationandroid.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import innova.kromjanya.yoswat.simpleapplicationandroid.R;

/**
 * Created by ThinkPad on 11/10/2560.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context)
    {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_alert);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

} // Main Class
