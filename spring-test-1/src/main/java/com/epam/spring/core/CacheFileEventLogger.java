package com.epam.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class CacheFileEventLogger implements EventLoger{
    private FileEventLogger fEventLog;
    private String filename;
    private File file;
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, String cacheSize){
        this.fEventLog = new FileEventLogger(filename);
        this.filename = filename;
        System.out.println(Integer.valueOf(cacheSize));
        this.cacheSize = Integer.valueOf(cacheSize);
        this.cache = new ArrayList<Event>();
    }

    public void logEvent(Event event){
        cache.add(event);

        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (int i=0; i<cacheSize; i++)
            fEventLog.logEvent(cache.get(i));
    }

    private void destroy(){
        if (!cache.isEmpty())
            writeEventsFromCache();
    }

    private void init() throws IOException{
        fEventLog.init();
    }
}
