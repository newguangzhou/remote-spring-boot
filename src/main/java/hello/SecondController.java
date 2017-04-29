package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by long on 2017/4/29.
 */
@RestController
public class SecondController {
    @RequestMapping("/second")
    public String second() {
        return "hello";
    }
}
