package helpers.day02;

import java.util.List;

public class PasswordDTO {
    private List<Integer> lowerRanges;
    private List<Integer> upperRanges;
    private List<Character> chars;
    private List<String> passwords;

    public PasswordDTO(List<Integer> lowerRanges, List<Integer> upperRanges, List<Character> chars, List<String> passwords){
        setLowerRanges(lowerRanges);
        setUpperRanges(upperRanges);
        setChars(chars);
        setPasswords(passwords);
    }

    public List<Integer> getLowerRanges() {
        return lowerRanges;
    }

    public List<Integer> getUpperRanges() {
        return upperRanges;
    }

    public List<Character> getChars() {
        return chars;
    }

    public List<String> getPasswords() {
        return passwords;
    }

    public void setLowerRanges(List<Integer> lowerRanges) {
        this.lowerRanges = lowerRanges;
    }

    public void setUpperRanges(List<Integer> upperRanges) {
        this.upperRanges = upperRanges;
    }

    public void setChars(List<Character> chars) {
        this.chars = chars;
    }

    public void setPasswords(List<String> passwords) {
        this.passwords = passwords;
    }


}
