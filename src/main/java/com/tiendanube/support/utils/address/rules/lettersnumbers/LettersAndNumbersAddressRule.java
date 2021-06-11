package com.tiendanube.support.utils.address.rules.lettersnumbers;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.SplitAddressRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.LETTERS_AND_DIGITS_FLOOR;
import static com.tiendanube.support.utils.StringUtil.isGreaterThan;
import static com.tiendanube.support.utils.StringUtil.matchWithRegex;

public class LettersAndNumbersAddressRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return matchWithRegex(floor, LETTERS_AND_DIGITS_FLOOR.getRegex());
    }

    @Override
    public SplittedAddress runRule(String floor) {

        Matcher matcher = Pattern.compile(LETTERS_AND_DIGITS_FLOOR.getRegex()).matcher(floor);

        if(!matcher.find()) {
            return SplittedAddress.defaultIfFail(floor);
        }

        String splittedFloor = matcher.group(2);

        SplitAddressRule lettersAndNumbers = new LettersAndNumbersDigitsWithOneSpaceRule();

        if(lettersAndNumbers.hasCondition(splittedFloor)) {
            return lettersAndNumbers.runRule(splittedFloor);
        }

        if(isGreaterThan(splittedFloor, 2)){
            return SplittedAddress.defaultIfFail(floor);
        }

        return new SplittedAddress(splittedFloor, "", "");

    }
}
