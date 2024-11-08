import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpserver {
    public static void main(String[] args) {
        try {
            ServerSocket serverScoket = new ServerSocket(8080);
            System.out.println("Listening from port 8080...");

            Socket socket = serverScoket.accept();
            System.out.println("Client Connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from Server!");
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            File file = new File("Assign6/server.txt");
            FileInputStream fileIn = new FileInputStream(file);
            OutputStream outStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileIn.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            fileIn.close();
            socket.close();
            serverScoket.close();
            System.out.println("File Sent Sucessfully");


        } catch (IOException e) {
            System.out.println(e);
        }
    }
}


// Listening from port 8080...
// Client Connected
// Client says: Hello from Client!
// File Sent Sucessfully
