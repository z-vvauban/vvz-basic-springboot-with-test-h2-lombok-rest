package com.vv.controller;

import com.vv.request.VVItemRequest;
import com.vv.response.VVItemResponse;
import com.vv.service.VVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api/v1" )
@RequiredArgsConstructor
public class VVController {

    private final VVService vvService;

    @GetMapping( "/vv" )
    public String vv() {
        return "vv";
    }

    @PostMapping( "/vv" )
    @ResponseStatus(HttpStatus.CREATED)
    public VVItemResponse vvPost( @RequestBody VVItemRequest vvItemRequest ) {
        return VVItemResponse.map( vvService.postItem( vvItemRequest ) );

    }

    @GetMapping( "/all" )
    public List<VVItemResponse> vvGetAll() {
        return vvService.getAll()
                        .stream()
                        .map( VVItemResponse::map )
                        .toList();
    }


}
