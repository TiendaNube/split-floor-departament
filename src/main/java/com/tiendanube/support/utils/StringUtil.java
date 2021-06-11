package com.tiendanube.support.utils;

import java.text.Normalizer;

import static com.tiendanube.support.constants.SplitFloorRegex.LETTERS;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * utility class for Strings
 */
public class StringUtil {

    /**
     * The function returns the argument string with whitespace normalized by using trim(String)
     * to remove leading and trailing whitespace and then replacing sequences of whitespace
     * characters by a single space.
     *
     *  Null Safe.
     *
     * @param input
     * @return String
     *
     */
    public static String normalizeSpaces(String input) {
        return normalizeSpace(input);
    }

    /**
     * Replaces any accentuation
     * @param input
     * @return
     */
    public static String replaceAccentuation(String input) {

        if(isEmpty(input)){
            return input;
        }

        return stripAccents(input);

    }

    /**
     * Replace all Special Characters
     * And keep spaces
     * @param input
     * @return
     */
    public static String removeSpecialCharacters(String input) {

        if(isEmpty(input)) {
            return input;
        }

        return input.replaceAll("[^a-z A-Z 0-9]"," ");
    }

    /**
     * this method will normalize all the string.
     * Will replace accentuation, remove special characters and
     * normalize spaces.
     * @param input
     * @return
     */
    public static String normalizeAll(String input) {

        if(isEmpty(input)){
            return input;
        }

        input = replaceAccentuation(input);
        input = removeSpecialCharacters(input);
        input = normalizeSpaces(input);

        return input;

    }

    /**
     * see if the string is greater than a size.
     * Starts with one.
     * @param input
     * @param size
     * @return
     */
    public static Boolean isGreaterThan(String input, int size) {

        if(isEmpty(input)){
            return Boolean.FALSE;
        }

        return length(input) > size;
    }

    /**
     * Verify if string contain Spaces.
     * @param input
     * @return
     */
    public static Boolean containSpaces(String input) {

        if(isEmpty(input)){
            return Boolean.FALSE;
        }

        return !input.matches("\\S+");

    }

    /**
     * Verify if the string match with regex
     * @param input
     * @param regex
     * @return
     */
    public static Boolean matchWithRegex(String input, String regex) {

        if(isEmpty(input)){
            return Boolean.FALSE;
        }

        return input.matches(regex);

    }

    /**
     *
     * Ignore invalid characters (some unrecognized accents, apostrophe and quote marks)
     *
     * @param string
     * @return
     */
    public static String flattenToAscii(final String string) {
        String normalizedString = Normalizer.normalize(string, Normalizer.Form.NFD).chars()
                .filter( c -> c <= '\u007F' && c != '\"' && c != '\'' )
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return normalizedString;
    }

    /**
     *
     * Return only Numbers
     *
     * @param input
     * @return
     */
    public static String onlyNumbers(final String input) {

        if(isEmpty(input)){
            return input;
        }

        return trim(input.replaceAll(LETTERS.getRegex(),""));

    }


}
