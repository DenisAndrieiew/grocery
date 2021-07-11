package com.goit.grocery.controller.it;

import com.goit.grocery.Application;
import com.goit.grocery.model.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ControllerIntegrationTest {
    private ConfigurableInputStream in;
    private ByteArrayOutputStream out;
    private static final String TEST_FILE_PATH = "src\\test\\resources\\Storage.str";

    @Before
    public void init() {
        in = new ConfigurableInputStream();
        out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        Storage testStorage = new Storage(TEST_FILE_PATH);
    }

    @After
    public void clear() {
        out.reset(); }

    @Test
    public void testHelpCommand_happyPath() {
        //given
        in.add("help");
        in.add("exit");
        //when
        Application.main(new String[0]);
        assertEquals("Welcome to the shop\n" +
                "Please enter a command or help to retrieve command list\n" +
                "help - show a list of commands\n" +
                "exit - exit from an application\n" +
                "show_all - show all products in store\n" +
                "calculate - calculate price of chosen goods\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }
    @Test
    public void testShowAllCommand_happyPath(){
        //given
        in.add("show_all");
        in.add("exit");
        //when
        Application.main(new String[0]);
        assertEquals("Welcome to the shop\n" +
                "Please enter a command or help to retrieve command list\n" +
                "*********************************************************\n" +
                "*Goods*   Price  * \t  Action number \t* Action price  *\n" +
                "*********************************************************\n" +
                "*\tA\t*\t1.25 *\t\t\t3\t\t\t*\t3\t\t\t*\n" +
                "*\tB\t*\t4.25 *\t\t\t\t\t\t*\t\t\t\t*\n" +
                "*\tC\t*\t1.00 *\t\t\t6\t\t\t*\t5\t\t\t*\n" +
                "*\tD\t*\t0.75 *\t\t\t\t\t\t*\t\t\t\t*\n" +
                "*********************************************************\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());

    }
    @Test
    public void testCalculate_happy_path(){
        //given
        in.add("calculate");
        in.add("AABBAACDFM");
        in.add("exit");
        //when
        Application.main(new String[0]);
        assertEquals("Welcome to the shop\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter goods sequence\n" +
                "total cost is 14.50\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    private String getActualResult() {
        return new String(out.toByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");
    }
    }
