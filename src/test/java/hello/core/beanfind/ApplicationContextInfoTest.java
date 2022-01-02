package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findALlBean(){
        String[] beanStrings = ac.getBeanDefinitionNames();
        for (String beanS : beanStrings) {
            Object bean = ac.getBean(beanS);
            System.out.println("name = "+ beanStrings + "object = " + bean);
        }
    }

    @Test
    @DisplayName("내가 만든 애플리케이션 빈")
    void findApplicationBean(){
        String[] beanStrings = ac.getBeanDefinitionNames();
        for (String beanS : beanStrings) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanS);

            // ROLE_APPLICATION -> 직접 등록한 빈
            // ROLE_INFRASTRUCTRUE -> 스프링 내부에서 사용 하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanS);
                System.out.println("name = "+ beanStrings + "object = " + bean);
            }
        }
    }

}




