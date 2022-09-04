import block.Block;
import block.BlockChain;

public class Main {
    public static void main(String[] args) {

        BlockChain blockChain = BlockChain.createInstanceBlockChain();
        blockChain.generateBlock();
        blockChain.generateBlock();
        blockChain.generateBlock();
        blockChain.generateBlock();
        blockChain.generateBlock();

        for (Block block: blockChain.getBlockChain()) {
            System.out.println(block);
        }

    }
}
