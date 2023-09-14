package it.sysagent.recommended.recommendedwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String nickName;

    private String gender;

    private int age;
}
