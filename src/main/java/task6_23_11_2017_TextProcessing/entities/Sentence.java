package task6_23_11_2017_TextProcessing.entities;

import task6_23_11_2017_TextProcessing.app.VowelLettersShare;

public class Sentence extends VowelLettersShare {
    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence(int vowelLettersShare, String sentence) {
        super(vowelLettersShare);
        this.sentence = sentence;
    }
    public Sentence(String sentence){
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                "} " ;
    }
}
