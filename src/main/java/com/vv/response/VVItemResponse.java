package com.vv.response;

import com.vv.domain.Item;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VVItemResponse {

    private String vvId;
    private String name;

    public static VVItemResponse map( Item item ) {
        VVItemResponse result = VVItemResponse.builder()
                                              .vvId( item.getVvId() )
                                              .name( item.getName() )
                                              .build();
        return result;
    }

}
