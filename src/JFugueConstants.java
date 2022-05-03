public class JFugueConstants {

    public enum musicConstants{
        PAUSE ("R"),
        BPM ("T"),
        INSTRUMENT ("I"),
        VOLUME (":CON(7,"),
        DEFAULT_FILE_NAME ("generated_music");

        musicConstants(final String c) {
        }
    }

    public enum numericConstants{
        WINDOW_WIDTH (779),
        WINDOW_HEIGHT (695),
        MAX_TEXT_SIZE (1000),
        MIN_BPM (40),
        MAX_BPM (220),
        MIN_OCTAVE (0),
        MAX_OCTAVE (9),
        DEFAULT_VOLUME (50),
        MAX_VOLUME (127);

        numericConstants(final int i) {
        }
    }

}
