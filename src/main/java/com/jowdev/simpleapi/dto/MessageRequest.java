package com.jowdev.simpleapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
// O DTO serve basicamente pras informacoes mais importantes ficarem serverSide
// entao quando o usuario for enviar um requisao, so precisa ter o username e a senha, nada mais
public  class MessageRequest {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}