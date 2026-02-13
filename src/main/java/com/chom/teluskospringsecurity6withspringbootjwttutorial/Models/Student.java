package com.chom.teluskospringsecurity6withspringbootjwttutorial.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Student {
    Integer id;
    String username;
    Integer age;
    Integer clase;
}
