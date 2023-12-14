package dsaProject;
import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
	        BlockChain blockchain = new BlockChain();
	        Scanner scanner = new Scanner(System.in);
            while (true) {
	            System.out.println("\n1. Add Transaction");
	            System.out.println("2. Mine Block");
	            System.out.println("3. Display Blockchain");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
	                case 1:
	                    System.out.print("Enter sender: ");
	                    String sender = scanner.next();
	                    System.out.print("Enter receiver: ");
	                    String receiver = scanner.next();
	                    System.out.print("Enter amount: ");
	                    double amount = scanner.nextDouble();
	                    BlockMiner.mineBlock(blockchain, sender, receiver, amount);
	                    break;
	                case 2:
	                    System.out.println("Mining new block...");
	                    break;
	                case 3:
	                    blockchain.displayBlockchainDetails();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
}
