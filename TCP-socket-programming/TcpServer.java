import java.io.*;
import java.net.*;
public class TcpServer{
public static void main(String[] args){
        try{
            //step 1: create a serversocket object and bind it to a port
            ServerSocket serverSocket=new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");
            //step 2: accept incoming client connections
            Socket clientSocket=serverSocket.accept();

            System.out.println("Client connected.."+clientSocket.getInetAddress());
            //step 3: create input and output streams for communication
            BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
            //step 4: read data from client and send response
            String clientMessage=in.readLine();
            System.out.println("Client saya: "+clientMessage);
            out.println("Server received: "+clientMessage);
            //step 5: close streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}