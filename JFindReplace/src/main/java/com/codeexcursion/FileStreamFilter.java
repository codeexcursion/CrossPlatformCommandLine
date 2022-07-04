/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author Mike
 */
public class FileStreamFilter {
    private Stream<Path> filteredStream;

    public FileStreamFilter(Stream<Path> unfilteredStream, int maxFileSize, List<String> includes, List<String> excludes) {
        Optional.ofNullable(unfilteredStream).orElseThrow(IllegalArgumentException::new);
                      
        filteredStream = unfilteredStream
                .filter(Objects::nonNull)
                .filter(path -> Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS))
                .filter(path -> path.toFile().length() <= maxFileSize)
                .filter(path -> includes.contains(getFileExtension(path)))
                .filter(path -> !excludes.contains(getFileExtension(path)));        
    }    
       
    private String getFileExtension(Path path){
        String fileName = path.toString();
        String extension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex >0){
            extension =fileName.substring(dotIndex);
        }
        return extension;
    }
    
    public Stream<Path> getFilteredStream(){
        return filteredStream;
    }
}
