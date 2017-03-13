package jialei.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Hello world!
 *
 */
public class KnightMain
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META_INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
