package com.jowdev.simpleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// O DTO serve basicamente pras informacoes mais importantes ficarem serverSide
// entao quando o usuario for enviar um requisao, so precisa ter o username e a senha, nada mais
public class LoginRequest {
        private String username;
        private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
