package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.domain.user.Role;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.dto.CommunityAllDto;
import com.ssafy.apolio.repository.CommunityRepository;
import com.ssafy.apolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Long community(String title, String content, String user_id) {

        Optional<User> user = userRepository.findById(Long.parseLong(user_id));
        Community community = Community.createCommunity(title, content, user.get());
        communityRepository.save(community);
        return community.getId();
    }

    public List<CommunityAllDto> findCommunityAll() {
        List<Community> communities = communityRepository.findAll();
        ArrayList<CommunityAllDto> result = new ArrayList<>();
        for ( Community community : communities ) {
            CommunityAllDto communityAllDto = new CommunityAllDto();
            communityAllDto.setTitle(community.getTitle());
            communityAllDto.setCreate_at(community.getCreate_date());
            communityAllDto.setEmail(community.getUser().getEmail());
            communityAllDto.setContent(community.getContent());
            result.add(communityAllDto);
        }
        return result;
    }

    public Community findCommunity(Long community_id) {
        return communityRepository.findOne(community_id);
    }
    @Transactional
    public int updateCommunity(Community community){
        return communityRepository.updateCommunityById(community);
    }

    @Transactional
    public int deleteCommunity(Long id){
        return communityRepository.deleteCommunityById(id);
    }


}
