package com.sap.calcacademy;

public class RecursiveCalc {

  public double calculate(String expression) throws Exception {
    double result = 0;
    Number oper = null;
    int sign = 1;
    char modOperation = 0;

    char[] expr = expression.toCharArray();
    for (int i = 0; i < expr.length && expr[i] != ')'; ++i) {
      char c = expr[i];
      if (Character.isDigit(c)) {
        double val = Character.digit(c, 10);
        oper = calculateOperand(oper, modOperation, val);
        modOperation = 0;
      } else if (c == '(') {
        oper = calculateOperand(oper, modOperation, calculate(expression.substring(i + 1)));
        int idx = expression.indexOf(')', i);
        if (idx == -1)
          throw new Exception("Wrong parentesis count");
        i = idx;
      } else if (isAddOrSubstract(c)) {
        if (oper != null) {
          result += sign * oper.doubleValue();
          oper = null;
        }
        sign = (c == '-') ? -1 : 1;
      } else {
        modOperation = c;
      }

    }
    result += sign * oper.doubleValue();
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
