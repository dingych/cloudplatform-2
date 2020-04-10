package com.cloudplatform.springshell.config;
/**
 * @ClassName:TranslationCommands
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/9 23:50
 * @Version: V1.0
 * @since: JDK 1.8
 **/

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Calendar;

@ShellComponent
public class SimpleCommands {
    @ShellMethod("echo:")
    public String echo(int a, int b , int c) {
        return String.format("a = %d, b = %d, c = %d", a, b, c);
    }



    @ShellMethod("Echo2")
    public String echo2(int a, @ShellOption("--boy") int b, int c) {
        return String.format("a = %d, b = %d, c = %d", a, b, c);
    }


    @ShellMethod(key = "default", value = "With default value")
    public void withDefault(@ShellOption(defaultValue = "Hello") final String value) {
        System.out.printf("Value: %s%n", value);
    }

    @ShellMethod("Echo3")
    public String echo3(@ShellOption(arity = 3) int[] numbers) {
        return String.format("a = %d, b = %d, c = %d", numbers[0], numbers[1], numbers[2]);
    }

    @ShellMethod("String size")
    public String stringSize(@Size(min = 3, max = 16) String name) {
        return String.format("Your name is %s", name);
    }

    @ShellMethod("Number range")
    public String numberRange(@Min(10) @Max(100) int number) {
        return String.format("The number is %s", number);
    }

    @ShellMethod("Say hello.")
    public String greet(@ShellOption(defaultValue="World") String who) {
        return "Hello " + who;
    }

    @ShellMethod("Terminate the system.")
    public String shutdown(@ShellOption(defaultValue="true") boolean force) {
        return "You said " + force;
    }

    @ShellMethod("Download the nuclear codes.")
    public void download() {

    }

    @ShellMethod("Disconnect from the server.")
    public void disconnect() {

    }

    @ShellMethodAvailability({"download","disconnect"})
    public Availability availabilityOnWeekdays() {
        return Calendar.getInstance().get(1) == LocalDate.now().getDayOfWeek().getValue()
                ? Availability.available()
                : Availability.unavailable("today is not Sunday");
    }
}