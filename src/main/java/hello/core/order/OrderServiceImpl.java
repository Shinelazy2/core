package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    // 할인정책 변경
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    @Autowired
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    // 단일책임 원칙을 잘 지킨것
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // TEST
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


//    public Order createTest(Long memberId, String itemName, int itemPrice) {
//        Member member = memberService.findMember(memberId);
//        int discountPrice = discountPolicy.discount(member, itemPrice);
//        return new Order(memberId, itemName, itemPrice, discountPrice);
//    }
}
