package juun.ars.config.auth;

import juun.ars.config.auth.provider.GitUserInfo;
import juun.ars.config.auth.provider.NaverUserInfo;
import juun.ars.config.auth.provider.OAuth2UserInfo;
import juun.ars.domain.Member;
import juun.ars.domain.Role;
import juun.ars.domain.UserProfile;
import juun.ars.repository.MemberRepository;
import juun.ars.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CustomOAuth2MemberService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;
    private final MemberService memberService;



    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        System.out.println("userRequest = " + userRequest.getAccessToken().getTokenValue());
        // 구글 로그인버튼 클릭 -> 구글 로그인창 -> 로그인을 완료 -> code 를 리턴(Oauth-client 라이브러리) -> AccessToken 요청
        // userRequest 정보 -> loadUser함수 호출 -> 구글로부터 회원프로필을 받아준다.
        System.out.println("userRequest = " + userRequest.getClientRegistration());
        System.out.println("oAuth2User = " + userRequest.getAdditionalParameters());
        System.out.println("oAuth2User.getAttributes() = " + oAuth2User.getAttributes());
        System.out.println("oAuth2User.getAuthorities() = " + oAuth2User.getAuthorities());
        System.out.println("oAuth2User.getName() = " + oAuth2User.getName());

        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("github")){
            System.out.println("깃 로그인 요청");
            oAuth2UserInfo = new GitUserInfo((oAuth2User.getAttributes()));
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));



        String provider = oAuth2UserInfo.getProvider(); // google
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId; // google_1923912312312
        String password = "dodokong";
        String email = oAuth2UserInfo.getEmail();
        String role = Role.USER.getValue();



        Member member = memberRepository.findByUsername(username).get();
        if (member == null) {
            System.out.println("최초 가입");
            member = Member.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            memberService.joinUserWithMember(member);
        }else {
            System.out.println("이미 가입한 적이 있습니다.");
        }
        return new PrincipalDetails(member, oAuth2User.getAttributes());
    }
}