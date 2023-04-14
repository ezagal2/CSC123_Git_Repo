import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Q2 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1000)) {

            while (true) {

                Socket socket = serverSocket.accept();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    out.println("What is your name?");
                    String name = in.readLine();
                    out.printf("It is very nice to meet you %s!%n" ,name);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
