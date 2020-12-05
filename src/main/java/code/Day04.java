package code;

import shared.reader.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 {
    private static final Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day04.txt";

    public static void main(String[] args) {
        Day04 logic = new Day04();
        System.out.println("\n------ DAY FOUR ------\n");
        logic.partOne();
        logic.partTwo();
    }

    public String[] setUp() {
        String[] lines;
        try {
            lines = Files.lines(Path.of(path)).toArray(String[]::new);
            lines = String.join("\n", lines)
                    .replaceAll("\\b\\n\\b", " ")
                    .split("\\n\\n");
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        String[] lines = setUp();
        String[] regexes = regexOne();

        int count = 0;
        for(String line : lines){
            boolean valid = true;
            for(String regex : regexes){
                valid &= line.matches(regex);
            }
            if(valid){
                count++;
            }
        }
        System.out.println("Number of correct passports: " + count);
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        String[] lines = setUp();
        String[] regexes = regexTwo();


        int count = 0;
        for (String line : lines) {
            boolean valid = true;
            for (int i = 0; i < regexes.length; ++i) {
                Matcher m = Pattern.compile(regexes[i]).matcher(line);
                valid &= m.find();
                if (valid) {
                    switch (i) {
                        case 0:
                            int val = Integer.parseInt(m.group(1));
                            valid = val >= 1920 && val <= 2002;
                            break;
                        case 1:
                            val = Integer.parseInt(m.group(1));
                            valid = val >= 2010 && val <= 2020;
                            break;
                        case 2:
                            val = Integer.parseInt(m.group(1));
                            valid = val >= 2020 && val <= 2030;
                            break;
                        case 3:
                            val = Integer.parseInt(m.group(1));
                            switch (m.group(2)) {
                                case "cm":
                                    valid = val >= 150 && val <= 193;
                                    break;
                                case "in":
                                    valid = val >= 59 && val <= 76;
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            if (valid) {
                ++count;
            }
        }
        System.out.println("Number of correct passport: " + count);

    }

    private String[] regexOne(){
        return new String[]{
                ".*\\bbyr:.*",
                ".*\\biyr:.*",
                ".*\\beyr:.*",
                ".*\\bhgt:.*",
                ".*\\bhcl:.*",
                ".*\\becl:.*",
                ".*\\bpid:.*"
        };
    }

    private String[] regexTwo(){
        return new String[]{
                ".*\\bbyr:(\\d{4})\\b.*",
                ".*\\biyr:(\\d{4})\\b.*",
                ".*\\beyr:(\\d{4})\\b.*",
                ".*\\bhgt:(\\d+)(cm|in)\\b.*",
                ".*\\bhcl:#[0-9a-f]{6}\\b.*",
                ".*\\becl:(?:amb|blu|brn|gry|grn|hzl|oth)\\b.*",
                ".*\\bpid:\\d{9}\\b.*"
        };
    }
}
