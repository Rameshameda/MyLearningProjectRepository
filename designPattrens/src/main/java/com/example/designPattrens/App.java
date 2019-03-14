package com.example.designPattrens;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {App app = new App();
    	System.out.println(app.hashCode());
    	System.out.println(app.hashCode());
    	System.out.println(new App().hashCode());
    	System.out.println(new App());
        System.out.println( "Hello World!" );
        System.gc();
    }
}
