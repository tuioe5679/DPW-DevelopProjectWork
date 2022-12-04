package com.tuioe.Develop.Project.Work.controller;

import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import com.tuioe.Develop.Project.Work.dto.tag.TagListResponseDto;
import com.tuioe.Develop.Project.Work.dto.tag.TagRequestDto;
import com.tuioe.Develop.Project.Work.dto.tag.TagUpdateDto;
import com.tuioe.Develop.Project.Work.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Swagger API 명세서 페이지 -> http://localhost:8080/swagger-ui/index.html#/
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Api(value = "Tag Controller",tags = "Tag")
public class TagController {

    private final TagService tagService;

    @ApiOperation(value = "태그 목록 조회",notes = "작성된 모든 태그를 조회합니다")
    @GetMapping("/tag")
    public ResponseEntity<List<TagListResponseDto>> findAll(){
        return new ResponseEntity<>(tagService.findAllTag(), HttpStatus.OK);
    }

    @ApiOperation(value = "태그 생성",notes = "태그를 작성합니다")
    @PostMapping("/tag")
    public ResponseEntity<Tag> save(@RequestBody TagRequestDto dto){
        return new ResponseEntity<>(tagService.createTag(dto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "태그 수정",notes = "태그를 수정합니다")
    @PutMapping("/tag/{id}")
    public ResponseEntity<Tag> update(@PathVariable Long id, @RequestBody TagUpdateDto dto){
        return new ResponseEntity<>(tagService.updateTag(id,dto), HttpStatus.OK);
    }

    @ApiOperation(value = "태그 삭제",notes = "태그를 삭제합니다")
    @DeleteMapping("/tag/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(tagService.deleteTag(id), HttpStatus.OK);
    }

}
