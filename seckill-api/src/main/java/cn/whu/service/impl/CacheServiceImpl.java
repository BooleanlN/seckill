package cn.whu.service.impl;

import cn.whu.service.CacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author snow
 * @className CacheServiceImpl
 * @date 2021/7/1
 **/
@Service
public class CacheServiceImpl implements CacheService {

    private Cache<String,Object> commonCache = null;


    @PostConstruct
    public void init(){
        commonCache = CacheBuilder.newBuilder()
                .initialCapacity(10) // 设置缓存初始容量
                .maximumSize(100) // 设置最大可以存储100KEY，超出100则LRU移除
                .expireAfterWrite(60, TimeUnit.SECONDS)// 设置写缓存后xx秒过期
                .build();
    }
    /**
     * 存储
     *
     * @param key
     * @param value
     */
    @Override
    public void setCommonCache(String key, Object value) {
        commonCache.put(key,value);
    }

    /**
     * 获取cache
     *
     * @param key
     * @return
     */
    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }
}
