package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();
        /*
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        */
        /*
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);
        */
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(3, 4, (a, b) -> a + b);
        expressionExecutor.executeExpression(3, 4, (a, b) -> a - b);
        expressionExecutor.executeExpression(3, 4, (a, b) -> a * b);
        expressionExecutor.executeExpression(3, 4, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemToBeautify = new PoemBeautifier();
        String poemByJakubSajkowski = "\nJakub Sajkowski - Facebook\n" +
                "\n" +
                "Pierwszy listopada, oglądam portrety trumienne\n" +
                "na Facebooku. Chłopak, z którym nigdy nie rozmawiałem,\n" +
                "wysyła mi wiadomość, twierdzi, że jesteśmy znajomymi.\n" +
                "To trochę tak, jakbym znał go z nekrologu –\n" +
                "\n" +
                "teoretycznie jest szansa, że na naszych pogrzebach pojawią się te same osoby.\n" +
                "Mamy czterdziestu dwóch wspólnych, te same czterdzieści dwa genotypy\n" +
                "\n" +
                "zakręcą się wokół nas, jakbyśmy byli genetycznymi bliźniakami.\n" +
                "Można by zmieszać krew, namalować martwą naturę,\n" +
                "wszyscy się zachwycą, nie będzie rozmów. Tylko harmonijny,\n" +
                "jednostajny szczebiot,\n" +
                "\n" +
                "jak karabin maszynowy,\n" +
                "nic nie wyłowisz oprócz łusek.";
        String uppercasedPoem = poemToBeautify.beautify(poemByJakubSajkowski, text -> poemByJakubSajkowski.toUpperCase());
        System.out.println(uppercasedPoem);

        String underscoredPoem = poemToBeautify.beautify(poemByJakubSajkowski, text -> poemByJakubSajkowski.replace(" ", "_"));
        System.out.println(underscoredPoem);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
