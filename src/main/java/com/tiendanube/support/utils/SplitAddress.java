package com.tiendanube.support.utils;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.*;

import java.util.ArrayList;
import java.util.List;

import static com.tiendanube.support.utils.StringUtil.normalizeAll;

public class SplitAddress {

    private final String floor;

    public SplitAddress(String floor) {
        this.floor = normalizeAll(floor);
    }

    public SplittedAddress split() {

        try {

            List<SplitAddressRule> rules = new ArrayList<>();
            rules.add(new SplitAddressOnlyLettersRule());
            rules.add(new SplitAddressOnlyNumbersRule());
            rules.add(new SplitAddressLettersAndNumbersRule());

            return new SplitAddressRuleEngine().run(rules, this.floor);

        } catch (Exception e) {
            return SplittedAddress.defaultIfFail(this.floor);
        }

    }

}
