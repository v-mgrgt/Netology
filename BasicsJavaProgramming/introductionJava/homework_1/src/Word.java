public class Word {
    private final char[] word;
    private final char[] hiddenWord;

    public Word(String word) {
        this.word = word.toCharArray();
        this.hiddenWord = "-".repeat(word.length()).toCharArray();
    }

    public boolean isLetter(char letter) {
        boolean flag = false;
        for (int i = 0; i < word.length; i++) {
            if (Character.toUpperCase(letter) == Character.toUpperCase(word[i])) {
                hiddenWord[i] = letter;
                flag = true;
            }
        }

        return flag;
    }

    public boolean isHiddenWord() {
        for (char c : hiddenWord)
            if (c == '-') return true;

        return false;
    }

    public String getHiddenWord() {
        return String.valueOf(hiddenWord);
    }
}
