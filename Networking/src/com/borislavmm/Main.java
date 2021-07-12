package com.borislavmm;

import com.sun.jndi.toolkit.url.Uri;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {

            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
           // connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading the web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

//            connection.setDoOutput(true);
//            urlConnection.connect();

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = inputReader.readLine()) != null) {

                System.out.println(line);
            }

            inputReader.close();


//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//
//                System.out.println("-----key= " + key);
//                for (String string : value) {
//                    System.out.println("value = " + value);
//                }
//            }
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//
//            inputStream.close();



        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
