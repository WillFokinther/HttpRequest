package httprequest;

//https://www.youtube.com/watch?v=qzRKa8I36Ww&ab_channel=CodingMaster-ProgrammingTutorials

//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 http PAT Token for Github

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPRequest {
    
    private static HttpURLConnection connection; //define connection
    
    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        String input;
        input = "http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=440&key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794";
        
        try {
            URL url = new URL(input);
                connection = (HttpURLConnection) url.openConnection();
                
                //request setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000); //in ms
                connection.setReadTimeout(5000);
                
                //check if connection is working
                int status = connection.getResponseCode();
                    //System.out.println(status);
                    
                    if (status != 200) {
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
           
}
