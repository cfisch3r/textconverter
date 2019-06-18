package de.agiledojo.textconverter.testfirst;


import java.util.Scanner;

public class TextConverter {
    public String convertToHtml(String text) {
        if (text.isEmpty())
            return "";
        else {
            Scanner scanner = new Scanner(text);
            return "<p>" + scanner.nextLine() + "</p>";
        }
    }
}
