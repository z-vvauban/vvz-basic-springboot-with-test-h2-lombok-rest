package com.vv.service;

import com.vv.domain.Item;
import com.vv.repository.VVRepository;
import com.vv.request.VVItemRequest;
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


    public Item postItem( VVItemRequest vvItemRequest ) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Item result = vvRepository.save( Item.builder()
                                             .vvId( uuidAsString )
                                             .name( vvItemRequest.getName() + " saved" )
                                             .build() );
        return result;
    }

    public List<Item> getAll() {
        return vvRepository.findAll();
    }
}
