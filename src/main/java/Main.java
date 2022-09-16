import block.Block;
import block.BlockChain;
import util.SerializationUtil;
import util.SerializationUtilImpl;
import util.StringUtil;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        var serializationUtil = new SerializationUtilImpl();

        String fileName = "D:\\Blockchain.txt";
        File file = new File("D:\\Blockchain.txt");
        BlockChain blockChain = null;

        System.out.print("Enter how many zeros the hash must start with: ");
        int countZero = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (file.exists()) {
            blockChain = serializationUtil.deserialize(fileName);
        } else {
            blockChain = BlockChain.createInstanceBlockChain();
            blockChain.generateBlock(countZero, fileName);
            blockChain.generateBlock(countZero, fileName);
            blockChain.generateBlock(countZero, fileName);
        }

        blockChain.generateBlock(countZero, fileName);

        for (Block block: blockChain.getBlockChain()) {
            System.out.println(block);
        }



    }
}
