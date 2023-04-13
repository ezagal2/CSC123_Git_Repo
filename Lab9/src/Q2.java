import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;

public class Q2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.facebook.com", 80);
        int headers = 0;
        int words = 0;
        int chars = 0;

        OutputStream out = socket.getOutputStream();
        out.write("HEAD / HTTP/1.1\r\n".getBytes());
        out.write("Host: www.facebook.com\r\n".getBytes());
        out.write("\r\n".getBytes());

        InputStream in = socket.getInputStream();
        InputStreamReader inreader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inreader);

        String line;
        reader.readLine();
        while (!(line = reader.readLine()).isBlank()) {
            headers++;
            chars += line.length();
            String[] lineWords = line.split("\\s+");
            words += lineWords.length;
            System.out.println(line);
        }
        System.out.println("Number of headers: " + headers);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + chars);
        socket.close();
        reader.close();
        inreader.close();
        in.close();
        out.close();
    }
}