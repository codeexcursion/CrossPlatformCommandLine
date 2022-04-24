/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.codeexcursion;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mike
 */
public enum FlagTypes {
    ERROR(true, ""), FIND(false, "-f", "-find"), NO_ANSI(true, "-noansi"), HELP(true, "-help"),
    DIRECTORY(false, "-d", "-directory"), SUPPRESS(true, "-s", "-suppress"), MAXIMUM(false, "-m", "-maximum"),
    INCLUDE(false, "-i", "-include"), EXCLUDE(false, "-e", "-exclude"), REPLACE(false, "-r", "-replace"),
    RECURSE(true, "-recurse"), CONTENT(true, "-c", "-content");
    
    
    private final List<String> flagAliases;
    private final boolean isSimple;
    
    private FlagTypes(boolean isSimple, String... flagNames){
        this.flagAliases = Arrays.asList(flagNames);
        this.isSimple = isSimple;
    }
    
    public boolean isSimple(){
        return isSimple;
    }
    
    public List<String> getFlagAliases(){
        return flagAliases;
    }
    
    public static FlagTypes from(String flagText){        
        for(FlagTypes type : FlagTypes.values()){
            if(type.getFlagAliases().contains(flagText)){
                return type;
            }
        }
        return FlagTypes.ERROR;
    }
    
    
    
}
