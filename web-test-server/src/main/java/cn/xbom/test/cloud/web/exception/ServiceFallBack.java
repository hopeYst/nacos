package cn.xbom.test.cloud.web.exception;

import cn.xbom.test.cloud.web.controller.UserCenterController;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceFallBack implements FallbackFactory<UserCenterController.UserService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceFallBack.class);
    private static final String ERRORMSG = "this interface is temporarily unavailable";

    public UserCenterController.UserService create(Throwable throwable) {

        final String msg = throwable == null ? "" : throwable.getMessage();

        if (null != msg){
            LOGGER.error(msg);
        }

        return new UserCenterController.UserService(){
            public String getUser(Integer userId) {
                LOGGER.info(msg);
                return ERRORMSG;
            }
            public String updateUser(Integer userId, String userName) {
                return ERRORMSG;
            }
            public String updaterLog(String log) {
                return ERRORMSG;
            }
        };

    }
}
