package hello;

import com.xiaomi.xmpush.server.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import push.PushManagerInstance;

import java.util.Arrays;

/**
 * Created by long on 2017/4/21.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("aaaaaaa---"+beanName);
        }
//
//        try {
//            PushManagerInstance.getInstance().sendMessage();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
