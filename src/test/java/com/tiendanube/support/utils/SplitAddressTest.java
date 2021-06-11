package com.tiendanube.support.utils;

import com.tiendanube.support.utils.address.model.SplittedAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test class for {@link SplitAddress}
 */
public class SplitAddressTest {

    @ParameterizedTest
    @MethodSource("addressProvider")
    public void addressSplit(String address, String expectedFloor, String expectedDepartament, String expectedObservations) {

        SplittedAddress splittedAddress = new SplitAddress(address).split();

        Assertions.assertEquals(splittedAddress.getFloor(), expectedFloor);
        Assertions.assertEquals(splittedAddress.getDepartment(), expectedDepartament);
        Assertions.assertEquals(splittedAddress.getObservations(), expectedObservations);

    }

    private static Stream<Arguments> addressProvider() {
        return Stream.of(
                Arguments.of("Piso 6 dpto b.","6","b",""),
                Arguments.of("Planta baja fondo","","","Planta baja fondo"),
                Arguments.of("2B","2","B",""),
                Arguments.of("Piso 1 dpto 2","1","2",""),
                Arguments.of("6to A","6","A",""),
                Arguments.of("Casa 3","3","Casa",""),
                Arguments.of("piso 3 depto C","3","C","")
        );
    }


}
