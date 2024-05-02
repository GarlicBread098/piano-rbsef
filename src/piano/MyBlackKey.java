package src.piano;

public class MyBlackKey {
    public int leftBoundX;
    public int rightBoundX;
    static int width = (MyWhiteKey.width * 2)/3; // width of each black key
	public static int height = (MyWhiteKey.height * 2)/3; // height of each black key
	
	int octave;
	
	String note;

    public MyBlackKey(){

    }

}
