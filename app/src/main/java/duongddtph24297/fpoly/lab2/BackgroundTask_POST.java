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

public class BackgroundTask_POST extends AsyncTask<Void,Void,Void> {
    String duongdan = Bai2Activity.SERVER_NAME;
    TextView tvResult;
    String width, length;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_POST(TextView tvResult, String width, String length, Context context) {
        this.tvResult = tvResult;
        this.width = width;
        this.length = length;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(duongdan);
            String param = "chieurong=" + URLEncoder.encode(width,"utf-8") +"&chieudai=" +
                    URLEncoder.encode(length,"utf-8");
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
