package de.agiledojo.textconverter.testlast;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextConverterTest {


    @Test
    void test() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("", false);
        assertThat(html).isEqualTo("");
    }

}
