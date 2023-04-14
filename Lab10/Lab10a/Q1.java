import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class Q1 {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("www.usman.cloud", 80);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream out = socket.getOutputStream()) {

            out.write("GET /news HTTP/1.1\r\n".getBytes());
            out.write("Host: www.usman.cloud\r\n".getBytes());
            out.write("\r\n".getBytes());

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String[] arrayOfLines = sb.toString().split("\n");
            Map<String, String> headerMap = new TreeMap<>();
            for (int i = 1; i < arrayOfLines.length; i++) {
                int colonIndex = arrayOfLines[i].indexOf(':');
                if (colonIndex != -1) {
                    String key = arrayOfLines[i].substring(0, colonIndex).trim();
                    String value = arrayOfLines[i].substring(colonIndex + 1).trim();
                    headerMap.put(key, value);
                }
            }
            if (sb.toString().contains("301")) {
                String newLocation = headerMap.get("Location").substring(headerMap.get("Location").indexOf("w"));
                try (Socket newSocket = new Socket(newLocation, 80);
                     BufferedReader newReader = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                     OutputStream newOut = newSocket.getOutputStream()) {

                    newOut.write("GET / HTTP/1.1\r\n".getBytes());
                    newOut.write(("Host: " + newLocation + "\r\n").getBytes());
                    newOut.write("\r\n".getBytes());

                    sb = new StringBuilder();
                    while ((line = newReader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    System.out.println(sb);
                }
            }
        }
    }
}
