package com.linjia.tools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/** 
 *  java日期对象经过Jackson库转换成JSON日期格式化自定义类 
 * @author xiangsy 
 * @date 2016-7-20
 */  
public class DateSerializeUtils extends JsonSerializer<Date> {

	@Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {  
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            String formattedDate = formatter.format(value);  
            jgen.writeString(formattedDate);  
    }  
}
