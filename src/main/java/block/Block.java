package block;

import util.StringUtil;

public class Block {

    private final int id;
    private static int nextId = 1;
    long timeStamp;
    private final String hash;
    private final String previousBlockHash;

    {
        id = nextId;
        nextId++;
        this.hash = StringUtil.applySha256(this.toString());
    }

    private Block(String previousBlockHash, long timeStamp) {
        this.previousBlockHash = previousBlockHash;
        this.timeStamp = timeStamp;
    }

    public static Block getBlockInstance(String previousBlockHash, long timeStamp) {

        return new Block(previousBlockHash, timeStamp);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    @Override
    public String toString() {
        return "block.Block:" + "\n"
                + "Id: " + this.id + "\n"
                + "Timestamp: " + this.timeStamp + "\n"
                + "Hash of the previous block:\n" + this.previousBlockHash + "\n"
                + "Hash of the block:\n" + this.hash + "\n";
    }

}
