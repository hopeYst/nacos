package cn.xbom.test.cloud.impl;

import cn.xbom.test.cloud.api.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping(path = "/api")
public class UserService implements IUserService {


    int count = 0;
    @Override
    public String getUser(Integer userId) {
        System.out.println(count);
        count++;
        return "get user:" + userId;
    }

    @Override
    public String updateUser( Integer userId, String userName) {
        return "update user:" + userId + "-->" + userName;
    }


    @Override
    public String updaterLog(@RequestBody  String log) {
        return "Update Log:" + log;
    }


}
