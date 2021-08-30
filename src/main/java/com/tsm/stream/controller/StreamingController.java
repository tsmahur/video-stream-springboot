package com.tsm.stream.controller;

import com.tsm.stream.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping(value = "video/{title}", produces = "video/mp4") //producing the mp4 response
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        //range header is sent by the video player

        return service.getVideo(title);
    }

}
