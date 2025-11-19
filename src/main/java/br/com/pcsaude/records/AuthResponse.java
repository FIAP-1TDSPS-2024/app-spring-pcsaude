package br.com.pcsaude.records;

import java.util.List;

public record AuthResponse(String token,
                           String email,
                           List<String> roles) {

    private final static String TYPE = "Bearer";

    public String type() {
        return TYPE;
    }
}
