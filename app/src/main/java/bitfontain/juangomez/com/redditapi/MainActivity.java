package bitfontain.juangomez.com.redditapi;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    public final String REDDIT_URL = "http://www.reddit.com/r/all.json?limit=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*** Asynchronous Get request ***/
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(REDDIT_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("RESPONSE", response.toString());
            }
        });
        /*** End Asynchronous request  ***/

        /*** Uncomment this to see synchronous calls ***/
        /*//Execute MyAsyncTask
        MyAsyncTask myTask = new MyAsyncTask();
        myTask.execute("My first parm", "My second param");*/
        /*** End ***/
    }

    /*** Uncomment this for synchronous call bACK ***/
    /*//Parameters Types 1st Params, 2nd Progress, 3rd Result
    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        //Implement mandatory method
        @Override
        protected String doInBackground(String... params) {

            //Using OkHttp library.   http://square.github.io/okhttp/
            //With this we can do asynchronous request of synchronous request. Here we are doing synchronous request,
            //because we are waitting for the response to happen.
            OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(REDDIT_URL)
                        .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

            *//*String firstParam = params[1];
            String result = "";

            HttpClient httpClient = new DefaultHttpClient();
            //We cand do here an httpPost request.
            HttpGet httpGet = new HttpGet(REDDIT_URL);

            try {
                HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
                InputStream is = response.getEntity().getContent();

                result = inputStreamToString(is);


            } catch (IOException e) {
                //Ignore if the connection fails
                e.printStackTrace();
            }

            return result;*//*

        }

        *//*private String inputStreamToString(InputStream is) {
            String line = "";
            StringBuilder total = new StringBuilder();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {

                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }

            } catch (IOException e) {
                //Error reading the stream
            }

            return total.toString();
        }*//*


        //Override this method
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

        }
    }*/
    /*** End Synchronous callback ***/


}
