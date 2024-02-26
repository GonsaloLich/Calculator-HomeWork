package com.skypro.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator/plus")
    public String sum(@RequestParam int num1, int num2) {
        return num1 + "+" + num2 + "=" + calculatorService.sum(num1, num2);
    }

    @GetMapping("/calculator/minus")
    public String difference(@RequestParam int num1, int num2) {
        return num1 + "-" + num2 + "=" + calculatorService.difference(num1, num2);
    }

    @GetMapping("/calculator/multiply")
    public String multiplication(@RequestParam int num1, int num2) {
        return num1 + "*" + num2 + "=" + calculatorService.multiplication(num1, num2);
    }

    @GetMapping("/calculator/divide")
    public String division(@RequestParam int num1, int num2) {
        return num1 + "/" + num2 + "=" + calculatorService.division(num1, num2);
    }

    @GetMapping("/calculator")
    public String hello(){
        return calculatorService.Hello();
    }
}
