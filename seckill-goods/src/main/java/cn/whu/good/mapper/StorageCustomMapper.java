package cn.whu.good.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author snow
 * @className StorageCustomMapper
 * @date 2021/7/4
 **/
@Repository
public interface StorageCustomMapper {
    public int decreaseStock(String goodId, Long consumeCount);
}
