package org.jht.support;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    // List of parishes in Jamaica
    @Getter
    private static final List<String> parishes = Arrays.asList(
            "Kingston",
            "St. Andrew",
            "St. Catherine",
            "Clarendon",
            "Manchester",
            "St. Elizabeth",
            "Westmoreland",
            "Hanover",
            "St. James",
            "Trelawny",
            "St. Ann",
            "St. Mary",
            "Portland",
            "St. Thomas"
    );

    public static List<String> getAllCombination(){
        // Print all parishes
        System.out.println("Parishes in Jamaica:");
        for (String parish : parishes) {
            System.out.println(parish);
        }

        // Print all possible twoLevelCombinations
        List<List<String>> twoLevelCombinations = generateTwoLevelCombinations();

        // Print all twoLevelCombinations
        System.out.println("All possible twoLevelCombinations in two levels:");
        List<String> combinations = new ArrayList<>();
        for (List<String> combination : twoLevelCombinations) {
            System.out.println(combination);
            combinations.add(String.join(" - ", combination));
        }

      return combinations;
    }

    private static List<List<String>> generateTwoLevelCombinations() {
        List<List<String>> combinations = new ArrayList<>();
        for (int i = 0; i < Data.parishes.size(); i++) {
            for (int j = i + 1; j < Data.parishes.size(); j++) {
                List<String> combination = new ArrayList<>();
                combination.add(Data.parishes.get(i));
                combination.add(Data.parishes.get(j));
                combinations.add(combination);
            }
        }
        return combinations;
    }

}
