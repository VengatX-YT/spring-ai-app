package com.vengatx.myaiapp.modelproviders.openai;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai")
public class OpenAIController {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @GetMapping("/chat")
    public String getOpenAIChatMessage(@RequestParam("query") String query) {
        return openAiChatModel.call(query);
    }

}
