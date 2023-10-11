package com.example.javawebapp;

import java.util.HashSet;

public class RestricWords {
    private static HashSet<String> restricWords = new HashSet<String>();  
    public RestricWords(){

        restricWords.add("teste");
    }

    public static boolean AddWord(String word){
        try{
            restricWords.add(word);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean checkWords(String phrase){
        var words= phrase.split(" ");
        for(String word: words){
            if(restricWords.contains(word))
                return false;
        }
        return true;
    }

    public static void PopulaSet(){
        
    }
}
