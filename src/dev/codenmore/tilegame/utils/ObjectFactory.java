package dev.codenmore.tilegame.utils;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.entities.statics.*;

public class ObjectFactory
{
    public static Entity getObject(String objType, Handler handler, int x, int y){
        if(objType == null){
            return null;
        }
        if(objType.equalsIgnoreCase("Briosa")) {
            return new Briosa1(handler,x,y);
        }
        if(objType.equalsIgnoreCase("Ceasca")) {
            return new Ceasca(handler,x,y);
        }
        if(objType.equalsIgnoreCase("CartiDeJoc")) {
            return new CartiDeJoc(handler,x,y);
        }
        if(objType.equalsIgnoreCase("Lingura")) {
            return new Lingura(handler,x,y);
        }
        if(objType.equalsIgnoreCase("Pahar")) {
            return new Pahar(handler,x,y);
        }
        return null;
    }
}
