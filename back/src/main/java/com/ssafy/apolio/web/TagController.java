package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

//    @GetMapping(value = "/tag/new")
//    public String createForm(Model model) {
//        model.addAttribute("form", new TagForm());
//        return "tag/createTagForm";
//    }

//    @PostMapping(value = "/tag/new")
//    public String create(TagForm form) {
//        Tag tag = new Tag();
//        tag.setName(form.getName());
//        tagService.saveTag(tag);
//        return "redirect:/tags";
//    }
    @ApiOperation(value = "태그 이름을 입력 받아서 태그 리스트에 저장한다", response = String.class)
    @PostMapping(value = "/tag")
    public ResponseEntity<String> createTag(@RequestBody Tag tag){
        tagService.saveTag(tag);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    /**
     * 태그 목록
     */
//    @GetMapping(value = "/tags")
//    public String list(Model model) {
//        List<Tag> tags = tagService.findTags();
//        model.addAttribute("tags", tags);
//        return "tag/tagList";
//    }
    @ApiOperation(value = "태그 리스트에 있는 모든 태그들을 조회한다", response = List.class)
    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tag>> tagList(){
        List<Tag> tags = tagService.findTags();
        return new ResponseEntity<List<Tag>>(tags, HttpStatus.OK);
    }
}
