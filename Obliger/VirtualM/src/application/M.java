/**
 * Dokumentasjon:
 * 6109 Objektorientert Programmering @Høyskolen i Sør-øst Norge
 *
 * @author Joachim Strøm Ekelund & Rolf-Ivar Vikestad
 *
 * Dette er prosjekt 3 i Objektorientert Programmering høst 2016
 * M er en viruell maskin som kan kjøre filer med extension .m
 * Den har også en visuell debugger som viser hva som blir gjort når
 * hver maskinkode blir kjørt.
 *
 * Sist endret dato: 10.11.2015
 */

package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class M extends Application {

    private static final int IREAD = 10;
    private static final int IWRITE = 11;
    private static final int CREAD = 12;
    private static final int CWRITE = 13;
    private static final int LOAD = 20;
    private static final int STORE = 21;
    private static final int RSET = 22;
    private static final int ADD = 30;
    private static final int SUB = 31;
    private static final int MULT = 32;
    private static final int DIV = 33;
    private static final int JUMP = 40;
    private static final int JNEG = 41;
    private static final int JZERO = 42;
    private static final int STOP = 50;
    private static final int RAM_SIZE = 256;
    private int[] RAM;
    private int R;
    private int PC;
    private static String SYSARG;
    public TextArea output = new TextArea();
    Scanner sc;

    /**
     * Metode som initialiserer instansvariabler
     */
    public M() {
        this.output = new TextArea();
    }

    /**
     * Metode som laster inn et programsett (tekstfil) Leser inn program, linje
     * for linje til RAM[i]
     */
    public void loadProgram(String fileName) {
        // Nullstilling av instansvariabler
            R = 0;
            PC = 0;
            fileName = SYSARG;
            
            try {
            RAM = fileToIntArray(fileName);      
            }
            catch (ArrayIndexOutOfBoundsException e){
            	output.appendText("Error, too large program: \nMax length is: " + e.getLocalizedMessage());
            	output.appendText("\nShutting down.");
            	delayQuit();
            }
    }

    /**
     * Metode som tar inn et programsett fra args, og sender ett og ett program
     * i en loop i stepProgram();
     */
    public void executeProgram() {
    	for (int i = 0; i < RAM.length; i++) {
                stepProgram();
                PC += 2;
                // For å ikke kjøre programmet lenger enn det er
                // selvom det er flere plasser i RAM
                if (RAM[PC] == 0 && RAM[PC + 1] == 0) {
                    break;
                }
           }
    	}
    	   
        

    /**
     * Metode som kjører ett eneste program, basert på programnummer
     */
    public void stepProgram() {
        int code = RAM[PC];
        int arg = RAM[PC + 1];
        System.out.println(arg);
        if (code != 0) {
            switch (code) {
                case IREAD:
                    output.appendText("IREAD: 10\n");
                    output.appendText("R før read: " + R + "\n");
                    String svar = userInput().toString().replaceAll("[^\\d]", "");
                    R = Integer.parseInt(svar);
                    output.appendText("R = ");
                    output.appendText(R + "\n");
                    break;
                case IWRITE:
                    output.appendText("IWRITE: 11\n");
                    output.appendText(R + "\n");
                    break;
                case CREAD:
                    output.appendText("CREAD: 12\n");
                    String inn = sc.next();
                    char ch = inn.charAt(0);
                    R = (int) ch;
                    output.appendText("Register: " + R + "\n");
                    if (inn.length() != 1) {
                        output.appendText("The first letter was saved.\n");
                    }
                    break;
                case CWRITE:
                    output.appendText("CWRITE: 13\n");
                    output.appendText(R + "\n");
                    break;
                case LOAD:
                    output.appendText("LOAD: 20\n");
                    R = RAM[arg];
                    output.appendText(R + "\n");
                    break;
                case STORE:
                    output.appendText("STORE: 21\n");
                    RAM[arg] = R;
                    break;
                case RSET:
                    output.appendText("RSET: 22\n");
                    if (digitCheck(arg)) {
                        output.appendText("The number is out of bounds\n Program will end in 5 seconds\n");
                        delayQuit();
                    } else {
                        R = arg;
                        output.appendText(R + "\n");

                    }
                    break;
                case ADD:
                    output.appendText("ADD: 30\n");
                    if (digitCheck(R)) {
                        output.appendText("The number is out of bounds\n Program will end in 5 seconds\n");
                        delayQuit();
                    } else {
                        output.appendText(R + "+" + RAM[arg]);
                        R = R + RAM[arg];
                        output.appendText("=" + R + "\n");
                    }

                    break;
                case SUB:
                    if (digitCheck(R)) {
                        output.appendText("The number is out of bounds\n Program will end in 5 seconds\n");
                        delayQuit();

                    } else {
                        output.appendText(R + "-" + RAM[arg]);
                        R = R - RAM[arg];
                        output.appendText("=" + R + "\n");
                    }
                    break;
                case MULT:
                    if (digitCheck(R)) {
                        output.appendText("The number is out of bounds\n Program will end in 5 seconds\n");
                        delayQuit();
                    } else {
                        output.appendText(R + "*" + RAM[arg]);
                        R = R + RAM[arg];
                        output.appendText("=" + R + "\n");
                    }
                    break;
                case DIV:
                    output.appendText("DIV: 33\n");
                    if (digitCheck(R)) {
                        output.appendText("The number is out of bounds\n Program will end in 5 seconds\n");
                        delayQuit();
                    } else if (RAM[arg] == 0) {
                        output.appendText("It's not possible to divide with 0.\n Program will end in 5 seconds\n");
                        delayQuit();
                    } else {
                        output.appendText(R + "/" + RAM[arg]);
                        R = R / RAM[arg];
                        output.appendText("=" + R + "\n");
                    }
                    break;
                case JUMP:
                    output.appendText("JUMP: 40\n");
                    PC = arg;
                    break;
                case JNEG:
                    output.appendText("JNEG: 41\n");
                    if (R < 0) {
                        PC = arg;
                    } else {
                        output.appendText("R is not negative\n");
                    }
                    break;
                case JZERO:
                    output.appendText("JZERO: 42\n");
                    if (R == 0) {
                        PC = arg;
                    } else {
                        output.appendText("R is not 0\n");
                    }
                    break;
                case STOP:
                    output.appendText("STOP: 50\n");
                    output.appendText("Program completed successfully.\n Program will end in 5 seconds\n");
                    delayQuit();
                    break;
                default:
                    output.appendText("PROGRAM NOT FOUND: " + code);
                    break;
            }
        } else {
            System.out.println("Error: code = " + code + " is not a valid code");
        }
    }

    /**
     * Startmetode for javaFX. Her ligger også hovedmetodekallene til
     * programmet.
     */
    @Override
    public void start(Stage primaryStage) {

        M machine = new M();
        machine.output.setEditable(false);
        machine.output.setStyle(""
                + "-fx-text-fill: rgb(0, 255, 0);"
                + "-fx-base: rgb(10, 10, 10);"
                + "-fx-background: rgb(0, 0, 0);");
        machine.output.setFont(new Font("Courier New", 14));

        // Output
        BorderPane outputPane = new BorderPane();
        Scene outputScene = new Scene(outputPane, 500, 500);
        outputPane.setCenter(machine.output);

        primaryStage.setTitle("M Compilator");
        primaryStage.setScene(outputScene);
        primaryStage.show();

        machine.loadProgram(SYSARG);
        machine.executeProgram();

    }

    public static void main(String[] args) {
        SYSARG = args[0] + ".m";
        launch();
    }

    /* Hjelpemetoder */
    /**
     * Metode for brukerinnput i javaFX
     *
     * @return
     */
    public Optional<String> userInput() {
        TextInputDialog dialog;
        Optional<String> result;
        dialog = new TextInputDialog("");
        dialog.setTitle("Input Dialogue");
        dialog.setHeaderText("");
        dialog.setContentText("Input: ");
        result = dialog.showAndWait();
        return result;
    }

    /**
     * Leser linjer fra fil, sender til String[]
     */
    private static int[] fileToIntArray(String fileName) {
        String[] temp = new String[RAM_SIZE];
        String[] split = new String[2];
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int index = 0;
            for (int i = 0; i <= lineCount(fileName) - 1; i++) {
                split = splitString(br.readLine());
                temp[index] = split[0];
                index++;
                if (split.length < 2) {
                    temp[index] = "0";
                    index++;
                } else {
                    temp[index] = split[1];
                    index++;
                }
            }
            br.close();
            return stringArrToIntArr(temp);

        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
        return stringArrToIntArr(temp);
    }

    /**
     * Splitter en string i to, til en String[]
     */
    private static String[] splitString(String linje) {
        String[] tab = new String[1];
        tab = linje.split(" ");
        return tab;
    }

    /**
     * Returnerer antall linjer i en tekstfil
     */
    private static int lineCount(String fileName) {
        File inFile;
        FileReader fr;
        BufferedReader br;

        try {
            inFile = new File(fileName);
            fr = new FileReader(inFile);
            br = new BufferedReader(fr);

            Scanner sc = new Scanner(inFile);
            int counter = 0;

            while (sc.hasNextLine()) {
                sc.nextLine();
                counter++;
            }
            sc.close();
            br.close();
            return counter;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return -1;
    }

    /**
     * "Gjør om" en String[] til en int[]
     */
    private static int[] stringArrToIntArr(String[] arr) {
        int[] tab = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                tab[i] = 0;
            } else {
                tab[i] = Integer.parseInt(arr[i]);
            }
        }
        return tab;
    }

    /**
     * Sjekker om et tall er for stort eller for lite
     */
    private static boolean digitCheck(int num) {
        return (num < -127 || num > 128);
    }

    /**
     * Metode som skriver ut feilmelding og avslutter programmet
     */
    private void delayQuit() {
        //Hentet fra http://tomasmikula.github.io/blog/2014/06/04/timers-in-javafx-and-reactfx.html
        Timeline nyStop = new Timeline(new KeyFrame(Duration.seconds(5), ae -> System.exit(0)));
        nyStop.play();
    }

}
