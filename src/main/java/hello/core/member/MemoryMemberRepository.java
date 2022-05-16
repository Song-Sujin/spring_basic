package hello.core.member;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component  // memoryMemberRepository
public class MemoryMemberRepository  implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();


    // member의 값을 주면 저장하는 메소드
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    // 넘어온 memberId로 member가 누군지 찾는 메소드
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
