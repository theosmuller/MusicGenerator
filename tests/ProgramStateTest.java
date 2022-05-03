import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramStateTest {
    @Test
    public void setAndGetMusicTextTest() {
        String musicText = "musica que sera testada";
        ProgramState ps = new ProgramState();
        ps.setMusicText(musicText);
        assertEquals(musicText, ps.getMusicText());
    }
}