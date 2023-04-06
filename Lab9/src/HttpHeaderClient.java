import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;

public class HttpHeaderClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.google.com", 80);

        //Sending request
        OutputStream out=socket.getOutputStream();
        out.write("GET / HTTP/1.1\r\n".getBytes());
        out.write("Host: www.google.com\r\n".getBytes());
        out.write("\r\n".getBytes());

        //Reading  response

        InputStream in=socket.getInputStream();
        InputStreamReader inreader=new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inreader);

        //printing response

        String line;
        while ((line = reader.readLine()) != null) {

            System.out.println(line);
        }
        socket.close();
    }
}