/**
 * created by Heritier Muhire
 * Student Id: S1719021
 */
package com.example.myweatherfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class WeatherDataParserHandler  {

    private ProgressDialog pd;
    private Another2Menu activity;
    private Context context;
    private InputStream inputStream;
    private Exception exception = null;
    private String text;
    private XmlPullParserFactory factory;
    private XmlPullParser xpParser;
    private String urlString;
    public volatile boolean complete = true;


    private CityWeatherElements cityWeatherElementsObj;
    private List<CityWeatherElements> cityWeatherElementsList = new ArrayList<>();

    public WeatherDataParserHandler(String url){
        this.urlString = url;
    }


    public List<CityWeatherElements> getCityWeatherElementsList() {
        return cityWeatherElementsList;
    }

//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        pd = new ProgressDialog(context);
//        pd.setTitle("Parse Weather data from URL");
//        pd.setMessage("Loading...");
//        pd.show();
//    }

    public void connector(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //PROPERTIES of CONNECTOR
                    URL url = new URL(urlString);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(10000 /* milliseconds */);
                    connection.setConnectTimeout(15000 /* milliseconds */);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();
                    inputStream = connection.getInputStream();

                    factory = XmlPullParserFactory.newInstance();
                    factory.setNamespaceAware(false);


                    xpParser = factory.newPullParser();
                    xpParser.setInput(inputStream, "UTF-8");

                    parseXML(xpParser);
                    inputStream.close();


                }catch (IOException e){
                    exception = e;
                } catch (XmlPullParserException xex){
                    exception = xex;
                }
            }
        });
        thread.start();




    }

    protected void parseXML(XmlPullParser parser){

        try {
            int event = parser.getEventType();
            boolean insideItem = false;
            String loc ="";

            while (event != XmlPullParser.END_DOCUMENT){
                String tagName = xpParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")){
                            insideItem = true;
                            cityWeatherElementsObj = new CityWeatherElements();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = xpParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        switch (tagName){
                            case "title":
                                if (loc.isEmpty()){
                                    loc = text;
                                    Log.d(TAG, "Check Location changed: "+ loc);
                                }
                                if (insideItem) {
                                    String title = text;
                                    String [] titleText = title.split(",");
                                    cityWeatherElementsObj.setForecast(titleText[0]);
                                }

                                break;
                            case "description":
                                break;
                            case "pubDate":
                                break;
                            case "item":
                                cityWeatherElementsObj.setCityName(loc);
                                if (cityWeatherElementsList != null){
                                    cityWeatherElementsList.add(cityWeatherElementsObj);
                                }
                                break;
                             default:
                                 break;


                        }
//                        if (tagName.equalsIgnoreCase("item")){
//
//                            cityWeatherElementsList.add(cityWeatherElementsObj);
//                        }
//                        else if (tagName.equalsIgnoreCase("title")){
////                            if (insideItem) {
//                                // Splitting a string based on commas
//                                String title = text;
//                                String [] titleText = title.split(",");
////                                cityWeatherElementsObj.setCityName(titleText[0]);
//                                cityWeatherElementsObj.setForecast(titleText[0]);
//
//
//                                Log.d(TAG, "parseXML: "+ text);
////                            }
//                        }
//                        else if (tagName.equalsIgnoreCase("description")){
////                            if (insideItem) {
//
//                                //cityWeatherElementsObj.setCityName(text);
//                                Log.d(TAG, "parseXML: "+ text);
////                            }
//                        }

                        /*else if (event == XmlPullParser.END_TAG && tagName.equalsIgnoreCase("item")){
                            insideItem = false;
                        }*/


//                        break;
//
//                    default:
//                        break;

                }


                // Increment and go to the next
                event = parser.next();
            }

            complete = false;
        }catch (XmlPullParserException xex){
            exception = xex;
        }
        catch (IOException e){
            exception = e;
        }
    }




//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        pd.dismiss();
//    }
}
