package com.tiendanube.support.utils.address.rules;

import com.tiendanube.support.utils.address.model.SplittedAddress;

public interface SplitAddressRule {

    public boolean hasCondition(final String floor);

    public SplittedAddress runRule(final String floor);


}
