package com.example.casadecambio.cadastro.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    public static final String CPF_JA_CADASTRADO = "O CPF informado já está cadastrado no sistema";
    public static final String CPF_INVALIDO = "O CPF informado é inválido";
    public static final String CLIENTE_NAO_ECONTRADO = "O CPF informado não foi encontrado na base de dados";

    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
