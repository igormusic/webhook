package com.tvmsoftware.webhook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class WebhookController {

    @PostMapping
    public ResponseEntity<Mono<Void>> post(@RequestHeader Map<String, String> headers, @RequestBody Object body) {

        Map<String, Object> payload = new HashMap<>();

        payload.put("headers", headers);
        payload.put("body", body);

        try {
            log.info( "Payload: " +  new ObjectMapper().writeValueAsString(payload));
        } catch (JsonProcessingException e) {
            log.error("error serializing content",e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Mono.empty());
        }

        return ResponseEntity.status(HttpStatus.OK).body(Mono.empty());
    }

}
