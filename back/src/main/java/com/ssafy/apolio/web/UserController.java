package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.exception.ResourceNotFoundException;
import com.ssafy.apolio.repository.AccountRepository;
import com.ssafy.apolio.repository.UserRepository;
import com.ssafy.apolio.security.CurrentUser;
import com.ssafy.apolio.security.UserPrincipal;
import com.ssafy.apolio.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "유저 이름, 비밀번호, 이메일, 닉네임, 프로필 사진을 입력받아서 회원가입을 완료시킨다.", response = String.class)
    @PostMapping(value = "/user")
    public ResponseEntity<String> createUser(@RequestBody UserForm userForm){
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        user.setEmail(userForm.getEmail());
        user.setPicture(userForm.getPicture());
        user.setNickname(userForm.getNickname());
        user.setRole(userForm.getRole());
        user.setProvider(userForm.getAuthProvider());
        Long check = userService.join(user);
        if(check != 0){
            return new ResponseEntity<String>("user success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("user fail", HttpStatus.NO_CONTENT);

    }
    @ApiOperation(value = "유저 리스트 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> userList(){
        List<User> users = userService.findUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @ApiOperation(value = "유저 번호를 입력받아서 해당하는 유저 정보를 조회한다", response = User.class)
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> userDetail(@PathVariable Long id){
        User user = userService.findOne(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/user/me")
    @PreAuthorize("isAuthenticated()")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println("/user/me");
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

}
