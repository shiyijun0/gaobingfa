package cn.bdqn.gaobingfa.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@Configuration
public class WebConfig extends AsyncConfigurerSupport {

    /**
     * 初始化RequestMappingHandlerAdapter，并加载Http的Json转换器
     * @return  RequestMappingHandlerAdapter 对象
     */
    /*@Bean(name="requestMappingHandlerAdapter")
    public HandlerAdapter initRequestMappingHandlerAdapter() {
        //创建RequestMappingHandlerAdapter适配器
        RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
        //HTTP JSON转换器
        MappingJackson2HttpMessageConverter jsonConverter
                = new MappingJackson2HttpMessageConverter();
        //MappingJackson2HttpMessageConverter接收JSON类型消息的转换
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(mediaType);
        //加入转换器的支持类型
        jsonConverter.setSupportedMediaTypes(mediaTypes);
        //往适配器加入json转换器
        rmhd.getMessageConverters().add(jsonConverter);
        return rmhd;
    }*/


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
