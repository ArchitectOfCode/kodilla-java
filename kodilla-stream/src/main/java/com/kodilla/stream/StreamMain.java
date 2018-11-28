package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

public class StreamMain {
    public static void main(String[] args) {
        //Processor processor = new Processor();
        /*
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        */
        /*
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);
        */
        /*
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
        */
        /*
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(s -> System.out.println(s));
        */
        //BookDirectory theBookDirectory = new BookDirectory();
        /*
        Map<String, Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, Book -> Book));

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        */
        /*
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
        */

        Forum forum = new Forum();
        Map<Integer, ForumUser> adultMansWhoCreatedPostsOnForum = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().plusYears(19).plusDays(364).isBefore(now()))
                .filter(forumUser -> forumUser.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getForumUserID, ForumUser -> ForumUser));

        System.out.println("Number of forum users who are mans in age of 20 or older and posted at least one post: " + adultMansWhoCreatedPostsOnForum.size());
        adultMansWhoCreatedPostsOnForum.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
