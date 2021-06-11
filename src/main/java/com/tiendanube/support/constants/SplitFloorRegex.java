package com.tiendanube.support.constants;

public enum SplitFloorRegex {

    TWO_DIGITS_GROUP("^(\\d+)(\\s)(\\d+)$"),
    LETTERS_AND_DIGITS_DEPARTAMENT_FLOOR("^(?i)(departamento|depto|timbre|numero|número|dpto|d|t|dto)(?-i) (.*) (?i)(piso|p|pb)(?-i) (.*)$"),
    LETTERS_AND_DIGITS_FLOOR_DEPARTAMENT("^(?i)(piso|p|pb)(?-i) (.*) (?i)(departamento|depto|timbre|numero|número|dpto|d|t|dto)(?-i) (.*)$"),
    LETTERS_AND_DIGITS_DEPARTAMENT("^(?i)(departamento|depto|timbre|numero|número|dpto|d|t)(?-i) (.*)$"),
    LETTERS_AND_DIGITS_FLOOR("^(?i)(piso|p|pb)(?-i) (.*)$"),
    LETTERS_AND_DIGITS_NO_SPACES("^([a-zA-Z]+|[0-9]+)([a-zA-Z]+|[0-9]+)$"),
    LETTERS_AND_DIGITS_WITH_ONE_SPACE("^([a-zA-Z]+|[0-9]+) ([a-zA-Z]+|[0-9]+)$"),
    LETTER_AND_DIGITS_ABBREVIATION("^(1ro|2do|3ro|4to|5to|6to|7mo|8vo|9no|10mo|1 ro|2 do|3 ro|4 to|5 to|6 to|7 mo|8 vo|9 no| 10 mo) (.*)$"),
    LETTERS("[a-zA-Z]+"),
    DIGITIS("[0-9]+"),
    ;

    private String regex;

    private SplitFloorRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

}
