package cn.whu.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author snow
 * @className MyMapper
 * @date 2021/6/28
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
