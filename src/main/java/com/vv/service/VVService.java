package com.vv.service;

import com.vv.domain.VVItem;
import com.vv.repository.VVRepository;
import com.vv.request.VVItemRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VVService {


    private final VVRepository vvRepository;

    public String vv() {
        return "vv";
    }


    public VVItem postItem( VVItemRequest vvItemRequest ) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        VVItem result = vvRepository.save( VVItem.builder()
                                                 .vvId( uuidAsString )
                                                 .name( vvItemRequest.getName() + " saved" )
                                                 .build() );
        return result;
    }

    public List<VVItem> getAll() {
        return vvRepository.findAll();
    }
}
