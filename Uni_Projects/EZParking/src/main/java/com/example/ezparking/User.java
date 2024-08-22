package com.example.ezparking;

public class User {
    public String nome;
    public String email;
    public int contacto;
    public String estatuto;
    public String subscricao;
    public String plano;
    public String fimSubscricao;
    public User(String name, String mail, int contact, String status, String subscription, String plan, String endDate){
        this.nome = name;
        this.email = mail;
        this.contacto = contact;
        this.estatuto = status;
        this.subscricao = subscription;
        this.plano = plan;
        this.fimSubscricao = endDate;
    }

    @Override
    public String toString(){
        return "Nome " + this.nome + " Email " + this.email + " Contacto " + this.contacto + " Estatuto " + this.estatuto
                + " Subscrição " + this.subscricao + " Plano " + this.plano + " Fim da Subscrição " + this.fimSubscricao;
    }
}
