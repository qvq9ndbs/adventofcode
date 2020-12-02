package code;

import helpers.Day02DTO;
import shared.Reader;

import java.util.*;

public class Day02 {
    public static final Reader reader = new Reader();
    public static final String path = "src/main/resources/day02.txt";

    public static void main(String[] args) {
        Day02 logic = new Day02();
        logic.partOne();
    }

    private Day02DTO setUp(){
        List<String> list = reader.read(path);
        List<Character> chars = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        List<Integer> lowerRanges = new ArrayList<>();
        List<Integer> upperRanges = new ArrayList<>();
        for(int i = 0; i < list.size(); i ++) {
            String[] temp = list.get(i).split("-"); // range
            lowerRanges.add(Integer.valueOf(temp[0]));
            upperRanges.add(Integer.valueOf(temp[1]));
            chars.add(list.get(i++).charAt(0)); // required character
            passwords.add(list.get(i++)); // password
        }

        return new Day02DTO(lowerRanges, upperRanges, chars, passwords);
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        Day02DTO dto = setUp();

        int result = 0;

        for(int i = 0; i < dto.getPasswords().size(); i++) {
            String password = dto.getPasswords().get(i);
            int count = 0;
            char test = dto.getChars().get(i);
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == test) {
                    count++;
                }
            }
            if (count >= dto.getLowerRanges().get(i) && count <= dto.getUpperRanges().get(i)) result++;
        }
        System.out.println(result);
    }
}
