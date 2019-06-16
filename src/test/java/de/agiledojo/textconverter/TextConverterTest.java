package de.agiledojo.textconverter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextConverterTest {


    @Test
    void replacegt() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12>13", false);
        assertThat(html).contains("12&gt;13");
    }

    @Test
    void replace1() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12<13", false);
        assertThat(html).contains("12&lt;13");
    }

    @Test
    void replace2() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12&13", false);
        assertThat(html).contains("12&amp;13");
    }
    @Test
    void replace3() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12\"13", false);
        assertThat(html).contains("12&quot;13");
    }
    @Test
    void replace4() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12'13", false);
        assertThat(html).contains("12&quot;13");
    }
    @Test
    void linebreak() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12\n13", false);
        assertThat(html).contains("12<br/>13");
    }

    @Test
    void paragraphsplit() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12\n\n13", false);
        assertThat(html).isEqualTo("<p>12</p><p>13</p>");
    }

    @Test
    void complex() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("12\n13\n14\n\nwas dad\n", false);
        assertThat(html).isEqualTo("<p>12<br/>13<br/>14</p><p>was dad</p>");
    }

    @Test
    void complex2() {
        TextConverter converter = new TextConverter();
        String html = converter.convertToHtml("\n\n12\n13\n14\n\n\nwas dad\n\n", false);
        assertThat(html).isEqualTo("<p></p><p></p><p>12<br/>13<br/>14</p><p></p><p>was dad</p>");
    }
}
