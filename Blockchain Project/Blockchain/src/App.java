import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please enter the number of blocks to be created: ");
        int blocksSize = scan.nextInt();
        scan.nextLine();

        System.out.print("Please enter the message for block 1: ");
        String firstMsg = scan.nextLine();

        if(blocksSize < 1) blocksSize = 1;

        Block[] myBlocks = new Block[blocksSize];
        myBlocks[0] = new Block(firstMsg, "0");

        if(blocksSize > 1)
        {
            for(int i = 1; i < blocksSize; i++)
            {
                System.out.print("Please enter the message for block " + (i + 1) + ": ");
                String newMessage = scan.nextLine();
                myBlocks[i] = new Block(newMessage, myBlocks[i - 1].hash);
            }
        }
        
        //myBlocks[1].hash = "invalid";

        if(checkValidity(myBlocks))
            System.out.println("Blockchain is valid.");
        else
            System.out.println("Blockchain is invalid.");

        scan.close();
    }

    public static Boolean checkValidity(Block[] blocks)
    {
        if(blocks.length <= 1) return true;

        for(int i = blocks.length - 1; i > 1; i--)
        {
            if(blocks[i].prevHash != blocks[i - 1].hash) return false;
        }

        return true;
    }
}
