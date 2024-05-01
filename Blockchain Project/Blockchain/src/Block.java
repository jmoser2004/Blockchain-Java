import java.util.Date;

public class Block 
{
    public static int totalBlocks = 0;

    public String hash;
    public String prevHash;
    
    private String message; //the data to be stored
    private long timeStamp; //milliseconds since 1/1/1970

    public Block(String msg, String prvHsh)
    {
        totalBlocks++;

        this.message = msg;
        this.prevHash = prvHsh;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash()
    {
        return Encryption.useSha256(prevHash + Long.toString(timeStamp) + message);
    }
}