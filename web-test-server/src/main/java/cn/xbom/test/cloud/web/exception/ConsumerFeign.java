package cn.xbom.test.cloud.web.exception;

import cn.xbom.test.cloud.api.IUserService;
import cn.xbom.test.cloud.web.controller.UserCenterController;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFeign implements UserCenterController.UserService {


    public String getUser(Integer userId) {
        return "consumer id: "+userId;
    }

    public String updateUser(Integer userId, String userName) {
        return "consumer name: "+userName;
    }


    public String updaterLog(String log) {
        return "consumer log: "+log;
    }
}
