import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {
    @Test
    public void encodeTest1() {
        String input = "CDEFFFCDCDDDCGFEEECDEFFF";
        String expectedAns = "C4 D4 E4 F4 F4 F4 C4 D4 C4 D4 D4 D4 C4 G4 F4 E4 E4 E4 C4 D4 E4 F4 F4 F4";
        assertEquals(Encoder.encode(input), expectedAns);
    }

    @Test
    public void encodeTest2() {
        String input = "Aaa !iouIOUAkk0?\n;,#";
        String expectedAns = "A4 A4 R4 :CON(7,100) I113 I6 I6 I6 I6 I6 I6 A4 A4 R4 I6  I14 I75 I19 R5";
        assertEquals(Encoder.encode(input), expectedAns);
    }

    @Test
    public void encodeTest3() {
        String input = "";
        String expectedAns = "";
        assertEquals(Encoder.encode(input), expectedAns);
    }

    @Test
    public void encodeTest4() {
        String input = "pdmamassad";
        String expectedAns = "R4 R4 R4 R4 R4 R4 R4 R4 R4 R4";
        assertEquals(Encoder.encode(input), expectedAns);
    }

    @Test
    public void encodeTest5() {
        String input = "pudimamassado";
        String expectedAns = "R4 R4 R4 R4 R4 R4 R4 R4 R4 R4";
        assertEquals(Encoder.encode(input), expectedAns);
    }
}