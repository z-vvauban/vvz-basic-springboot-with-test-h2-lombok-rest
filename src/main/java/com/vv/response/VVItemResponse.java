package com.vv.response;

import com.vv.domain.VVItem;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VVItemResponse {

    private String vvId;
    private String name;

    public static VVItemResponse map( VVItem vvItem ) {
        VVItemResponse result = VVItemResponse.builder()
                                              .vvId( vvItem.getVvId() )
                                              .name( vvItem.getName() )
                                              .build();
        return result;
    }

}
