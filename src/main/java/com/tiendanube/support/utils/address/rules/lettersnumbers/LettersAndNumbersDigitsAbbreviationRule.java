package com.tiendanube.support.utils.address.rules.lettersnumbers;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.SplitAddressRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.LETTER_AND_DIGITS_ABBREVIATION;
import static com.tiendanube.support.utils.StringUtil.*;

public class LettersAndNumbersDigitsAbbreviationRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return matchWithRegex(floor, LETTER_AND_DIGITS_ABBREVIATION.getRegex());
    }

    @Override
    public SplittedAddress runRule(String floor) {

        Matcher matcher = Pattern.compile(LETTER_AND_DIGITS_ABBREVIATION.getRegex()).matcher(floor);

        if(!matcher.find()){
            return SplittedAddress.defaultIfFail(floor);
        }

        String splittedFloor = onlyNumbers(matcher.group(1));
        String splittedDepartament = matcher.group(2);

        if(isGreaterThan(splittedFloor, 2) || isGreaterThan(splittedDepartament, 4)) {
            return SplittedAddress.defaultIfFail(floor);
        }

        return new SplittedAddress(splittedFloor, splittedDepartament, "");

    }

}
