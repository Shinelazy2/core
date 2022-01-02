package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 생성자를 통해서 사용할 수 있도록함
    private final MemberRepository memberRepository;

    // 생성자 주입
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
