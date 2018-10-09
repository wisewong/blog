package wise.wang.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wise.wang.blog.common.APIResponse;

/**
 * PortalController
 *
 * @author sage.wang
 * @date 18-10-9 下午3:17
 */
@RestController
public class PortalController {

    @RequestMapping("/test")
    public APIResponse<String> test() {
        return APIResponse.success("hello wold");
    }

}
