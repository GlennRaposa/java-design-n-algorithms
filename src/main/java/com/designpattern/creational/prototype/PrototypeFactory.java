package com.designpattern.creational.prototype;
//http://howtodoinjava.com/design-patterns/creational/prototype-design-pattern-in-java/
/*
 * A prototype is a template of any object before the actual object is constructed. In java also, 
 * it holds the same meaning. Prototype design pattern is used in scenarios where application needs to 
 * create a number of instances of a class, which has almost same state or differs very little.
 */
import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
	
	public static class ModelType
    {
        public static final String MOVIE = "movie";
        public static final String ALBUM = "album";
        public static final String SHOW = "show";
    }
	
	private static Map<String, PrototypeCapable> prototypeMap = new HashMap<String, PrototypeCapable>();
	
	
	static{
		prototypeMap.put(ModelType.MOVIE, new Movie());
		prototypeMap.put(ModelType.ALBUM, new Album());
		prototypeMap.put(ModelType.SHOW, new Show());
	}
	
	public static PrototypeCapable getInstance(String type) throws CloneNotSupportedException{
		return (PrototypeCapable)prototypeMap.get(type).clone();
	}
	
	public static void main(String[] args)
    {
        try
        {
            String moviePrototype  = PrototypeFactory.getInstance(ModelType.MOVIE).toString();
            System.out.println(moviePrototype);
 
            String albumPrototype  = PrototypeFactory.getInstance(ModelType.ALBUM).toString();
            System.out.println(albumPrototype);
 
            String showPrototype  = PrototypeFactory.getInstance(ModelType.SHOW).toString();
            System.out.println(showPrototype);
 
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
