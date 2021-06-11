package com.tiendanube.support.utils.address.rules;

import com.tiendanube.support.utils.StringUtil;
import com.tiendanube.support.utils.address.model.SplittedAddress;

import static org.apache.commons.lang3.StringUtils.isAlphaSpace;

public class SplitAddressOnlyLettersRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return isAlphaSpace(floor);
    }

    @Override
    public SplittedAddress runRule(String floor) {

        if(StringUtil.isGreaterThan(floor, 4)) {
            return new SplittedAddress("", "", floor);
        }

        return new SplittedAddress("", floor, "");
    }

}
