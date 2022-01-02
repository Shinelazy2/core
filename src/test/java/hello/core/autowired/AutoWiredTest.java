package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test // 옵션처리
    void AutoWiredOption(){
        //Bean 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    // 스프링 컨테이너가 관리하지 않음
    static class TestBean {
        @Autowired(required = false) // true로 하면 예외가 터진다! 호출도 안됬다!
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
    }

    @Autowired(required = false) // 호출은 되지만 NULL로 들어간다
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }


    @Autowired(required = false) // 들어오면 Optional.empty 값이 들어간다.
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }


}
