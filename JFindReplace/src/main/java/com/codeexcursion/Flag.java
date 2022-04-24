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
public class Flag {
    
    private FlagTypes type;
    private List<String> options;
    
    public Flag(String flagText){
        this.type = FlagTypes.from(flagText);
        
    }
    
    public void addOption(String text){
        Optional.ofNullable(text).orElseThrow(IllegalArgumentException::new);
        options.add(text);
    }

    public FlagTypes getType() {
        return type;
    }

    public List<String> getText() {
        return options;
    }
    
    }
