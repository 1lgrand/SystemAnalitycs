package org.demarzo;

public class Main {
    public static void main(String...args){
        Session s = new Session();
        System.out.println(s.getSessionID());
        MainApp.main(args);
    }
}
