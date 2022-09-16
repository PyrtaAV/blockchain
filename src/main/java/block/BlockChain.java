package block;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

import util.SerializationUtilImpl;
import util.StringUtil;

public class BlockChain implements Serializable {

    private Deque<Block> blockList;
    private String currentBlockChainHash;
    private static final long serialVersionUID = 2134;

     transient private SerializationUtilImpl serializationUtil = new SerializationUtilImpl();

    private BlockChain() {

        this.blockList = new ArrayDeque<>();
        setCurrentBlockChainHash(calculateSumHash());

    }

    public static BlockChain createInstanceBlockChain() {

        return new BlockChain();

    }

    public void generateBlock(int countZero, String fileName) {

        if (checkBlockChainTrue()) {

            if (this.blockList.isEmpty()) {

                this.blockList.add(Block.getBlockInstance("0", new Date().getTime(),countZero, 0));

            } else {
                Block lastBlock = blockList.getLast();
                Block nextBlock = Block.getBlockInstance(getLastBlockHash(), new Date().getTime(), countZero, lastBlock.getId());
                this.blockList.add(nextBlock);

            }

            setCurrentBlockChainHash(calculateSumHash());

            serializationUtil.serialize(this, fileName);
        }

    }

    private boolean checkBlockChainTrue() {

        return calculateSumHash().equals(currentBlockChainHash);

    }

    private String getLastBlockHash() {

        Block lastBlock = this.blockList.getLast();
        return lastBlock.getHash();

    }

    public Deque<Block> getBlockChain() {

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

    private void readObject(ObjectInputStream objectInput) throws Exception {
        objectInput.defaultReadObject();
        this.serializationUtil = new SerializationUtilImpl();
    }

}
