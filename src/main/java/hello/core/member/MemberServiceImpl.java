package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 하지만 이 코드는 MemberRepository는 인터페이스를 의존한다. 하지만 실제 할당하는 MemoryMemberRepository가 구현체를 의존하기 때문에 문제..
    // 따라서 MemberServiceImpl은 MemberRepository도 의존하고 MemoryMemberRepository도 의존하게 된다. (추상화에도 의존, 구체화에도 의존) -> DIP 위반
    // 이 코드는 마치 배우가 직접 담당 배우를 섭외하는거랑 같은 것이다. 이런거는 이제 AppConfig에서 다 하는것이다.

    private final MemberRepository memberRepository;

    // 생성자를 통해서 MemberRepository에 구현체가 뭐가 들어갈지를 선택할 것이다.
    @Autowired  // ac.getBean(MemberRepository.class) 자동으로 이 코드가 들어간다고 보면 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // join 메소드를 호출하게 되면 다형성에 의해서 MemberRepository가 아니라 MemoryMemberRepository에 있는 save가 호출된다
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
