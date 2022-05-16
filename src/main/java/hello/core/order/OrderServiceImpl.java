package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    // MemberRepository여기에서 일단 회원을 찾아야하니까 이게 필요하고
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 고정할인 정책을 가져와야하니가 이것도 필요함
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 이렇게 변경하면 RateDiscountPolicy로 갈아끼울 수 있음. 하지만 이것은 dip위반이 됨. OrderServiceImpl 코드를 변경하기 때문
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 그래서 이렇게만 하면 interface에만 의존하게 된다.
    private MemberRepository memberRepository;    // final로 되어있으면 기본으로 할당이 되어야 한다. 생성자로
    private DiscountPolicy discountPolicy;

    /*public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 회원정보를 먼저 조회를 하고
        Member member = memberRepository.findById(memberId);
        // 할인 정책에 회원을 그냥 넘겨버린다
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // OrderServiceImpl은 오직 주문에 대해서만 한다. 할인에 대한거는 discountPocicy가 담당할거니까 그냥 member를 넘기면 됨

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
