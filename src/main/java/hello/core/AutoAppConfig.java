package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
 @ComponentScan( // 예제를 위해 Configureation 제외함
        // basePackages = "hello.core.member", // 어디서부터 찾는지 지정할 수 있음.
        // basePackageClasses = AutoAppConfig.class,
        // 지정 하지 않으면 hello.core 하위 패키지
        // 프로젝트 최상단임
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
