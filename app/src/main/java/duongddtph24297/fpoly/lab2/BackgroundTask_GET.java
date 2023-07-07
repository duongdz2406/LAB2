package duongddtph24297.fpoly.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<Void,Void,Void> {
    String duongdan = MainActivity.SERVER_NAME;
    TextView tvResult;
    String name, score;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_GET(TextView tvResult, String name, String score, Context context) {
        this.tvResult = tvResult;
        this.name = name;
        this.score = score;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" +this.name +"&score="+this.score;
        try {
            URL url = new URL(duongdan);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine())!=null){
                sb.append(line);
            }
            str = sb.toString();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
