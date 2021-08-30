package com.tsm.stream.service;

import com.tsm.stream.utils.SampleJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    @Autowired
    private ResourceLoader resourceLoader;

    private static final String FORMAT="classpath:videos/%s.mp4"; //video should present under
                                                                // resource -> videos / filename.mp4

    public Mono<Resource> getVideo(String id){ //send Resource based on title here title is the id only
        return Mono.fromSupplier(
                ()->resourceLoader.getResource(String.format(FORMAT,id))
        );
    }


    //to be implemented in future after making file meta dynamic
    public Object getVideosMetaData(String title){

        return null;
    }
    public Object getVideosMetaData(){

        return SampleJson.sampleJson; //hardcoded .. to be made dynamic in future
    }


}
