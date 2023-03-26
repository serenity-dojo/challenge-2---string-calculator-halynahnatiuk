package com.serenitydojo.calculator;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {

    public int evaluate(String expression)  {

        if (expression.isEmpty()) {
            return 0;
        }
        List<String> tokens = Splitter.on(" ").splitToList(expression);

        int totalAmount = 0;
        String nextOperator = "+";

        for (String token:tokens){
            if (!isNumeric(token)){
                nextOperator = token;
            }
            else totalAmount= process(totalAmount, nextOperator, token);
        }
        return totalAmount;

    }

    private int process(int totalAmount, String nextOperator, String token) {
        switch (nextOperator){
            case "+":
                return totalAmount + Integer.parseInt(token);
            case "-":
                return totalAmount - Integer.parseInt(token);
            case"*":
                return totalAmount * Integer.parseInt(token);
            default:
                throw new IllegalMathsOperatorException("Unsupported operator " + nextOperator);
        }

    }
}
