package com.tiendanube.support.utils.address.rules.lettersnumbers;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.SplitAddressRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.LETTERS_AND_DIGITS_DEPARTAMENT;
import static com.tiendanube.support.utils.StringUtil.isGreaterThan;
import static com.tiendanube.support.utils.StringUtil.matchWithRegex;

public class LettersAndNumbersDepartamentRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return matchWithRegex(floor, LETTERS_AND_DIGITS_DEPARTAMENT.getRegex());
    }

    @Override
    public SplittedAddress runRule(String floor) {

        Matcher matcher = Pattern.compile(LETTERS_AND_DIGITS_DEPARTAMENT.getRegex()).matcher(floor);

        if(!matcher.find()) {
            return SplittedAddress.defaultIfFail(floor);
        }

        String splittedDepartament = matcher.group(2);

        if(isGreaterThan(splittedDepartament, 4)){
            return SplittedAddress.defaultIfFail(floor);
        }

        return new SplittedAddress("", splittedDepartament, "");

    }
}
