package de.agiledojo.textconverter.testfirst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class TextConverterTest {

    private TextConverter converter;

    @Mock
    private ProgressReporter reporter;

    @BeforeEach
    void setUp() {
         converter = new TextConverter();
    }

    @Test
    void emptyStringConvertsToEmptyHTML() {
        String html = converter.convertToHtml("");
        assertThat(html).isEqualTo("");
    }

    @Test
    void stringConvertsToParagraph() {
        String html = converter.convertToHtml("this is a line.");
        assertThat(html).isEqualTo("<p>this is a line.</p>");
    }

    @Test
    void singleLineconvertsToParagraph() {
        String html = converter.convertToHtml("this is a line.\n");
        assertThat(html).isEqualTo("<p>this is a line.</p>");
    }

    @Test
    void multipleLinesAreSeparatedByBineBreak() {
        String html = converter.convertToHtml("first line.\nsecond line.\nthird line.\n");
        assertThat(html).isEqualTo("<p>first line.<br/>second line.<br/>third line.</p>");
    }

    @Test
    void multipleParagraphsAreDividedByEmptyLine() {
        String html = converter.convertToHtml("this is a paragraph 1.\n\nthis is paragraph 2.");
        assertThat(html).isEqualTo("<p>this is a paragraph 1.</p><p>this is paragraph 2.</p>");
    }

    @Test
    void conversionProgressIsReported() {
        converter.onProgress(reporter);
        converter.convertToHtml("this is a paragraph 1.\n\nthis is paragraph 2.");
        InOrder inOrder = inOrder(reporter);
        inOrder.verify(reporter).print("Paragraph 1 processed");
        inOrder.verify(reporter).print("Paragraph 2 processed");
    }
}
