package nio;

public enum Glob {
    TXT_FILES("glob:*.txt"),
    TXT_FILES_AT_ANY_LEVEL("glob:**/*.txt"),
    CHARS("glob:*"),
    CHARS_AND_DIR_BOUNDARY("glob:**"),
    NUM_OF_CHARS("glob:*.???"),
    DIGITS("glob:[0-9]"),
    START_WITH("glob:{file, image}*"),
    TRICKY("glob:**/[s,S]*.{css,java}");     // Java and CSS files at any level which name begin with 's' or 'S'

    private String glob;

    Glob(String glob) {
        this.glob = glob;
    }

    public String getGlob() {
        return glob;
    }
}