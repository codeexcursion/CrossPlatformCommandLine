/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Mike
 */
public class ParseParametersTest {
    
    
    
    @Test
    public void testNullParams(){
        ParseParameters parseParams = new ParseParameters(null);
        Assert.assertFalse(parseParams.isGood());
    } 
    
    @Test
    public void testNoParams(){
        ParseParameters parseParams = new ParseParameters(new String[0]);
        Assert.assertFalse(parseParams.isGood());
    } 
    
    @Test
    public void testFirstNotFlag(){
        String[] params = {"notaflag"};
        ParseParameters parseParams = new ParseParameters(params);
        Assert.assertFalse(parseParams.isGood());
    } 
    
    @Test
    public void testFirstIsFlag(){
        String[] params = {"-find","something"};
        ParseParameters parseParams = new ParseParameters(params);
        Assert.assertTrue(parseParams.isGood());
        Assert.assertEquals(1,parseParams.getFlags().size());
    } 
    
    @Test
    public void testFlagNoOption(){
        String[] params = {"-find"};
        ParseParameters parseParams = new ParseParameters(params);
        Assert.assertFalse(parseParams.isGood());
        Assert.assertEquals(1,parseParams.getFlags().size());
        Assert.assertEquals(1,parseParams.getErrors().size());
    } 
}
