package com.matheus.pedidos.exception;

import java.time.LocalDateTime;

public class ErroResposta {

    private int status;
    private String erro;
    private String campo;
    private String mensagem;
    private LocalDateTime timestamp;

    public ErroResposta(int status, String erro, String campo,
                        String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.erro = erro;
        this.campo = campo;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}