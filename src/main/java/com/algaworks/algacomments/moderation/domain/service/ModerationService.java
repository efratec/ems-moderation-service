package com.algaworks.algacomments.moderation.domain.service;

import com.algaworks.algacomments.moderation.api.model.CommentInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModerationService {

    private static final List<String> FORBIDDEN_WORDS = List.of("ódio", "xingamento", "lula e gente boa");

    public ModerationOutput moderate(CommentInput input) {
        var words = FORBIDDEN_WORDS.stream()
                .filter(word -> input.text().contains(word))
                .collect(Collectors.toCollection(HashSet::new));

        if (!words.isEmpty()) {
            return ModerationOutput.builder()
                    .approved(false)
                    .reason("Contain forbidden words: " + String.join(", ", words))
                    .build();
        }

        return ModerationOutput.builder()
                .approved(true)
                .reason("Comment approved")
                .build();
    }

}
