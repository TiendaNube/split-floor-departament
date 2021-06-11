package com.tiendanube.support.utils.address.rules;

import com.tiendanube.support.utils.address.model.SplittedAddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.TWO_DIGITS_GROUP;
import static com.tiendanube.support.utils.StringUtil.*;
import static org.apache.commons.lang3.StringUtils.isNumericSpace;

public class SplitAddressOnlyNumbersRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return isNumericSpace(floor);
    }

    @Override
    public SplittedAddress runRule(String floor) {

        if(!containSpaces(floor)) {

            if(isGreaterThan(floor, 2)){
                return SplittedAddress.defaultIfFail(floor);
            }

            return new SplittedAddress(floor, "", "");
        }

        if(matchWithRegex(floor, TWO_DIGITS_GROUP.getRegex())) {

            Matcher matcher = Pattern.compile(TWO_DIGITS_GROUP.getRegex()).matcher(floor);

            if(matcher.find()) {
                return new SplittedAddress(matcher.group(1),matcher.group(2), "" );
            }

        }

        return SplittedAddress.defaultIfFail(floor);

    }

}
