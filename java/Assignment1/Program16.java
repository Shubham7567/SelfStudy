import static java.lang.Long.toHexString;

class Program16 {
    public static void main(String[] args){
        char letterA = 'A';
        char letterB = 'B';
        char letterC = 'C';
        char letterD = 'D';
        long packed = 0L;
        packed = letterD;
        packed = (packed<<16) | letterC;
        packed = (packed<<16) | letterB;
        packed = (packed<<16) | letterA;
        System.out.println("packed now contains 0x " + toHexString(packed));

        long mask = 0xFFFF;
        char letter = (char)(packed & mask);
        System.out.println("From right to left the letters in packed are:");
        System.out.println(" " + letter + " 0x" + toHexString(letter));
        packed >>=16;
        letter = (char)(packed & mask);
        System.out.println(" " + letter + " 0x" + toHexString(letter));
        packed >>=16;
        letter = (char)(packed & mask);
        System.out.println(" " + letter + " 0x" + toHexString(letter));
        packed >>=16;
        letter = (char)(packed & mask);
        System.out.println(" " + letter + " 0x" + toHexString(letter));
    }
}
