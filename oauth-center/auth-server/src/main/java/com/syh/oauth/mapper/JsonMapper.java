package com.syh.oauth.mapper;

/**
 * @Author jyb
 * @Date 2020/4/14 15:49
 * 依照源码自定义JsonMapper,短信认证授权使用
 */
public interface JsonMapper {
    String write(Object input) throws Exception;

    <T> T read(String input, Class<T> type) throws Exception;
}
