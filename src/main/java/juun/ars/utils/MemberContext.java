package juun.ars.utils;

import juun.ars.domain.Member;

public class MemberContext {
    public static ThreadLocal<Member> currentMember = new ThreadLocal<>();
}