package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestCOnfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        // 10000원 사용
        statefulService1.order("userA", 10000);

        // 20000원 사용
        statefulService.order("userB", 20000);

        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    static class TestCOnfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}