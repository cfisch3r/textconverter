package de.agiledojo.textconverter.testfirst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextConverterTest {

    private TextConverter converter;

    @BeforeEach
    void setUp() {
         converter = new TextConverter();
    }

    @Test
    void emptyString() {
        String html = converter.convertToHtml("");
        assertThat(html).isEqualTo("");
    }

    @Test
    void stringconvertsToParagraph() {
        String html = converter.convertToHtml("this is a line.");
        assertThat(html).isEqualTo("<p>this is a line.</p>");
    }

    @Test
    void singleLineconvertsToParagraph() {
        String html = converter.convertToHtml("this is a line.\n");
        assertThat(html).isEqualTo("<p>this is a line.</p>");
    }

    @Test
    void multipleLinesseparatedbylinebreak() {
        String html = converter.convertToHtml("first line.\nsecond line.\nthird line.\n");
        assertThat(html).isEqualTo("<p>first line.<br/>second line.<br/>third line.</p>");
    }

    @Test
    void multipleParagraphs() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("this is a paragraph 1.\n\nthis is paragraph 2.");
        assertThat(html).isEqualTo("<p>this is a paragraph 1.</p><p>this is paragraph 2.</p>");
    }

    }
