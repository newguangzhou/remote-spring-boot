package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by long on 2017/4/24.
 */
@RestController
public class HelloController {
    @RequestMapping("/user/get_verify_code")
    public String greeting() {
        return "{\n" +
                "\t\"status\": 0,\n" +
                "\t\"code\": \"080604\",\n" +
                "\t\"next_req_interval\": 60\n" +
                "}";
    }

    @RequestMapping("/")
    public String second() {
        return "{\n" +
                "\t\"status\": 0,\n" +
                "\t\"code\": \"080604\",\n" +
                "\t\"next_req_interval\": 60\n" +
                "}";
    }
}
