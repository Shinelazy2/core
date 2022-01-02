package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
// 아직 DB 안정해짐
public class MemoryMemberRepository implements MemberRepository{

    // 동시성 문제가 발생할 수 있음.
    // store == DB 저장소
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        // getId == id
        // member == 모든 정보
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
