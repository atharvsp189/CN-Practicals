import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class udpserver{
    public static void main(String[] args){
        try{
            //create a DatagramSocket and bind it to a specific port
            DatagramSocket serverSocket=new DatagramSocket(12345);
            System.out.println("UDP server is running...");
            byte[] receiveData=new byte[1024];
            while(true){
                //create a datagrampacket to receive data from clients
                DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);

                //receive data from client
                serverSocket.receive(receivePacket);
                //convert the received data to a string
                String message = new String(receivePacket.getData(),0,receivePacket.getLength());

                //display the received message and client;s address
                System.out.println("Received from Client: "+message);
                System.out.println("Client IP: "+receivePacket.getAddress()+", Port: "+receivePacket.getPort());

                //clear the received buffer
                receiveData=new byte[1024];
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
