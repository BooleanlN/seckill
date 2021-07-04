package cn.whu.service;

/**
 * 本地缓存，Guava-cache
 * @author snow
 * @className CacheService
 * @date 2021/7/1
 **/
public interface CacheService {

    /**
     * 存储
     * @param key
     * @param value
     */
    void setCommonCache(String key,Object value);

    /**
     * 获取cache
     * @param key
     * @return
     */
    Object getFromCommonCache(String key);
}
