/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 *
 * @author Mike
 */
public class FileFindReplace {

    
    public FileFindReplace(Path fileName, String find, String replace) {
        Optional.ofNullable(fileName).orElseThrow(IllegalArgumentException::new);
        Optional.ofNullable(find).orElseThrow(IllegalArgumentException::new);
        
        try{
            byte[] encoded = Files.readAllBytes(fileName);
            String fileContents = new String(encoded);
            
        }catch(IOException ioe){
            ioe.printStackTrace(); //fix this
        }
        
    }
    
    
    
    private void findReplace(){
        
    }
}
