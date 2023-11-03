import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(32768); // connection to port
        Socket socket = serverSocket.accept(); // connect to client

        while (true) {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream); // get input from the client
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine(); // read a line from the client

            if (line.equals("Quit")) {
                System.out.println("Disconnected");
                reader.close();
                break;
            } else {
                System.out.println(line);
            }

        }

    }

}
