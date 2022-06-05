/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

/**
 *
 * @author Mike
 */
public class Controller {
    
    public void run(String[] args){
        ParseParameters parseParameters = new ParseParameters(args);
        
        if(!parseParameters.isGood()){
            HelpText.printShortHelp();
            parseParameters.getErrors().forEach(System.out::println);
            return;
        }
        
        if(parseParameters.getFlags().stream()
                .anyMatch(flag -> FlagTypes.HELP.equals(flag.getType()))){
            HelpText.printHelp();
            return;
        }
        
        
    }
}
