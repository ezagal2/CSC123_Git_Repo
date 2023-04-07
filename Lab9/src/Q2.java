import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Q2 {
    public static void main(String[] args) throws Exception {
        String urlString = "https://www.takearidewith.me/";
        HttpURLConnection connection = null;
        int responseCode;
        String locationHeader;

        do {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
            locationHeader = connection.getHeaderField("Location");

            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                    responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                urlString = locationHeader;
            }
        } while (responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                responseCode == HttpURLConnection.HTTP_MOVED_TEMP);

        connection.disconnect();

        connection = (HttpURLConnection) new URL(urlString).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            content.append("\n");
        }
        in.close();

        System.out.println("HTTP Headers:");
        connection.getHeaderFields().forEach((key, values) -> {
            System.out.println(key + ": " + values);
        });
        System.out.println("\nResponse Body:");
        System.out.println(content.toString());
        connection.disconnect();

    }
}
