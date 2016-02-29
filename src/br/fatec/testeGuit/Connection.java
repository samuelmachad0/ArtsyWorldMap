package br.fatec.testeGuit;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.InputStreamReader;
import java.util.LinkedList;

import org.json.JSONObject;

public class Connection {
	
	URL url;
	
	public void setURL(String u) throws MalformedURLException{
		this.url = new URL(u);
		
	}

    public String getData() throws JSONException {
    	
    	String token = "JvTPWe4WsQO-xqX6Bts49j-GF5WrATKu3GQDADQ1mVGIJR7KGb-Ys3N0TuhrEHkTmaKdTQ3rPdKLfhHoG04rVxG6ISOeSdDMfch-_r1nDXw_UYJRE78z3pakMXUnCyxq8-W7I-KgKORrwTunGWXcrFFdPgLTgxnDBZTFPOCI28aPTRmgcoSiZj_aFGIclcC6JGKkgUIofssNlyw9tz9NXC_p_deBDClz40WWp3mCazU=";
        final StringBuilder result = new StringBuilder();


        HttpURLConnection urlConnection = null;
        try {
            //setURL("https://api.artsy.net/api/artists?cursor=47-faith%3A56b3553b1a1e8666fd00002b");
           
            urlConnection = (HttpURLConnection) url
                    .openConnection();
            urlConnection.setRequestProperty("Accept", "application/vnd.artsy-v2+json");
            urlConnection.setRequestProperty("X-Xapp-Token", token);
            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);



            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return result.toString();
    }

}