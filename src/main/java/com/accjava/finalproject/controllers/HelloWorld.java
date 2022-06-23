package com.accjava.finalproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
  
  @GetMapping("/")
  public String helloworld() {
    return "Olá Mundo";
  }
}
