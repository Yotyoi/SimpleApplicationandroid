package innova.kromjanya.yoswat.simpleapplicationandroid.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by ThinkPad on 12/10/2560.
 */

public class UploadValuetoServer extends AsyncTask<String,Void,String>{

    private Context context;

    public UploadValuetoServer(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("name", params[0])
                    .add("user", params[1])
                    .add("password", params[2])
                    .add("image", params[3])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[4]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().toString();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
} // main class
