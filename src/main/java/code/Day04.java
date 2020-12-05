package code;

import shared.reader.*;

import java.util.*;
import java.util.Map.Entry;

public class Day04 {
    private static final Reader reader = new Reader();
    private static final String path = "src/main/resources/day04.txt";

    public static void main(String[] args) {
        Day04 logic = new Day04();
        System.out.println("\n------ DAY FOUR ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<List<Map<String, String>>> setUp(){
        List<List<Map<String, String>>> list = reader.readBatches(path);
        final int[] counter = {0};
        list.forEach(subList -> counter[0]++);
        System.out.println("Amount of sublists: " + counter[0]);
        return list;
    }

    private List<String> fillRequirements(){
        List<String> requirements = new ArrayList<>();
        requirements.add("byr");
        requirements.add("iyr");
        requirements.add("eyr");
        requirements.add("hgt");
        requirements.add("hcl");
        requirements.add("ecl");
        requirements.add("pid");
        requirements.add("cid");
        return requirements;
    }

    private void partOne(){
        List<List<Map<String, String>>> list = setUp();
        final boolean[] valid = {false};
        final int[] counter = {0};
        list.forEach((List<Map<String, String>> subList) -> {
            valid[0] = false;
            List<String> requirements = fillRequirements();
            subList.forEach((Map<String, String> map) -> {
                map.forEach((key, value) -> {
                    for(String requirement : requirements){
                        if(key.equals(requirement)){
                            valid[0] = true;
                            break;
                        }else{
                            valid[0] = false;
                        }
                    }
                });
            });
            if(valid[0]) counter[0]++;
        });
        System.out.println("Correct passports: " + counter[0]);
    }

    private void partTwo(){

    }

}
