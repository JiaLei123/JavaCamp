package jialei.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JiaLei on 2017/3/12.
 */
public class MistrelKnightMain {
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META_INF/spring/mistrel.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
