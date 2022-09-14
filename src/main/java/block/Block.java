package block;

import util.StringUtil;

import java.time.LocalTime;
import java.util.Random;

public class Block {

    private final int id;
    private static int nextId = 1;
    long timeStamp;
    private final String hash;
    private final String previousBlockHash;
    private int magicNumber;
    private int secondsGeneratingBlock;

    {
        id = nextId;
        nextId++;
    }

    private Block(String previousBlockHash, long timeStamp, int countZero) {
        this.previousBlockHash = previousBlockHash;
        this.timeStamp = timeStamp;
        this.hash = this.generateHash(countZero);
    }

    public static Block getBlockInstance(String previousBlockHash, long timeStamp, int countZero) {

        return new Block(previousBlockHash, timeStamp, countZero);
    }
    public void setSecondsGeneratingBlock(int secondsGeneratingBlock) {
        this.secondsGeneratingBlock = secondsGeneratingBlock;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public String generateHash(int countZero) {
        String tempHash;
        LocalTime timeStart = LocalTime.now();
        do {
            this.magicNumber = Math.abs(new Random().nextInt());
            tempHash = StringUtil.applySha256(this.toString());

        } while (!tempHash.startsWith("0".repeat(countZero)));
        LocalTime timeEnd = LocalTime.now();
        this.setSecondsGeneratingBlock(Math.abs(timeEnd.getSecond() - timeStart.getSecond()));
        return tempHash;
    }

    @Override
    public String toString() {
        return "block.Block:" + "\n"
                + "Id: " + this.id + "\n"
                + "Timestamp: " + this.timeStamp + "\n"
                + "Magic number: " + this.magicNumber + "\n"
                + "Hash of the previous block:\n" + this.previousBlockHash + "\n"
                + "Hash of the block:\n" + this.hash + "\n"
                + "Block was generating for " + this.secondsGeneratingBlock + " seconds" + "\n";
    }

}
