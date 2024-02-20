package dev.jeffersonfreitas.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {

    private String name;
    private String phone;
    private String text;
}
