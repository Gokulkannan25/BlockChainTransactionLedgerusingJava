package dsaProject;

import java.util.LinkedList;

public class BlockMiner {
	    public static void mineBlock(BlockChain blockchain, String sender, String receiver, double amount) {
	        Transaction transaction = new Transaction(sender, receiver, amount);
	        Block newBlock = new Block(blockchain.getChainSize(), new LinkedList<>(), blockchain.getLastBlockHash());
	        newBlock.getTransactions().add(transaction);
	        blockchain.addBlock(newBlock);
	    }
	}

