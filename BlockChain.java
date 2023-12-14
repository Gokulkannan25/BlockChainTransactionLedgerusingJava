package dsaProject;
import java.util.LinkedList;
    public class BlockChain {
		 private LinkedList<Block> chain;
            public BlockChain() {
		        this.chain = new LinkedList<>();
		        addBlock(new Block(0, new LinkedList<>(), "0")); // Genesis block
		    }

		    public void addTransaction(String sender, String receiver, double amount) {
		        Transaction transaction = new Transaction(sender, receiver, amount);
		        getCurrentBlock().getTransactions().add(transaction);
		    }

		    public void addBlock(Block block) {
		        chain.addFirst(block);
		    }

		    public void displayBlockchainDetails() {
		        for (Block block : chain) {
		            block.displayBlockDetails();
		        }
		    }

		    private Block getCurrentBlock() {
		        return chain.getFirst();
		    }

		    public String getLastBlockHash() {
		        return chain.isEmpty() ? null : chain.getFirst().getHash();
		    }

		    public int getChainSize() {
		        return chain.size();
		    }
	}

