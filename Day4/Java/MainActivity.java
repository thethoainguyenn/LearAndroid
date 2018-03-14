package com.example.thoailun.day4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ReadJSON().execute("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        new ReadRss().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");







    }
    // Add fragment
    public  void AddFragment(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case (R.id.btnListView):
                fragment = new FragmentListView();
                break;
            case (R.id.btnGridView):
                fragment = new FragmentGridView();
                break;
        }

        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();
    }
    // READ RSS
    private  class  ReadRss extends  AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            StringBuilder content = new StringBuilder();
            try {
                url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            //Toast.makeText(MainActivity.this, "" + nodeList.getLength(), Toast.LENGTH_SHORT).show();
            String titleNews = "";
            for (int i =0; i < nodeList.getLength(); i++) {
                // Get all title ~ 25 title news
                Element element = (Element) nodeList.item(i);
                titleNews += parser.getValue(element, "title") + "\n";
            }
            //Toast.makeText(MainActivity.this, titleNews, Toast.LENGTH_LONG).show();

        }
    }





    // READ JSON
    private class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            // data
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject object = new JSONObject(s);

                JSONArray arr = object.getJSONArray("weather");

                for (int i=0; i< arr.length(); i++) {
                    JSONObject objectWeather = arr.getJSONObject(i);
                    String city = objectWeather.getString("main");
                    // Toast.makeText(MainActivity.this, city, Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(MainActivity.this, " " + arr.length(), Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }

           //Toast.makeText(MainActivity.this,s, Toast.LENGTH_SHORT).show();
        }
    }
    }
