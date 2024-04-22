package org.demarzo;

import java.util.HashMap;
import java.util.Map;

public class Session {

    String sessionID;
    //String filepath = "./user";
    Map<String,String> map = new HashMap<String,String>();

    Session(){
        sessionID = "S_"+Long.toString(System.currentTimeMillis());
    }

    public void setField(String fieldname,String value){
        map.put(fieldname,value);
    }

    public void getValueOf(String fieldname){
        map.get(fieldname);
    }

    public String getSessionID(){
        return sessionID;
    }


}
