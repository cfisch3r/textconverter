package de.agiledojo.textconverter.testfirst;


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.join;

public class TextConverter {

    private static final String EMPTY_LINE = "\n\n";
    private static final String EMPTY_STRING = "";
    private static final String OPENING_P_TAG = "<p>";
    private static final String LINE_BREAK = "<br/>";
    private static final String CLOSING_P_TAG = "</p>";

    private ProgressReporter reporter;

    public String convertToHtml(String text) {
        if (text.isEmpty())
            return EMPTY_STRING;

        Scanner scanner = new Scanner(text).useDelimiter(EMPTY_LINE);
        StringBuilder html = new StringBuilder();
        for (int paragraphId=1; scanner.hasNext();paragraphId++) {
            html.append(paragraph(scanner.next()));
            reportProgress(paragraphId);
        }

        return html.toString();
    }

    private void reportProgress(int paragraphId) {
        if (reporter != null)
                reporter.print("Paragraph " + paragraphId + " processed");
    }

    private String paragraph(String text) {
        return OPENING_P_TAG + join(LINE_BREAK, toLines(text)) + CLOSING_P_TAG;
    }

    private ArrayList<String> toLines(String text) {
        Scanner scanner = new Scanner(text);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }

    public void onProgress(ProgressReporter reporter) {
        this.reporter = reporter;
    }
}
