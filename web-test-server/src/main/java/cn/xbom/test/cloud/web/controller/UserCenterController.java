package cn.xbom.test.cloud.web.controller;

import cn.xbom.test.cloud.api.IUserService;
import cn.xbom.test.cloud.web.configruation.FeignConfigruation;
import cn.xbom.test.cloud.web.exception.ServiceFallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;


@RestController
@Slf4j
public class UserCenterController {

    @Autowired(required = false)
    protected UserService userService;

    @GetMapping("/web/user")
    public String regUser() {
        int userId = new Random().nextInt();
        String userName = UUID.randomUUID().toString();

        StringBuilder sb = new StringBuilder();
        sb.append("UserId:" + userId + "\r\n");
        sb.append("GetUser:" + userService.getUser(userId) + "\r\n");
        sb.append("UpdateUser:" + userService.updateUser(userId, userName) + "\r\n");
        sb.append("DeleteUser:" + userService.updaterLog(userId+"") + "\r\n");
        return sb.toString();
    }



    @GetMapping("/web/callBack")
//    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String fallBack(){
        return userService.getUser(2323);
    }

    @FeignClient(name = "User-Service", path = "/api",fallbackFactory =  ServiceFallBack.class, configuration = {FeignConfigruation.class})
    public interface UserService extends IUserService {
    }


//    private String errorCallBack(){
//        return "this Service break";
//    }


//    public List<String> batchCommand(Integer userId){
//        userService.getUser(userId);
//    }
}
