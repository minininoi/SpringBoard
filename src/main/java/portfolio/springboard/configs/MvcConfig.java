package portfolio.springboard.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import portfolio.springboard.configs.interceptors.SiteConfigInterceptor;

@Configuration
@RequiredArgsConstructor
@EnableJpaAuditing //이벤트 감지를 위한 활성화
public class MvcConfig implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private String fileUploadPath;

    /**사이크 설정 유지 인터셉터*/
    private final SiteConfigInterceptor siteConfigInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/")
               .setViewName("main/index");
    }

    /**
     * 정적 경로 설정(fileUploadPath)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/uploads/**")
               .addResourceLocations("file:///" + fileUploadPath);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(siteConfigInterceptor)
                .addPathPatterns("/**");
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.commons","messages.validations","messages.errors");

        return ms;
    }

    @Bean
    public HiddenHttpMethodFilter HttpMethodFilter(){ //GET, POST 이외에 DELETE, PATCH, PUT 등을 사용할 수 있게 해준다
        return  new HiddenHttpMethodFilter();
    }
}
