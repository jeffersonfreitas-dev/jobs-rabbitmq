package br.com.jeffersonfreitas.dto;


import java.io.Serializable;

public class MessageDTO implements Serializable {

    private String name;
    private String phone;
    private String text;

    public MessageDTO(){}

    public MessageDTO(String name, String phone, String text){
        this.name = name;
        this.phone = phone;
        this.text = text;
    }

    public String getName() {
      return name;
    }

    public String getPhone() {
      return phone;
    }

    public String getText() {
      return text;
    }
}
