package com.jialei;

import com.jialei.Common.UUIDContainer;
import com.jialei.Tools.VarifyUUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        VarifyUUID varifyUUID = new VarifyUUID();
        long count = 10000000;
        varifyUUID.generateUUID(count);
        if(UUIDContainer.GetInstance().getUuidMap().keySet().size() == count){
            System.out.println( "OK" );
        }else {
            System.out.println( "Error" );
        }
    }
}
