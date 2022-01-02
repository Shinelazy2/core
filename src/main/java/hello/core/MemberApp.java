package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        // AppConfig 안에 있는 @Bean 들을 관리함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 이름 / 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        // join이 동작하는지 확인
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + member.getName()); //
        System.out.println("new member = " + findMember.getName());

    }
}
