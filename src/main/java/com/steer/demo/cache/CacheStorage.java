package com.steer.demo.cache;

import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-10 18:55
 */
@Component
public class CacheStorage {
    private static Map<Long, Set<String>> formMap = Collections.synchronizedMap(new HashMap<>());

    public void addForm(Long userId,String formId){
        if (formMap.containsKey(userId)){
            formMap.get(userId).add(formId);
        }else{
            formMap.put(userId,new HashSet<>(Arrays.asList(formId)));
        }
    }

    /**
     * 订单完成，清除订单缓存;  过期时间的设置
     * @param userId
     * @param formId
     */
    public void removeByForm(Long userId,String formId){
        if (formMap.containsKey(userId)){
            formMap.get(userId).remove(formId);
        }
    }

    public void clearByUser(Long userId){
        if (formMap.containsKey(userId)){
            formMap.remove(userId);
        }
    }

    public void clearAll(){
        formMap.clear();
    }
}
