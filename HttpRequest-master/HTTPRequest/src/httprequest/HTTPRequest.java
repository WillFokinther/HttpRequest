package httprequest;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://steamcommunity.com/inventory/76561198346396794/730/2?l=english&count=5000");

        // Create a HttpURLConnection object
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        con.setRequestMethod("GET");

        // Set the request headers
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        // Set the request body
        String requestBody = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(requestBody.getBytes());
        os.flush();
        os.close();

        // Get the response code
        int responseCode = con.getResponseCode();

        // Read the response and write it to a file in documents folder. this path works for home but will need to be changed if worked on at school.
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = con.getInputStream();
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\willf\\Documents\\NetBeansProjects\\JSONdata.json");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
        } else {
            System.out.println("GET request failed with response code " + responseCode);
        }
    }
}