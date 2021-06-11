package com.tiendanube.support.utils.address.rules.lettersnumbers;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.SplitAddressRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.*;
import static com.tiendanube.support.utils.StringUtil.isGreaterThan;
import static com.tiendanube.support.utils.StringUtil.matchWithRegex;

public class LettersAndNumbersNoSpaceRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return matchWithRegex(floor, LETTERS_AND_DIGITS_NO_SPACES.getRegex());
    }

    @Override
    public SplittedAddress runRule(String floor) {

        String splittedFloor = "";
        String splittedDepartament = "";

        Matcher matcher = Pattern.compile(DIGITIS.getRegex()).matcher(floor);

        if(matcher.find()) {
            splittedFloor = matcher.group(0);
        }

        matcher = Pattern.compile(LETTERS.getRegex()).matcher(floor);

        if(matcher.find()) {
            splittedDepartament = matcher.group(0);
        }

        if(isGreaterThan(splittedFloor,2) || isGreaterThan(splittedDepartament,4)) {
            return SplittedAddress.defaultIfFail(floor);
        }

        return new SplittedAddress(splittedFloor, splittedDepartament, "");

    }
}
