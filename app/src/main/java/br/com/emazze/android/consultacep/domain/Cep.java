package br.com.emazze.android.consultacep.domain;

import com.google.gson.annotations.SerializedName;


public class Cep {

    private int status;
    @SerializedName("district")
    private String bairro;
    @SerializedName("code")
    private String cep;
    @SerializedName("city")
    private String cidade;
    @SerializedName("state")
    private String estado;
    @SerializedName("address")
    private String endereco;


    public Cep(int status, String bairro, String cep, String cidade, String estado, String endereco) {
        this.status = status;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
