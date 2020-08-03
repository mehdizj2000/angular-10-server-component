package au.com.mehdi.hib;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MehdiHibSampleApplication {

    public static void main(String[] args) {
	SpringApplication.run(MehdiHibSampleApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();

	config.setAllowCredentials(true);
	config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	config.setAllowedMethods(Arrays.asList("*"));
	config.setAllowedHeaders(Arrays.asList("*"));
	source.registerCorsConfiguration("/**", config);

	CorsFilter sourceFilter = new CorsFilter(source);
	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(sourceFilter);
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

	return bean;
    }

}
