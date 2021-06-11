package com.tiendanube.support.utils.address.rules.lettersnumbers;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import com.tiendanube.support.utils.address.rules.SplitAddressRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tiendanube.support.constants.SplitFloorRegex.LETTERS_AND_DIGITS_DEPARTAMENT_FLOOR;
import static com.tiendanube.support.constants.SplitFloorRegex.LETTERS_AND_DIGITS_FLOOR_DEPARTAMENT;
import static com.tiendanube.support.utils.StringUtil.isGreaterThan;
import static com.tiendanube.support.utils.StringUtil.matchWithRegex;
import static org.apache.commons.lang3.StringUtils.isAlphaSpace;
import static org.apache.commons.lang3.StringUtils.trim;

public class LettersAndNumbersDepartamentAddressRule implements SplitAddressRule {

    @Override
    public boolean hasCondition(String floor) {
        return matchWithRegex(floor, LETTERS_AND_DIGITS_DEPARTAMENT_FLOOR.getRegex()) || matchWithRegex(floor, LETTERS_AND_DIGITS_FLOOR_DEPARTAMENT.getRegex());
    }

    @Override
    public SplittedAddress runRule(String floor) {

        if(matchWithRegex(floor, LETTERS_AND_DIGITS_DEPARTAMENT_FLOOR.getRegex())) {

            Matcher matcher = Pattern.compile(LETTERS_AND_DIGITS_DEPARTAMENT_FLOOR.getRegex()).matcher(floor);

            if(!matcher.find()) {
                return SplittedAddress.defaultIfFail(floor);
            }

            String splittedFloor = trim(matcher.group(4));
            String splittedDepartament = trim(matcher.group(2));

            return this.setLetterAndDigitsFloorAndDepartament(floor, splittedFloor, splittedDepartament);

        }

        if(matchWithRegex(floor, LETTERS_AND_DIGITS_FLOOR_DEPARTAMENT.getRegex())){

            Matcher matcher = Pattern.compile(LETTERS_AND_DIGITS_FLOOR_DEPARTAMENT.getRegex()).matcher(floor);

            if(!matcher.find()) {
                return SplittedAddress.defaultIfFail(floor);
            }

            String splittedFlor =  matcher.group(2);
            String splittedDepartament = matcher.group(4);

            return this.setLetterAndDigitsFloorAndDepartament(floor, splittedFlor, splittedDepartament);

        }

        return SplittedAddress.defaultIfFail(floor);
    }


    private SplittedAddress setLetterAndDigitsFloorAndDepartament(String floor, String floorSplited, String departamentSplited){

        if(isAlphaSpace(floorSplited) || isGreaterThan(floorSplited,2) || isGreaterThan(departamentSplited, 4)) {
            return SplittedAddress.defaultIfFail(floor);
        }

        return new SplittedAddress(floorSplited, departamentSplited, "");

    }
}
