/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fsst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    public void emptySymbolConstructor() {
        Symbol symbol = new Symbol();
        assertTrue(symbol.icl == 0, "symbol icl should be 0");
        assertTrue(symbol.value == 0, "symbol value should be 0");
    }

    @Test
    public void twoIntSymbolConstructor() {
        Symbol symbol = new Symbol((byte) 50, 50);
        assertTrue(symbol.icl == 271712312, "symbol icl should be 271712312");
        assertTrue(symbol.value == 50, "symbol value should be 50");
    }

    @Test
    public void setCodeLengthTest() {
        Symbol symbol = new Symbol();
        symbol.setCodeLength(50, 50);
        assertTrue(symbol.icl == -336, "Wrong icl value");
    }

    @Test
    public void simpleCompress() {
        String inputString = "Hello World!";
        byte[] strIn = inputString.getBytes();
        char[] strIn2 = inputString.toCharArray();
        long[] lenIn = new long[strIn.length];
        int[] lenIn2 = new int[strIn.length];
        long size = strIn.length;
        // This is just an arbitrary sized array to just fit something in there
        byte[] output = new byte[255];
        long[] lenOut = new long[255];
        byte[][] strOut = new byte[255][255];
        FSSTEncoder e = new FSSTEncoder(1, lenIn2, strIn2, 0);
        e.fsst_compress(1, lenIn, strOut, size, output, lenOut, strOut);
    }
}
