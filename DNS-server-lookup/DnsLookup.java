import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DnsLookup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            if (choice.equals("1")) {
                System.out.print("Enter the IP address: ");
                String ipAddress = scanner.nextLine();
                lookupHostnameByIp(ipAddress);
            } else if (choice.equals("2")) {
                System.out.print("Enter the hostname (URL): ");
                String hostname = scanner.nextLine();
                lookupIpByHostname(hostname);
            } else {
                System.out.println("Invalid choice. Please enter '1' or '2'.");
            }
        }

        scanner.close();
    }

    private static void lookupHostnameByIp(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            String hostname = inetAddress.getHostName();
            System.out.println("The hostname for IP address " + ipAddress + " is: " + hostname);
        } catch (UnknownHostException e) {
            System.out.println("Hostname could not be found for the given IP address.");
        }
    }

    private static void lookupIpByHostname(String hostname) {
        try {
            InetAddress inetAddress = InetAddress.getByName(hostname);
            String ipAddress = inetAddress.getHostAddress();
            System.out.println("The IP address for hostname " + hostname + " is: " + ipAddress);
        } catch (UnknownHostException e) {
            System.out.println("IP address could not be found for the given hostname.");
        }
    }
}


// Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): 
// 1
// Enter the IP address: 8.8.8.8
// The hostname for IP address 8.8.8.8 is: dns.google
// Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): 
// 2
// Enter the hostname (URL): amazon.com
// IP address could not be found for the given hostname.
// Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): 

// Invalid choice. Please enter '1' or '2'.
// Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): 
// 2
// Enter the hostname (URL): localhost
// The IP address for hostname localhost is: 127.0.0.1
// Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): 
// exit
// Exiting the program.