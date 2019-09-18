package cn.xbom.test.cloud.api.utils;

import cn.xbom.test.cloud.api.dto.ManufacturerDTO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convert<S,T> {

//    private BeanCopier beanCopier = BeanCopier.create();
    private Convert(){}

    public T copier(S source, Class<T> target) throws IllegalAccessException, InstantiationException {
        T t = target.newInstance();
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target, false);
        beanCopier.copy(source, t, null);

        return t;
    }

    public List<T> copierList(List<S> source, Class<T> targetType) throws IllegalAccessException, InstantiationException {
        BeanCopier beanCopier = BeanCopier.create(source.get(0).getClass(), targetType, false);
        ArrayList<T> result = new ArrayList<T>(100);
        for(S s: source){
            T t = targetType.newInstance();
            beanCopier.copy(s, t, null);
            result.add(t);
        }
        return result;
    }

    public static Convert buildConvert(){
        return new Convert();
    }

}
