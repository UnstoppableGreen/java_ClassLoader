package com.java_lab4ClassLoader;
import java.lang.reflect.Method;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Compare system classloader and custom classloader." );
        try {
            Scanner in = new Scanner(System.in);
            String[] proArgs = new String[3];
            System.out.print("Enter full classname: ");
            String progClass = in.next();
		            System.out.print("Enter first parameter: ");
				            proArgs[0]=in.next(); 
				            System.out.print("Enter second parameter: ");
					            	proArgs[1]=in.next(); 
			
			CCLoader ccl = new CCLoader(App.class.getClassLoader());
			Class clas = ccl.loadClass(progClass);
			Class[] mainArgsType = { (new String[0]).getClass() };
			Method mainMethod = clas.getMethod("main", mainArgsType);
			
			Object[] argsArray = {proArgs};
			
			mainMethod.invoke(null, argsArray);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
