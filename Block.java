package dsaProject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Block {
	private int index;
    private LinkedList<Transaction> transactions;
    private String previousHash;
    private String hash;
    private long timestamp;
    private int nonce;

    public Block(int index, LinkedList<Transaction> transactions, String previousHash) {
        this.index = index;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.timestamp = new java.util.Date().getTime();
        this.nonce = 0;
        this.hash = mineBlock();
    }

    private String calculateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
 // Method to calculate the hash using SHA-256 and mine the block
    private String mineBlock() {
        String target = new String(new char[4]).replace('\0', '0'); // Adjust difficulty as needed
        String data = index + previousHash + transactions.toString() + timestamp + nonce;

        while (!calculateHash(data).substring(0, 4).equals(target)) {
            nonce++;
            data = index + previousHash + transactions.toString() + timestamp + nonce;
        }

        return calculateHash(data);
    }

    public String getHash() {
        return hash;
    }

    public int getIndex() {
        return index;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getNonce() {
        return nonce;
    }
    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
    public void displayBlockDetails() {
        System.out.println("----------------------------");
        System.out.println("Block Index: " + index);
        System.out.println("Previous Hash: " + previousHash);
        System.out.println("Block Hash: " + hash);
        System.out.println("Timestamp: " + formatTimestamp(timestamp));
        System.out.println("Nonce: " + nonce);
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("  " + transaction.getTransactionData());
        }
        System.out.println("----------------------------");
    }
}
