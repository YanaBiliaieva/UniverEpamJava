package task6_23_11_2017_TextProcessing.entities;

import task6_23_11_2017_TextProcessing.app.VowelLettersShare;

public class Symbol extends VowelLettersShare{
    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol(int vowelLettersShare, char symbol) {
        super(vowelLettersShare);
        this.symbol = symbol;
    }
}
