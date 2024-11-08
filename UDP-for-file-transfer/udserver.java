import java.io.*;
import java.net.*;

public class udpserver {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        FileOutputStream fos = null;
        try {
            // Create a UDP socket at port 5000
            socket = new DatagramSocket(8080);
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Server is ready to receive files...");

            // Prepare to receive the file metadata (filename)
            DatagramPacket fileNamePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(fileNamePacket);
            String fileName = new String(fileNamePacket.getData(), 0, fileNamePacket.getLength());
            System.out.println("Receiving file: " + fileName);

            // Prepare output stream to write the received file
            fos = new FileOutputStream("udp/received_" + fileName);

            // Receive file data in chunks
            while (true) {
                DatagramPacket fileChunkPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(fileChunkPacket);

                // If the server receives "END", stop receiving further
                String receivedText = new String(fileChunkPacket.getData(), 0, fileChunkPacket.getLength());
                if (receivedText.equals("END")) {
                    System.out.println("File transfer complete.");
                    break;
                }

                // Write received data to file
                fos.write(fileChunkPacket.getData(), 0, fileChunkPacket.getLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


// Server is ready to receive files...
// Receiving file: udp_clientfile.txt
// File transfer complete.

