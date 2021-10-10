public class Calculator {
    int a;
    int b;

    Calculator(int number1, int number2){
        a = number1;
        b = number2;
    }

    int sum(){
        return a + b;
    }

    int dec(){
        return a - b;
    }

    int multi(){
        return a * b;
    }

    int div(){
        return a / b;
    }
}