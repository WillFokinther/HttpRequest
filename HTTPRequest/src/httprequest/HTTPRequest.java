package httprequest;

//https://www.youtube.com/watch?v=qzRKa8I36Ww&ab_channel=CodingMaster-ProgrammingTutorials

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class HTTPRequest {
    
    private static HttpURLConnection connection; //define connection
    
    public static void main(String[] args) {
        BufferedReader reader;
        String line; 
        StringBuffer responseContent = new StringBuffer();
        String input;
        input = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794&format=json";
        
        try {
            URL url = new URL(input);
                connection = (HttpURLConnection) url.openConnection();
                
                //request setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000); //in ms
                connection.setReadTimeout(5000);
                
                //check if connection is working
                int status = connection.getResponseCode();
                    System.out.println(status);
                    
                    if (status != 200) { //200 OK anything else error
                        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                        while((line = reader.readLine()) != null) {
                            responseContent.append(line);
                        }
                        reader.close();
                    } else {
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while((line = reader.readLine()) != null) {
                            responseContent.append(line);
                        }
                        reader.close();
                    }
                    System.out.println(responseContent.toString());    
                
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            connection.disconnect();
            }
 
    }
    
    public static String parse(String responseBody) {
       JSONArray games = new JSONArray(responseBody); 
       for (int i = 0; games.length(); i++) {
           JSONObject thing = games.getJSONObject(i);
           int appID = games.getInt(key "");
       }
    }
           
}
