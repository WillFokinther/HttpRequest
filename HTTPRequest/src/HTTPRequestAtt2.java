import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/package-summary.html
//Method uses java.net.http.HttpClient, much more tidy than first attempt.

//this works for achievements link http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=440&key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794,
//but not for inventory or online sample links.
public class HTTPRequestAtt2 {
    public static void main(String[] args) {
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=440&key=501469064D126AD3431FF81012B1D9E5&steamid=76561198346396794")).build(); //builds http request for client to send
         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())//client sends request asynchronously, recieves data back as string.
         .thenApply(HttpResponse::body)//asynch allows requests to run in background while main deals with the rest of the program normally
         .thenAccept(System.out::println)
         .join();   
    }
}
