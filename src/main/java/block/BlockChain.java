package block;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import util.StringUtil;

public class BlockChain {

    private List<Block> blockList;
    private String currentBlockChainHash;

    private BlockChain() {

        this.blockList = new LinkedList<>();
        setCurrentBlockChainHash(calculateSumHash());

    }

    public static BlockChain createInstanceBlockChain() {

        return new BlockChain();

    }

    public void generateBlock() {

        if (checkBlockChainTrue()) {

            if (this.blockList.isEmpty()) {

                this.blockList.add(Block.getBlockInstance("0", new Date().getTime()));

            } else {

                Block nextBlock = Block.getBlockInstance(getLastBlockHash(), new Date().getTime());
                this.blockList.add(nextBlock);

            }

            setCurrentBlockChainHash(calculateSumHash());
        }

    }

    private boolean checkBlockChainTrue() {

        return calculateSumHash().equals(currentBlockChainHash);

    }

    private String getLastBlockHash() {

        Block lastBlock = this.blockList.get(this.blockList.size() - 1);
        return lastBlock.getHash();

    }

    public List<Block> getBlockChain() {

        return blockList;

    }

    private String calculateSumHash() {

        StringBuilder sumHashCode = new StringBuilder();
        for (Block block: this.blockList) {
            sumHashCode.append(block.getHash());
        }

        return StringUtil.applySha256(sumHashCode.toString());

    }

    private void setCurrentBlockChainHash(String currentBlockChainHash) {

        this.currentBlockChainHash = currentBlockChainHash;

    }

}
