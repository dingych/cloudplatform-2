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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@ShellComponent
public class SimpleCommands {

    private static final String  USERNAME = "wudg";

    private static final String PASSWORD = "5555";

    private boolean isLogin = false;

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


    @ShellMethodAvailability({"download","disconnect"})
    public Availability availabilityOnWeekdays() {
        return Calendar.getInstance().get(1) == LocalDate.now().getDayOfWeek().getValue()
                ? Availability.available()
                : Availability.unavailable("today is not Sunday");
    }

    @ShellMethod(value = "Add Method:",key = "sum")
    public int add(@ShellOption(value = {"-param1","-p1"},defaultValue = "33") int a,@ShellOption({"-param2","-p2"}) int b) {
        return a+b;
    }

    @ShellMethod(value = "Array:",key = "arr")
    public int arr(@ShellOption(arity = 3) int[] arr) {
        return Arrays.stream(arr).sum();
    }

    @ShellMethod(value = "Pass Exam:",key = "pass",prefix = "-")
    public boolean pass(boolean force) {
        return force;
    }

    @ShellMethod(value = "Change Password:",key = {"change","changePassword"},prefix = "-")
    public String changePassword(@Size(min = 8,max = 30) String password) {
        return "Your new password is "+password;
    }

    @ShellMethod(value = "Login System:",key = "login",prefix = "-")
    public boolean login(String username,String password) {
        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            isLogin = true;
        }
        return isLogin;
    }

    @ShellMethod(value = "Download Doc:",key = "download")
    // 使用@ShellMethodAvailability 注解指定该命令是否可用的校验方法, 可指定多个校验方法
    @ShellMethodAvailability({"checkAuth"})
    public String download() {
        return "开始下载文件";
    }

    @ShellMethod(value = "Add Method:",key = "sum1")
    public int add1(@ShellOption(value = {"-param1","-p1"},defaultValue = "33") int a,@ShellOption({"-param2","-p2"}) int b) {
        return a+b;
    }

    // 指定该方法限制的命令
    @ShellMethodAvailability({"download"})
    public Availability checkAuth() {
        return isLogin
                ? Availability.available()
                : Availability.unavailable("you are not login");
    }

    @ShellMethod(value = "当前时间:",key = "date")
    public String date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 日期时间转字符串
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(formatter);
        return time;
    }
}