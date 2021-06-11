package com.tiendanube.support.utils.address.rules;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.lettersnumbers.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlphanumericSpace;

public class SplitAddressLettersAndNumbersRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return isAlphanumericSpace(floor);
    }

    @Override
    public SplittedAddress runRule(String floor) {

        List<SplitAddressRule> rules = new ArrayList<>();
        rules.add(new LettersAndNumbersDepartamentAddressRule());
        rules.add(new LettersAndNumbersDigitsAbbreviationRule());
        rules.add(new LettersAndNumbersAddressRule());
        rules.add(new LettersAndNumbersDepartamentRule());
        rules.add(new LettersAndNumbersNoSpaceRule());
        rules.add(new LettersAndNumbersDigitsWithOneSpaceRule());

      return new SplitAddressRuleEngine().run(rules, floor);

    }


}
