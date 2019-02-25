package de.auli.chrisnews.service;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.auli.chrisnews.model.Result;


public class HttpRequestServie {
    private static final String TAG = HttpRequestServie.class.getSimpleName();
    private static final String URL = "https://newsapi.org/v2/everything?q=%1$s&from=%2$s&sortBy=%3$s&apiKey=%4$s";
    private static String topic = "bitcoin";
    private static String date = "2019-02-11";
    private static String sort = "publishedAt";
    private static final String KEY = "9431d6330468459089be9c8f612da313";
    //private static final String KEY = String.format("%s", R.string.weather_key); --> Results in different Number!!!
    private static HttpURLConnection connection = null;

    public static Result getNews(String topic, String date, String sort) throws JSONException, IOException {
        HttpRequestServie.topic = topic;
        HttpRequestServie.date = date;
        HttpRequestServie.sort = sort;
        return crateResult();
    }

    public static Result getNews() throws JSONException, IOException {
        return crateResult();
    }

    private static Result crateResult() throws JSONException, IOException {
        String reqUrl = String.format(URL, topic, date, sort, KEY);


        System.out.println(reqUrl);

        final String jsonData = executeServerRequest(reqUrl);
        MapperService us = new MapperService();
        Result result = null;
        try {
            result = us.unmarshall(jsonData);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }
        return result;
    }

    private static String executeServerRequest(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpRequestServie.connection = (HttpURLConnection) new URL(url).openConnection();
        HttpRequestServie.connection.setRequestProperty("Content-Type", "application/json");

        if (HttpRequestServie.connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStreamReader inputStreamReader = new InputStreamReader(HttpRequestServie.connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();
        }

        HttpRequestServie.connection.disconnect();
        String jsonResult = sb.toString();
        return jsonResult;
    }


    public static String addImage(Result result) throws IOException {
        /*
        boolean success = false;
        String icon = result.getWeather().get(0).getIcon();
        String url$ = String.format("http://openweathermap.org/img/w/%s.png", icon);
        Log.d(TAG, String.format("Request goes to: %s", url$));
        URL reqUrl = new URL(url$);
        WeatherServerReq.connection = (HttpURLConnection) reqUrl.openConnection();
        if (WeatherServerReq.connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            Bitmap bmp = BitmapFactory.decodeStream(WeatherServerReq.connection.getInputStream());
            if (bmp != null) {
                result.setBmp(bmp);
            }
            success = true;
        } else {
            Log.e(TAG, String.format("Fehler: ", WeatherServerReq.connection.getResponseCode()));
            throw new IOException(String.format("Beim Laden der Bilddatei: %s ist gewaltig was schief gelaufen!", url$));
        }
        WeatherServerReq.connection.disconnect();
         */
        return "Not yet implemented";
    }
}
