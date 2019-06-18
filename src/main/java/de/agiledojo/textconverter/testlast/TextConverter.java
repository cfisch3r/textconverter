package de.agiledojo.textconverter.testlast;

import java.util.Scanner;

public class TextConverter {

    public String convertToHtml(String text,boolean showProgress) {
        StringBuilder builder = new StringBuilder();
        try(Scanner scanner = new Scanner(text)) {
            boolean paragraph = false;
            int paragraphCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!paragraph) {
                    builder.append("<p>");
                    paragraph = true;
                } else {
                    if (!line.isEmpty())
                    builder.append("<br/>");
                }


                if (line.isEmpty()) {
                    paragraphCount++;
                    if (showProgress)
                        System.out.println("Paragraph " + paragraphCount + " processed.");
                    builder.append("</p>");
                    paragraph = false;
                } else {
                    line = line.replace("&", "&amp;");
                    line = line.replace(">", "&gt;");
                    line = line.replace("<", "&lt;");
                    line = line.replace("'", "&quot;");
                    line = line.replace("\"", "&quot;");
                    builder.append(line);
                }
            }

            if (paragraph) {
                builder.append("</p>");
            }
        }
        return builder.toString();
    }

}
