package cn.xbom.test.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefershConfig {

    @Value("${didispace.title:}")
    private String url;


    @GetMapping("/getSSL")
    public String getUrl(){
        return url;
    }

}
