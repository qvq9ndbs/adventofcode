package code;

import helpers.day02.PasswordDTO;
import shared.reader.*;

import java.util.*;

public class Day02 {
    public static final Reader reader = new Reader();
    public static final String path = "src/main/resources/input/day02.txt";

    public static void main(String[] args) {
        Day02 logic = new Day02();
        System.out.println("\n------ DAY TWO ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private PasswordDTO setUp(){
        List<String> list = reader.readStrings(path);
        List<Character> chars = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        List<Integer> lowerRanges = new ArrayList<>();
        List<Integer> upperRanges = new ArrayList<>();
        for(int i = 0; i < list.size(); i += 3) {
            String[] temp = list.get(i).split("-"); // range
            lowerRanges.add(Integer.valueOf(temp[0]));
            upperRanges.add(Integer.valueOf(temp[1]));
            chars.add(list.get(i+1).charAt(0)); // required character
            passwords.add(list.get(i+2)); // password
        }

        return new PasswordDTO(lowerRanges, upperRanges, chars, passwords);
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        PasswordDTO dto = setUp();

        int result = 0;

        for(int i = 0; i < dto.getPasswords().size(); i++) {

            String password = dto.getPasswords().get(i);
            char test = dto.getChars().get(i);

            long count = password.chars().filter(ch -> ch == test).count();

            if (count >= dto.getLowerRanges().get(i) && count <= dto.getUpperRanges().get(i)) result++;
        }
        System.out.println("Valid passwords: " + result);
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        PasswordDTO dto = setUp();

        int result = 0;

        for(int i = 0; i < dto.getPasswords().size(); i++){
            String password = dto.getPasswords().get(i);
            char test = dto.getChars().get(i);

            int charOne = (password.charAt(dto.getLowerRanges().get(i) - 1) == test) ? 1 : 0;
            int charTwo = (password.charAt(dto.getUpperRanges().get(i) - 1) == test) ? 1 : 0;

            if(charOne + charTwo == 1) result++;

        }
        System.out.println("Valid passwords: " + result);
    }
}