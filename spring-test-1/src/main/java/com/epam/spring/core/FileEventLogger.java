package com.epam.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sergii_Chertkov on 2/26/2016.
 */
public class FileEventLogger implements EventLoger {
    private String filename;
    private File file;

    public FileEventLogger(String filename){
        this.filename = filename;
    }

    public void logEvent(Event event) {
        try {
            this.file = new File(this.filename);
            FileUtils.writeStringToFile(this.file, event.toString()+"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        this.file = new File(this.filename);
        if(!this.file.canWrite())
            throw new IOException("cannot write to file " + filename);
    }

}
