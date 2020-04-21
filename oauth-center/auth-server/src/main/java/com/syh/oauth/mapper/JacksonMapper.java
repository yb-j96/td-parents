package com.syh.oauth.mapper;

/**
 * @Author jyb
 * @Date 2020/4/14 10:34
 */
public class JacksonMapper implements JsonMapper {
    private org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();

    @Override
    public String write(Object input) throws Exception {
        return mapper.writeValueAsString(input);
    }

    @Override
    public <T> T read(String input, Class<T> type) throws Exception {
        return mapper.readValue(input, type);
    }
}
