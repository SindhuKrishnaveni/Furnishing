package com.niit.BackEnd1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context= new AnnotationConfigApplicationContext(DBConfig.class);
        
       	
	 	
    }
    }

