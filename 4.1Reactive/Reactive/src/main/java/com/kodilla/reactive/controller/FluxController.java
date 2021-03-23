package com.kodilla.reactive.controller;

import com.kodilla.reactive.model.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getBookDtoFlux(){
        return Flux
                .just(
                        new BookDto("title1", "author1", 2001),
                        new BookDto("title2", "author2", 2002),
                        new BookDto("title3", "author3", 2003)
                )
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
