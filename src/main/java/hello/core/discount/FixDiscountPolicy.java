package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;   // 1000원 할인

    @Override
    public int discount(Member member, int price) {

        // vip 회원일 경우 1000원 할인 아니면 할인 없음
        if (member.getGrade() == Grade.VIP) {   // enum일 경우 ==으로 비교해야 함
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
