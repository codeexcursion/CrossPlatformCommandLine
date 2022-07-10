/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Mike
 */
public class MatchTest {
    
    private String testText = 
            "This is a windows text. Blah blah blah.\n" +
            "Regular expressions are cool. \n" +
            "This is a windows text. Blah blah blah.\n" +
            "Regular expressions are cool. ";
    
    @Test
    public void testMatches(){
        Pattern p = Pattern.compile("cool");
        Matcher m = p.matcher(testText);
        int count = 0;
        while(m.find()){
            System.out.println(testText.substring(m.start(), m.end()));
            count++;
        }
        
        Assert.assertEquals(2,count);
        
        
    }
}
