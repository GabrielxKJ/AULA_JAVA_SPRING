package com.fatecrl.contacorrente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

@GetMapping("/obter")
public String getMethodName(@RequestParam String param) {
    return "";
}
    


}
