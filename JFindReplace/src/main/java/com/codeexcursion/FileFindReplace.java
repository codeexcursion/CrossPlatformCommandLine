/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mike
 */
public class FileFindReplace {
    private Matches matches;
    
    
    public FileFindReplace(Path fileName, String find, String replace) {
        Optional.ofNullable(fileName).orElseThrow(IllegalArgumentException::new);
        Optional.ofNullable(find).orElseThrow(IllegalArgumentException::new);
        
        try{
            byte[] encoded = Files.readAllBytes(fileName);
            String fileContents = new String(encoded);
            findReplace(fileName.toString(), fileContents, find);
        }catch(IOException ioe){
            ioe.printStackTrace(); //fix this
        }
        
    }
    
    
    
    private void findReplace(String fileName, String fileContents, String find){   
        List<String> finds = new ArrayList<>();
        Pattern p = Pattern.compile(find);
        Matcher m = p.matcher(fileContents);
        int count = 0;
        while(m.find()){
            finds.add(fileContents.substring(m.start(), m.end()));
            count++;
        }
              
        matches = new Matches(fileName, finds);
    }
    
    public Matches getMatches(){
        return matches;
    }
}
