package com.sap.calcacademy;

public class RecursiveCalc {
  
  
  private class Result {
    int idx;
    double value;
  }
 
  
  public double calculate(String expression) throws Exception {
    return calc(expression).value;
    
  }

  public Result calc(String expression) throws Exception {
    Result result = new Result();
    Number oper = null;
    int sign = 1;
    char modOperation = 0;
    char[] expr = expression.toCharArray();
    int i = 0;
    for (;i < expr.length && expr[i] != ')'; ++i) {
      char c = expr[i];
      if (Character.isDigit(c)) {
        double val = Character.digit(c, 10);
        oper = calculateOperand(oper, modOperation, val);
        modOperation = 0;
      } else if (c == '(') {
        Result midRes = calc(expression.substring(i + 1));
        oper = calculateOperand(oper, modOperation, midRes.value);
        i += midRes.idx;
      } else if (isAddOrSubstract(c)) {
        if (oper != null) {
          result.value += sign * oper.doubleValue();
          oper = null;
        }
        sign = (c == '-') ? -1 : 1;
      } else {
        modOperation = c;
      }

    }
    result.value += sign * oper.doubleValue();
    result.idx = i + 1;
    return result;
  }

  private double calculateOperand(Number oper, char modOperation, double val) throws Exception {
    return (oper == null || modOperation == 0) ? val : execute(oper.doubleValue(), val, modOperation);
  }

  private boolean isAddOrSubstract(char oper) {
    return oper == '+' || oper == '-';
  }

  private double execute(double oper1, double oper2, char operation) throws Exception {
    switch (operation) {
    case '*':
      return oper1 * oper2;
    case '/':
      return oper1 / oper2;
    default:
      throw new Exception("Wrong operation");
    }
  }
}
