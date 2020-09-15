/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.words;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author refresh.jss
 */
public class Word {
    private String level;
    private String name;
    private ArrayList library;
    
    public Word(String name, String level) {
        this.level = level;
        this.name = name;
        try {
            initLibrary();
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initLibrary() throws FileNotFoundException, IOException {
        this.library = new ArrayList<String>();
        try (FileReader reader = new FileReader(this.name+".txt")) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                library.add(scanner.nextLine());
            }
            reader.close();
        }
    }
    
    public String getLevel(){
        return this.level;
    }
    
    public String getWord(){
        return this.name;
    }
    
    public ArrayList getLibrary() {
        return this.library;
    }
}
