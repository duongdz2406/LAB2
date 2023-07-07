package duongddtph24297.fpoly.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST_Bai3 extends AsyncTask<String,Void,Void> {
    String duongdan = Bai3Activity.SERVER_NAME;
    TextView tvResult;

    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_POST_Bai3(TextView tvResult, Context context) {
        this.tvResult = tvResult;
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(duongdan);
            String param = "canh=" + URLEncoder.encode(strings[0].toString(),"utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Caculating...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);

    }
}

