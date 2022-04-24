/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author Mike
 */
public class ParseParameters {
    private List<Flag> flags;
    private List<String> errors;
    private boolean isGood = true;
    
    
    public ParseParameters(String[] parameters){
       this.flags = new ArrayList<Flag>();
       this.errors = new ArrayList<String>();
        if(parameters == null || parameters.length <1){
            HelpText.printHelp();    
            isGood = false;
        }        
        parseParams(parameters);
    }
    
    public boolean isGood(){
        return isGood;
    }
    
    public List<Flag> getFlags(){
        return flags;
    }
    
    private void parseParams(String[] parameters){
      List<String> paramList = Arrays.asList(parameters);
      Optional<String> firstParam = paramList.stream().findFirst();
      firstParam.ifPresent(this::handleFirstParam);
      
      if(!isGood){
          return;
      }
      
      Flag lastFlag = null;
      for(String param : paramList){
          if(param != null){
              if(param.startsWith("-")){
                  lastFlag = new Flag(param);
                  flags.add(lastFlag);
              }else{
                  if(lastFlag != null){
                    lastFlag.addOption(param);
                  }
              }
          }
      }
      
      
      
    }
    
    private void handleFirstParam(String firstParam){
        Flag firstFlag = new Flag(firstParam);
        if(firstFlag.getType() == FlagTypes.ERROR){
            isGood = false;
            errors.add("First parameter must be a flag.");
        }        
    }
    
}
