package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    //Test 실행전 무조건 실행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given ~ 이러한 주어졌을떄
        Member member = new Member((1L), "memberA", Grade.VIP);
        Member member2 = new Member((2L), "memberB", Grade.VIP);

        //when ~ 이렇게 했을떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then ~ 이렇게 된다
        System.out.println(member);
        System.out.println(findMember);
        System.out.println(member2);

//        Assertions.assertThat(member).isEqualTo(findMember);
//        Assertions.assertThat(member2).isEqualTo(findMember);
    }
}