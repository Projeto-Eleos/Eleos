package com.example.javawebapp;

import java.util.HashSet;

public class RestricWords {
    private static HashSet<String> restricWords;
    
    public static boolean AddWord(String word){
        try{
            restricWords.add(word);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean checkWords(String phrase){
        var words= phrase.split(" ");
        for(String word: words){
            if(restricWords.contains(word))
                return false;
        }
        return true;
    }

    public static void PopulaSet(){
        restricWords.add("cu");
        restricWords.add("c*");
        restricWords.add("puta");
        restricWords.add("p*ta");
        restricWords.add("put*");
        restricWords.add("p*t*");
        restricWords.add("crlh");
        restricWords.add("caralho");
    }
}
