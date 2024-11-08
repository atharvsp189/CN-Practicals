import java.io.*;
import java.net.*;

public class udpclient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        FileInputStream fis = null;
        try {
            // File to be transferred (Change file path based on file type: text, audio, video, etc.)
            File file = new File("Assign7/udp_clientfile.txt"); // Replace this with your file
            fis = new FileInputStream(file);
            socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost"); // Change this to server's IP if on different machine
            int port = 8080;

            // Send file name first
            byte[] fileNameBytes = file.getName().getBytes();
            DatagramPacket fileNamePacket = new DatagramPacket(fileNameBytes, fileNameBytes.length, serverAddress, port);
            socket.send(fileNamePacket);

            // Sending file data in chunks
            byte[] sendBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(sendBuffer)) != -1) {
                DatagramPacket fileChunkPacket = new DatagramPacket(sendBuffer, bytesRead, serverAddress, port);
                socket.send(fileChunkPacket);
            }

            // Send "END" to signal end of file transfer
            byte[] endMessage = "END".getBytes();
            DatagramPacket endPacket = new DatagramPacket(endMessage, endMessage.length, serverAddress, port);
            socket.send(endPacket);

            System.out.println("File transfer complete.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// File transfer complete.
