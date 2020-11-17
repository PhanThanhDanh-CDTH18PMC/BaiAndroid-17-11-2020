package com.example.buger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIQuestion {
        static String getQuestions(String Level)
        {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String result = "[{\"id\":\"1\",\"0\":\"1\",\"NoiDung\":\"wellcome to sumoner rift\",\"1\":\"wellcome to sumoner rift\",\"MucDo\":\"1\",\"2\":\"1\",\"DapAn1\":\"A\",\"3\":\"A\",\"DapAn2\":\"B\",\"4\":\"B\",\"DapAn3\":\"C\",\"5\":\"C\",\"DapAn4\":\"D\",\"6\":\"D\",\"DA_Dung\":\"A\",\"7\":\"A\"}]";
            try {
                URL requestURL = new URL("http://localhost:8080/api/api.php?DoKho="+Level);
                urlConnection = (HttpURLConnection) requestURL.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                if (builder.length() == 0) {
                    return null;
                }
                result = builder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
}
