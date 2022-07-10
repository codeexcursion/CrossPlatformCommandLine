/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Mike
 */
public class Matches {
    private String fileName;
    private List<String> matches;

    public Matches(String fileName, List<String> matches) {
        this.fileName = Optional.ofNullable(fileName).orElseThrow(IllegalArgumentException::new);
        this.matches = Optional.ofNullable(matches).orElseThrow(IllegalArgumentException::new);
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getMatches() {
        return matches;
    }
    
    public void print(){
        System.out.println(fileName);
        System.out.println(matches.size() + " matches");
        matches.forEach(System.out::println);
    }
    
}
