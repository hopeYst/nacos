package cn.xbom.test.cloud.web.configruation;

import cn.xbom.test.cloud.web.error.UserErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigruation {

    @Bean
    public UserErrorDecoder userErrorDecoderInstance(){
        return new UserErrorDecoder();
    }

}
