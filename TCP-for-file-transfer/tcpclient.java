import java.io.*;
import java.net.Socket;

public class tcpclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to the server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String serverMessage = in.readLine();
        System.out.println("Server says: " + serverMessage);
        out.println("Hello from Client!");

        InputStream inStream = socket.getInputStream();
        FileOutputStream fileOut = new FileOutputStream("Assign6/FileClient.txt");

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            fileOut.write(buffer, 0, bytesRead);
        }

        fileOut.close();
        socket.close();
        System.out.println("File received successfully!");
    }
}


// Connected to the server!
// Server says: Hello from Server!
// File received successfully!
