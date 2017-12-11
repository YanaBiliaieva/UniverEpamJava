package task6_23_11_2017_TextProcessing.entities;

import task6_23_11_2017_TextProcessing.app.VowelLettersShare;

public class Word extends VowelLettersShare {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word(int vowelLettersShare, String word) {
        super(vowelLettersShare);
        this.word = word;
    }

    @Override
    public String toString() {
        return word +"="+ super.toString();
    }
}
