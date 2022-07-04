/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;


public class Execution {
    private final List<Flag> flagList;
    private Path directory = Paths.get(".");
    private int maxFileSize = 65536;
    private int maxDepth = 1;
    private List<String> includes = DefaultFileExtensions.getFileExtensions();
    private List<String> excludes = new ArrayList<>(); 
    private String find, replace;
    private boolean content = false;
    private boolean suppress = false;

    public Execution(List<Flag> flagList) {
        this.flagList = Optional.ofNullable(flagList).orElseThrow(IllegalArgumentException::new);
        configure();
        run();
    }
    
    private void configure(){
        for (Flag flag : flagList){
            switch(flag.getType()){
                case DIRECTORY :  {setDirectory(flag); break;}
                case MAXIMUM: {setMaximum(flag); break;}
                case RECURSE: {setRecursive(); break;}                           
                case INCLUDE: {setInclude(flag); break;}
                case EXCLUDE: {setExclude(flag); break;}
                case FIND: {setFind(flag); break;}
                case REPLACE: {setReplace(flag); break;}
                case CONTENT: {setContent(); break;}
                case SUPPRESS: {setSuppress(); break;}
            }
        }
    }
    
    private void setDirectory(Flag flag){
        this.directory = Paths.get(flag.getOptions().get(0));
    }
    
    private void setMaximum(Flag flag){
        maxFileSize = Integer.parseInt(flag.getOptions().get(0));
    }
    
    private void setRecursive(){
        this.maxDepth = Integer.MAX_VALUE;
    }
    
    private void setInclude(Flag flag){
        flag.getOptions().forEach(includes::add);
    }
    
     private void setExclude(Flag flag){
        flag.getOptions().forEach(excludes::add);
    }
     
    private void setFind(Flag flag){
       this.find = flag.getOptions().get(0);
    }
     
    private void setReplace(Flag flag){
        this.replace = flag.getOptions().get(0);
    }
    
    private void setContent(){
        this.content = true;
    }
    
    private void setSuppress(){
        this.suppress = true;
    }
    
    private void run(){
        Stream<Path> filteredStream = null;
        try{
            FileStreamFilter fileStreamFilter = new FileStreamFilter(
                    Files.walk(directory, maxDepth, FileVisitOption.FOLLOW_LINKS),
                    maxFileSize,
                    includes,
                    excludes);
            filteredStream = fileStreamFilter.getFilteredStream();
            
              
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
  
    
}
