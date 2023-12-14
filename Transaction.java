package dsaProject;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Transaction {
	// Block attributes
	private String sender;
    private String receiver;
    private double amount;
    private long timestamp;
    // Constructor for creating a new block
    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = new Date().getTime();
    }
    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
    public String getSender(){
        return sender;
    }
    public void setSender(String sender){
        this.sender=sender;
    }
    public String getReceiver(){
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getTransactionData() {
        return sender +" "+ receiver+" "+ amount +" "+formatTimestamp(timestamp);
    }
}
