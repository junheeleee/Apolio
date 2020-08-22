package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회문은 true로 해야 성능이 좋다. 기본 값은 false
@RequiredArgsConstructor // final인 필드만 가지고 생성자를 만들어 줌. 결론적으로 Autowired가 된다. lombok 기능
public class UserService {

    private final AccountRepository accountRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user); //중복 회원 검증
        accountRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findUser = accountRepository.findByEmail(user.getEmail());
        if (!findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<User> findUser() {
        return accountRepository.findAll();
    }

    public User findOne(Long userId) {
        return accountRepository.findOne(userId);
    }
}
