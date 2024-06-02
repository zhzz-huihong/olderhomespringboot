package org.example.utils;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author haoren
 * @date 2024/06/02 16:07
 **/
public class BeanUtils {

    public static <T> T copy(Object source, Class<T> clazz) {
        T target = null;
        try {
            target = clazz.getDeclaredConstructor().newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    public static <T> List<T> copyList(Collection<?> source, Class<T> clazz) {
        if(source == null ){
            return Collections.emptyList();
        }
        List<T> target = Lists.newArrayList();
        try {
            target = source.stream().map(item -> copy(item, clazz)).toList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}
