import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

class WebRequests {

    public static void main(String[] args) {

        // Only works in Java11
        try {
            // Synchronous request.
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://reqres.in/api/users?page=2")).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.body());
    
            // Asynchronous request.
            HttpClient client2 = HttpClient.newHttpClient();
            HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("https://reqres.in/api/users?page=2")).build();
            client2.sendAsync(request2, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
}