package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.dto.CommunityAllDto;
import com.ssafy.apolio.service.CommunityService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommunityController {

    private final CommunityService communityService;

    @ApiOperation(value = "유저 아이디, 제목, 내용을 입력받아서 커뮤니티 게시물을 작성한다.", response = String.class)
    @PostMapping(value = "/community")
    public ResponseEntity<String> insertCommunity(@RequestBody CommunityForm communityForm){
        System.out.println("title = " + communityForm.getTitle());
        Long check = communityService.community(communityForm.getTitle(), communityForm.getContent(), communityForm.getUser_id());
        if(check != 0){
            return new ResponseEntity<String>("community success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("community fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "커뮤니티 게시물 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/community")
    public ResponseEntity<List<CommunityAllDto>> communityList(){
        List<CommunityAllDto> communities = communityService.findCommunityAll();

        return new ResponseEntity<List<CommunityAllDto>>(communities, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호에 해당하는 커뮤니티 게시물을 조회한다.", response = Community.class)
    @GetMapping(value = "/community/{id}")
    public ResponseEntity<Community> communitySearch(@PathVariable Long id){
        Community community = communityService.findCommunity(id);

        return new ResponseEntity<Community>(community, HttpStatus.OK);
    }
    @ApiOperation(value = "게시물 번호에 해당하는 커뮤니티 게시물을 받아서 수정한다.", response = String.class)
    @PutMapping("/community/{id}")
    public ResponseEntity<String> updateCommunity(@RequestBody Community community){
        int check = communityService.updateCommunity(community);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "게시물 번호로 커뮤니티 게시물을 삭제한다.", response = String.class)
    @DeleteMapping("/community/{id}")
    public ResponseEntity<String> deleteCommunity(@PathVariable Long id){
        int check = communityService.deleteCommunity(id);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


}
