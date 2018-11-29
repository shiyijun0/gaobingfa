package cn.bdqn.gaobingfa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/*@Configuration
@ComponentScan(basePackages = {"cn.bdqn.gaobingfa.config"})
@EnableWebMvc*/
public class WebFileConfig {

	@Bean(name = "multipartResolver")
	public MultipartResolver initMultipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	/**
	@Bean(name = "multipartResolver")
	public MultipartResolver initCommonsMultipartResolver() {
		//文件上传路径
		String filepath = "e:/mvc/uploads";
		//5MB
		Long singleMax = (long) (5 * Math.pow(2, 20));
		//10MB
		Long totalMax = (long) (10 * Math.pow(2, 20));
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSizePerFile(singleMax);
		multipartResolver.setMaxUploadSize(totalMax);
		try {
			multipartResolver.setUploadTempDir(new FileSystemResource(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multipartResolver;
	}
	*/
}
