import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Please enter your username");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        String name = reader.readLine();

        Socket socket = new Socket("localhost", 32768); // connection with name to port

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        writer.println(name + " connected");
        writer.flush(); // printWriter writes to the server

        while (true) {
            isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);

            String message = reader.readLine();

            if (message.equals("Quit")) {
                writer.println(message);
                writer.flush();

                reader.close();
                writer.close();
                break;
            } else {
                writer.println(name + ": " + message);
                writer.flush();
            }

        }
    }
}
