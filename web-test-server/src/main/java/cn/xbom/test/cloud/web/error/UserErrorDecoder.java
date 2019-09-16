package cn.xbom.test.cloud.web.error;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

@Component
public class UserErrorDecoder implements ErrorDecoder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Exception decode(String s, Response response) {
        logger.info("code: "+response.status());
        Exception exception = null;
        Response.Body body = response.body();
        try {
            Reader reader = body.asReader();
            String json = Util.toString(reader);
            exception = new RuntimeException(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exception;
    }

}
