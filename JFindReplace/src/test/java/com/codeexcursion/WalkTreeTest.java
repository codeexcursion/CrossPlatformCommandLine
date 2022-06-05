/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 *
 * @author Mike
 */
public class WalkTreeTest {
    
    @Test
    public void testWalk() throws IOException{
        Path homeFolder = Paths.get("C:\\maven");
        Files.walk(homeFolder).forEach(System.out::println);
      
             
    }
}
