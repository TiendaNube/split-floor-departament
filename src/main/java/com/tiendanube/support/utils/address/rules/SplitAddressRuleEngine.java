package com.tiendanube.support.utils.address.rules;

import com.tiendanube.support.utils.address.model.SplittedAddress;

import java.util.List;

public class SplitAddressRuleEngine {

    public SplittedAddress run(List<SplitAddressRule> rules, String floor) {

        SplittedAddress address = null;

        for(SplitAddressRule rule : rules) {
            if(rule.hasCondition(floor)){
                address = rule.runRule(floor);
                break;
            }
        }

        return address == null ? SplittedAddress.defaultIfFail(floor) : address;

    }

}
