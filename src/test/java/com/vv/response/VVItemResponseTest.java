package com.vv.response;


import com.vv.domain.VVItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VVItemResponseTest {

    @Test
    public void testMap() {
        VVItemResponse vvItemResponseExpected = VVItemResponse.builder()
                                                              .vvId( "1" )
                                                              .name( "abc" )
                                                              .build();

        VVItem vvItem = VVItem.builder()
                              .vvId( "1" )
                              .name( "abc" )
                              .build();

        VVItemResponse vvItemResponseActual = VVItemResponse.map( vvItem );

        assertThat( vvItemResponseActual )
                .isEqualTo( vvItemResponseExpected );
    }
}
