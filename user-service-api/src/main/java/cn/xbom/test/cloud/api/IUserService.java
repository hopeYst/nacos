package cn.xbom.test.cloud.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "User-Service")
public interface IUserService {

    @GetMapping("/user/{userId}")
    String getUser(@RequestParam(value = "userId") Integer userId);

    @PostMapping("/user/{userId}")
    String updateUser(@PathVariable("userId")Integer userId, @RequestParam("userName") String userName);

    @PostMapping(value = "/log")
    String updaterLog(@RequestBody String log);



}
