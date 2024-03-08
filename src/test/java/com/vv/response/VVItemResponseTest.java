package com.vv.response;


import com.vv.domain.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VVItemResponseTest {

    @Test
    public void testMap() {
        VVItemResponse vvItemResponseExpected = VVItemResponse.builder()
                                                              .vvId( "1" )
                                                              .name( "abc" )
                                                              .build();

        Item item = Item.builder()
                        .vvId( "1" )
                        .name( "abc" )
                        .build();

        VVItemResponse vvItemResponseActual = VVItemResponse.map( item );

        assertThat( vvItemResponseActual )
                .isEqualTo( vvItemResponseExpected );
    }
}
