    import java.io.*;
    import java.net.*;
    public class TcpClient{
    public static void main(String[] args){
            try{
                //STEP1: CREATE A SOCKET OBJECT AND CONNECT TO THE SERVER

                Socket cs=new Socket("localhost", 12345);
                //Step 2: create input and output streams for communication
                BufferedReader in =new BufferedReader(new

                InputStreamReader(cs.getInputStream()));

                PrintWriter out=new PrintWriter(cs.getOutputStream(), true);
                //step 3: send a message to the server
                out.println("Hello, Server!");
                //step 4: receive and print response from the server
                String serverResponse=in.readLine();
                System.out.println("Server response: "+serverResponse);
                //step 5: close streams and socket
                in.close();
                out.close();
                cs.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }