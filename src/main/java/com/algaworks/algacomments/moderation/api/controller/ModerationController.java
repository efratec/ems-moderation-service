package com.algaworks.algacomments.moderation.api.controller;

import com.algaworks.algacomments.moderation.api.model.CommentInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import com.algaworks.algacomments.moderation.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService service;

    @PostMapping
    public ModerationOutput moderate(@RequestBody CommentInput input) {
        return service.moderate(input);
    }

}
