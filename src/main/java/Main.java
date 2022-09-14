import block.Block;
import block.BlockChain;
import util.StringUtil;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        System.out.print("Enter how many zeros the hash must start with: ");
        int countZero = Integer.parseInt(sc.nextLine());
        System.out.println();

        BlockChain blockChain = BlockChain.createInstanceBlockChain();
        blockChain.generateBlock(countZero);
        blockChain.generateBlock(countZero);
        blockChain.generateBlock(countZero);
        blockChain.generateBlock(countZero);
        blockChain.generateBlock(countZero);

        for (Block block: blockChain.getBlockChain()) {
            System.out.println(block);
        }

    }
}
