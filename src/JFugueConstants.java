public class JFugueConstants {
    public static final boolean IS_DEBUG_ON = false;
    public static final int WINDOW_WIDTH = 305;
    public static final int WINDOW_HEIGHT = 340;
    public static final int MIN_OCTAVE = 4;
    public static final int MAX_OCTAVE = 10;
    public static final int DEFAULT_VOLUME = 50;
    public static final int DEFAULT_INSTRUMENT = 0;
    public static final int MAX_INSTRUMENT = 128;
    public static final int MAX_VOLUME = 127;
    public static final String INSTRUMENT = "I";
    public static final String VOLUME = ":CON(7,";
    public static final String DEFAULT_FILE_NAME = "generated_music";

    public static final String HELP_MESSAGE = """
            Instruções - Mapeamento de Caracteres:
            A => Nota Lá    B => Nota Si    C => Nota Dó    D => Nota Ré
            E => Nota Mi    F => Nota Fá    G => Nota Sol
            a,b,c,d,e,f,g => Repete nota (se char anterior era nota) ou Silêncio
            Espaço => Dobra volume ou volume = default (se impossível dobrar)
            ! => Instrumento = Agogo
            i,I,o,O,u,U => Instrumento = Harpsichord
            Outras consoantes => Repete nota (se char anterior era nota) ou Silêncio
            Número => Instrumento MIDI = atual + número
            ? => Aumenta uma oitava ou oitava = default (se impossível aumentar)
            NL => Instrumento = tubular bells
            ; => Instrumento = pan flute
            , => Instrumento = church organ
            ELSE => Repete nota (se char anterior era nota) ou Silêncio""";

    public record BoxInfo(int x, int y, int width, int height) {
        public int getX() { return x; }
        public int getY() { return y; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }
    }

    static BoxInfo inputWidget = new BoxInfo(10, 10, 270, 200);
    static BoxInfo helpButton = new BoxInfo(10, 220, 130, 30);
    static BoxInfo loadButton = new BoxInfo(150, 220, 130, 30);
    static BoxInfo saveButton = new BoxInfo(150, 220, 130, 30);
    static BoxInfo playButton = new BoxInfo(10, 260, 270, 30);
    static BoxInfo stopButton = new BoxInfo(10, 260, 270, 30);

}
