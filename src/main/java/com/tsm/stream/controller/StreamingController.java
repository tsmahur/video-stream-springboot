package com.tsm.stream.controller;

import com.tsm.stream.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/video")
//@CrossOrigin config file is added for cors
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping(value = "/{id}", produces = "video/mp4") //producing the mp4 response
    public Mono<Resource> getVideos(@PathVariable String id, @RequestHeader("Range") String range) {
//        System.out.println("range in bytes() : " + range);
        //range header is sent by the video player
        System.out.println("video sending..");
        return service.getVideo(id);
    }
    @GetMapping(value = "/meta/{id}")  //producing meta data for specific video
    public Object getVideosMetaDataByTitle(@PathVariable String id) {

        return service.getVideosMetaData(id);
    }

    @GetMapping(value = "/meta") //producing meta data for all video available in store
    public Object getVideosMetaDataAll() {
        System.out.println("getVideosMetaDataAll() called :");
        return service.getVideosMetaData();
    }

}
