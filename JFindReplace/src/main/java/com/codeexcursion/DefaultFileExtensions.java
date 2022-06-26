/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeexcursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class DefaultFileExtensions {
    private static List<String> fileExtensions = new ArrayList<>();
    static{
        fileExtensions.add("*.txt");
        fileExtensions.add("*.xml");
        fileExtensions.add("*.conf");
        fileExtensions.add("*.java");
        fileExtensions.add("*.xsd");
        fileExtensions.add("*.wsdl");
        fileExtensions.add("*.c");
        fileExtensions.add("*.csv");
        fileExtensions.add("*.bat");
        fileExtensions.add("*.ps1");
        fileExtensions.add("*.sh");
        fileExtensions.add("*.groovy");        
    }
    
    public static List<String> getFileExtensions(){
        return fileExtensions;
    }
}
