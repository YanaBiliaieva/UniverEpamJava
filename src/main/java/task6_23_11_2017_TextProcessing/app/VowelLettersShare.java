package task6_23_11_2017_TextProcessing.app;

public abstract class VowelLettersShare {
    int vowelLettersShare;

    public int getVowelLettersShare() {
        return vowelLettersShare;
    }

    public void setVowelLettersShare(int vowelLettersShare) {
        if(vowelLettersShare>0){
            throw new IllegalArgumentException("Vowel Letters Share must not be less then 0");
        }else this.vowelLettersShare = vowelLettersShare;
    }

    public VowelLettersShare(int vowelLettersShare) {
        this.vowelLettersShare = vowelLettersShare;
    }

    @Override
    public String toString() {
        return vowelLettersShare+"%. ";
    }

    public VowelLettersShare(){

    }
}
