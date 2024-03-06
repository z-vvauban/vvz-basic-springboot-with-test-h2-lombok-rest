package com.vv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vv.domain.VVItem;
import com.vv.repository.VVRepository;
import com.vv.response.VVItemResponse;
import com.vv.response.VVItemResponseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK )
@AutoConfigureMockMvc
public class VVServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VVRepository vvRepository;

    @Test
    public void getVVTest() throws Exception {
        String expectedResult = "vv";

        String actualResult = this.mockMvc //
                                           .perform( get( "http://localhost:8080/api/v1/vv" )
                                                             .accept( MediaType.parseMediaType( "application/json" ) ) ) //
                                           .andExpect( status().isOk() )
                                           .andReturn()
                                           .getResponse()
                                           .getContentAsString();

        assertThat( actualResult ).isEqualTo( expectedResult );

    }

    @Test
    public void getAllTest() throws Exception {
        vvRepository.save( VVItem.builder()
                                 .vvId( "1" )
                                 .name( "nameA" )
                                 .build() );

        vvRepository.save( VVItem.builder()
                                 .vvId( "2" )
                                 .name( "nameB" )
                                 .build() );

        int expectedResult = 2;

        this.mockMvc //
                     .perform( get( "http://localhost:8080/api/v1/all" ) ) //
                     .andExpect( status().isOk() )
                     .andExpect( content().contentType( "application/json" ) )
                     .andExpect( jsonPath( "$.length()" ).value( expectedResult ) );


    }

    @Test
    public void postTest() throws Exception {

        VVItem item = VVItem.builder()
                            .name( "abc1" )
                            .build();

        String actual = mockMvc.perform( post( "/api/v1/vv" )
                                                 .contentType( MediaType.APPLICATION_JSON )
                                                 .content( asJsonString( item ) ) )
                               .andExpect( status().isCreated() )
                               .andReturn()
                               .getResponse()
                               .getContentAsString();

        VVItemResponse actualBean = new ObjectMapper().readValue( actual, VVItemResponse.class );



        assertThat( vvRepository.findByName( "abc1 saved" )
                                .stream()
                                .count() ).isEqualTo( 1 );

        assertThat( actualBean.getName() ).isEqualTo(  "abc1 saved" );
    }

    protected static String asJsonString( final Object obj ) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString( obj );
            return jsonContent;
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}
