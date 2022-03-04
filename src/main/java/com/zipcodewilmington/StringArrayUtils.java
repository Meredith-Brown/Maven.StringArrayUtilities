package com.zipcodewilmington;

import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

import java.util.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        int length = array.length;
        return array[length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        int length = array.length;
        return array[length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        List<String> stringArrayList = new ArrayList<>(Arrays.asList(array)); // https://stackabuse.com/java-check-if-array-contains-value-or-element/
        return stringArrayList.contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) { // [1 2 3 4 5]
        for (int i = 0; i < array.length/2; i++) {
            String temporary = array[i]; // 1st iteration: temporary variable is assigned 1
            array[i] = array[array.length - i - 1]; // 1st iteration: the slot that held 1 is now assigned 5
            array[array.length - i - 1] = temporary; // 1st iteration: the slot that held 5 is now assigned 1
        }
        // https://www.youtube.com/watch?v=77N5qsea8qQ&list=PLmpmyPywZ443dRtMleUPoNp2OyiNE45O6&index=29
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int trueFalse = 0;
        for (int i = 0; i <= array.length/2 + 1; i++) {
            if (Objects.equals(array[i], array[array.length - 1 - i])) {

            } else {
                trueFalse = 1;
            }
        }
        return (trueFalse == 0);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String arrayAsString = Arrays.toString(array); // convert array to string
        String lowerCase = arrayAsString.toLowerCase(); // convert string to lower case
        int count = (int) lowerCase.chars().filter(i -> i >= 'a' && i <= 'z').distinct().count(); // count distinct letters in a string
// https://www.tutorialspoint.com/how-to-find-if-a-given-string-contains-only-letters-in-java
// https://stackoverflow.com/questions/39263751/how-to-check-if-a-string-contains-all-the-letters-of-the-alphabet
        return (count == 26);
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i].equals(value)) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int count = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i].equals(valueToRemove)) {
                count += 1;
            }
        }
        String[] newArray = new String[array.length - count];
        for (int index1 = 0, index2 = 0; index1 < array.length; index1++) {
            if (Objects.equals(array[index1], valueToRemove)) {
            } else {
                newArray[index2] = array[index1];
                index2++;
            }
        }
        // https://stackabuse.com/remove-element-from-an-array-in-java/
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> newArrayList = new ArrayList<>(Arrays.asList(array));
        for (int i = 1; i < newArrayList.size(); i++) {
            if (newArrayList.get(i) == newArrayList.get(i-1)) { // use .get -> https://stackoverflow.com/questions/23535346/comparing-elements-in-the-same-list-java
                newArrayList.remove(i);
                i--;
            }
        }
        int size = newArrayList.size();
        String[] newArray = newArrayList.toArray(new String[0]);
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List<String> newArrayList = new ArrayList<>(Arrays.asList(array));
        List<String> copiedArrayList = new ArrayList<>(newArrayList);
        int copyCount = copiedArrayList.size() - 1;
        for (int i = newArrayList.size()-2; i >= 0; i--) {
            if (Objects.equals(newArrayList.get(i), copiedArrayList.get(copyCount))) {
                newArrayList.set(i + 1, newArrayList.get(i) + newArrayList.get(i +1));
                newArrayList.remove(i);
                copyCount -= 1;
            } else {
             copyCount -= 1;
            }
        }
        String[] outputArray = newArrayList.toArray(new String[0]);
        return outputArray;
    }


}
