//import java.io.File;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import java.io.FileWriter;
//import java.io.IOException;
//
////https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/package-summary.html
////Method uses java.net.http.HttpClient, much more tidy than first attempt.
//
////https://www.youtube.com/watch?v=qzRKa8I36Ww&ab_channel=CodingMaster-ProgrammingTutorials Was my guide.
//
////this works for achievements link http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=440&key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794,
////but not for inventory or online sample links.
//public class HTTPRequestAtt2 {
//
//    public static void main(String[] args) {
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=440&key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794")).build(); //builds http request for client to send
//         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())//client sends request asynchronously, recieves data back as string.
//         .thenApply(HttpResponse::body)//asynch allows requests to run in background while main deals with the rest of the program normally
//         .thenAccept(System.out::println)//:: is lambda expression
//         .join();   
////         try {
////            File myObj = new File("C:\\Users\\willf\\Documents\\NetBeansProjects\\JSONdata.json");
////            if (myObj.createNewFile()) {
////                System.out.println("File created: " + myObj.getName());
////            } 
////            else {
////            System.out.println("File already exists.");
////            }
////            
////            FileWriter myWriter = new FileWriter("C:\\Users\\willf\\Documents\\NetBeansProjects\\JSONdata.json");
////            myWriter.write("Whatever the json dump variable is");
////            myWriter.close();
////            System.out.println("Successfully wrote to the file.");
////            
////            }
////            catch (IOException e) {
////             System.out.println("An error occurred.");
////             e.printStackTrace();
////            }
//         
//    }
//    
//    public static String parse(String responseBody) {
//        JSONObject achievements = new JSONObject(responseBody);
//        for (int i = 0; i < achievements.length(); i++) {
//            JSONObject achievement = achievements.getJSONObject(i);
//            String apiname = achievement.getString("apiname");
//            int unlocktime = achievement.getInt("unlocktime"); 
//            System.out.println(apiname + "" + unlocktime);
//            
//        }
//        return null;
//        try {
//            File myObj = new File("C:\\Users\\willf\\Documents\\NetBeansProjects\\JSONdata.json");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } 
//            else {
//            System.out.println("File already exists.");
//            }
//            
//            FileWriter myWriter = new FileWriter("C:\\Users\\willf\\Documents\\NetBeansProjects\\JSONdata.json");
//            myWriter.write("Whatever the json dump variable is");
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//            
//            }
//            catch (IOException e) {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//            }
//    }
//}
