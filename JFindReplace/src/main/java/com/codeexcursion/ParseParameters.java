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
        if(parameters == null || parameters.length <1){
            isGood = false;
            return;
        }  
       this.flags = new ArrayList<Flag>();
       this.errors = new ArrayList<String>();
           
       parseParams(parameters);
    }
    
    public boolean isGood(){
        return isGood;
    }
    
    public List<Flag> getFlags(){
        return flags;
    }
    
    public List<String> getErrors(){
        return errors;
    }
    
    private List<String> getParamList(String[] params){
        List<String> paramList = new ArrayList<>();
        for(String param : params){
            if(param != null){
                paramList.add(param);
            }
        }
        return paramList;
    }
    
    private void parseParams(String[] parameters){
      List<String> paramList = getParamList(parameters);
      Flag lastFlag = null;
      if(!paramList.isEmpty()){
        lastFlag = handleFirstParam(paramList.remove(0));
      }else{
          isGood = false;
      }
      
      if(!isGood){
          return;
      }
           
      for(String param : paramList){
          if(param != null){
              if(param.startsWith("-")){
                  lastFlag = new Flag(param);
                  flags.add(lastFlag);
              }else{                 
                    lastFlag.addOption(param);
              }
          }
      }
      
      validateFlags();
      
    }
    
    private Flag handleFirstParam(String firstParam){
        Flag firstFlag = new Flag(firstParam);
        flags.add(firstFlag);
        if(firstFlag.getType() == FlagTypes.ERROR){
            isGood = false;
            errors.add("First parameter '" + firstParam + "' must be a flag.");
        }       
        return firstFlag;
    }
    
    private void validateFlags(){
        for(Flag flag : flags){
            if(!flag.getType().isSimple() && flag.getOptions().size() < 1){
                isGood = false;
                errors.add("Flag '" + flag.getType().name() + "' requires at least one option.");
            }
        }
    }
    
}
