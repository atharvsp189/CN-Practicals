import java.util.Scanner;
import java.util.Arrays;
public class subnet{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the I.P. address: ");
        String address = scanner.nextLine();
        String[] octets = address.split("\\.");
        System.out.println(Arrays.toString(octets));
        System.out.print("Enter the CIDR address: ");
        int cidr = scanner.nextInt();
        int first = Integer.parseInt(octets[0]);
        String ipClass = "";
        if (first >= 1 && first <= 126) {
            ipClass = "A";
        } else if (first >= 128 && first <= 191) {
            ipClass = "B";
        } else if (first >= 192 && first <= 223) {
            ipClass = "C";
        } else if (first >= 224 && first <= 239) {
            ipClass = "D";
        } else if (first >= 240 && first <= 255) {
            ipClass = "E";
        } else {
            ipClass = "Unknown Class";
        }
        System.out.println("Class of the IP Address: " + ipClass);
        StringBuilder binaryIP = new StringBuilder();
        for (String octet : octets) {
            int octetValue = Integer.parseInt(octet);

            String binaryOctet = Integer.toBinaryString(octetValue);
            while (binaryOctet.length() < 8) {
            binaryOctet = "0" + binaryOctet;
            }
        binaryIP.append(binaryOctet);
        }
        System.out.println("Binary IP Address: " + binaryIP.toString());
        int numSubnets = (int) Math.pow(2, 32 - cidr);
        System.out.println("Number of IP addresses in each network: " + numSubnets);
        int subnets = 256 / numSubnets;
        System.out.println("Total number of Networks: " + subnets);
        int numHosts = (int) Math.pow(2, 32 - cidr) - 2;
        System.out.println("Number of hosts in each network: " + numHosts);
        scanner.close();
    }
}


// output :
// Enter the I.P. address: 123.0.0.0
// [123, 0, 0, 0]
// Enter the CIDR address: 26
// Class of the IP Address: A
// Binary IP Address: 01111011000000000000000000000000
// Number of IP addresses in each network: 64
// Total number of Networks: 4
// Number of hosts in each network: 62
