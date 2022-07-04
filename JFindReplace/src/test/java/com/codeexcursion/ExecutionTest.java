/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mike
 */
public class ExecutionTest {
   private List<Flag> flagList;
    
    @Before
    public void setup(){
       flagList= new ArrayList<>();
        
    }
    
    @Test
    public void testFileFilterDefaults(){
        new Execution(flagList);
    }
}
