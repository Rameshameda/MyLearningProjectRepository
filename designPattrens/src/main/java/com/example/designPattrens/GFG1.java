package com.example.designPattrens;
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInput; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutput; 
import java.io.ObjectOutputStream; 
import java.io.Serializable; 
public class GFG1  
{ 
  
    public static void main(String[] args)  
    { 
        try
        { 
            Singleton instance1 = Singleton.getObject(); 
            instance1.setName("rameshmeda");
            ObjectOutput out  
                = new ObjectOutputStream(new FileOutputStream("file.text")); 
            out.writeObject(instance1); 
            out.close(); 
          
            // deserailize from file to object 
            ObjectInput in  
                = new ObjectInputStream(new FileInputStream("file.text")); 
            Singleton instance2 = (Singleton) in.readObject(); 
            in.close(); 
          
            System.out.println("instance1 hashCode:- "
                                           + instance1.hashCode()+"--"+instance1.getName()); 
            System.out.println("instance2 hashCode:- "
                                           + instance2.hashCode()+"--"+instance2.getName()); 
        }  
          
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
    } 
} 