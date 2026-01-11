package com.vengatx.myaiapp.modelproviders.openai;

import lombok.Data;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/openai")
@RestController
public class OpenAIPromptController {


    @Autowired
    private OpenAiChatModel openAiChatModel;

    @PostMapping("/prompt/basic")
    public Generation getPromptMessage(@RequestBody OpenAIPromptParam openAIPromptParam) {
        Prompt prompt = new Prompt(openAIPromptParam.query);
        return openAiChatModel.call(prompt).getResult();
    }


    @Data
    public static class OpenAIPromptParam {
        private String query;
        private String username;
    }


}
