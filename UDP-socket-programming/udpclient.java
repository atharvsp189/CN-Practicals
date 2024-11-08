import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class udpclient{
    public static void main(String[] args){
        try{
            //get server's ip address
            InetAddress serverAddress=InetAddress.getByName("localhost");
            //create a datagram socket for the client
            DatagramSocket clientSocket=new DatagramSocket();
            //message to send
            String message ="Hello, UDP Server!";
            byte[] sendData=message.getBytes();
            //create a datagrampacket to send to the server
            DatagramPacket sendPacket=new DatagramPacket(sendData,

            sendData.length, serverAddress, 12345);

            //send the packet to the server
            clientSocket.send(sendPacket);
            System.out.println("Message sent to server: "+message);
            //close the client socket
            clientSocket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}