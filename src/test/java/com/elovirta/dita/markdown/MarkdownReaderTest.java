package com.elovirta.dita.markdown;

import com.elovirta.dita.utils.AbstractReaderTest;
import org.dita.dost.util.SaxCache;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class MarkdownReaderTest extends AbstractReaderTest {

    @Override
    public XMLReader getReader() {
        return new MarkdownReader();
    }

    @Override
    public String getExp() {
        return "dita/";
    }

    @Override
    public String getSrc() {
        return "markdown/";
    }

    @Test
    public void testHeader() throws Exception {
        run("header.md");
    }

    @Ignore
    @Test
    public void testPandocHeader() throws Exception {
        run("pandoc_header.md");
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidHeader() throws Exception {
        run("invalid_header.md");
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidSectionHeader() throws Exception {
        run("invalid_section_header.md");
    }

    @Test
    public void testGitHubWiki() throws Exception {
        run("missing_root_header.md");
    }

    @Test
    public void testGitHubWikiWithYaml() throws Exception {
        run("missing_root_header_with_yaml.md");
    }

    @Test
    public void testHeaderAttributes() throws Exception {
        run("header_attributes.md");
    }

    @Test
    public void testBodyAttributes() throws Exception {
        run("body_attributes.md");
    }

    @Test
    public void testConcept() throws Exception {
        run("concept.md");
    }

    @Test
    public void testTask() throws Exception {
        run("task.md");
    }

    @Test
    public void testTaskOneStep() throws Exception {
        run("taskOneStep.md");
    }

    @Test
    public void testReference() throws Exception {
        run("reference.md");
    }

    @Test
    public void testImage() throws Exception {
        run("image.md");
    }

    @Test
    public void testImageSize() throws Exception {
        run("image-size.md");
    }

    @Test
    public void testLink() throws Exception {
        run("link.md");
    }

    @Test
    public void testUl() throws Exception {
        run("ul.md");
    }

    @Test
    public void testOl() throws Exception {
        run("ol.md");
    }

    @Test
    public void testInline() throws Exception {
        run("inline.md");
    }

    @Test
    public void testTable() throws Exception {
        run("table.md");
    }

    @Test
    public void testTableWidth() throws Exception {
        run("table-width.md");
    }

    @Test
    public void testQuote() throws Exception {
        run("quote.md");
    }

    @Test
    public void testEscape() throws Exception {
        run("escape.md");
    }

    @Test
    public void testDl() throws Exception {
        run("dl.md");
    }

    @Test
    public void testCodeblock() throws Exception {
        run("codeblock.md");
    }

    @Test
    public void testMultipleTopLevel() throws Exception {
        run("multiple_top_level.md");
    }

    @Test
    public void testMultipleTopLevelSpecialized() throws Exception {
        run("multiple_top_level_specialized.md");
    }

    @Test
    public void testNoBOM() throws Exception {
        run("testNoBOM.md");
    }

    @Test
    public void testBOM() throws Exception {
        run("testBOM.md");
    }

    @Test
    public void getMarkdownContent_url() throws Exception {
        final String input = getSrc() + "testBOM.md";
        final URL in = getClass().getResource("/" + input);
        final InputSource i = new InputSource(in.toString());
        final char[] content = new MarkdownReader().getMarkdownContent(i);
        assertEquals('W', content[0]);
    }

    @Test
    public void testShort() throws Exception {
        run("short.md");
    }

    @Test
    public void testShortdesc() throws Exception {
        run("shortdesc.md");
    }

    @Test
    public void testLinebreak() throws Exception {
        run("linebreak.md");
    }

    @Test
    public void testYaml() throws Exception {
        run("yaml.md");
    }

    @Test
    public void testKeys() throws Exception {
        run("keys.md");
    }

    @Test
    public void testEntity() throws Exception {
        run("entity.md");
    }

    @Test
    public void testComment() throws Exception {
        run("comment.md");
    }

    @Test
    public void testHtml() throws Exception {
        run("html.md");
    }

    @Test
    public void testUnsupportedHtml() throws Exception {
        run("unsupported_html.md");
    }

    @Test
    public void testConref() throws Exception {
        run("conref.md");
    }

    @Test
    public void testKeyref() throws Exception {
        run("keyref.md");
    }

    @Test
    public void testConkeyref() throws Exception {
        run("conkeyref.md");
    }

    @Test
    public void testFootnote() throws Exception {
        run("footnote.md");
    }

    @Test
    public void testJekyll() throws Exception {
        run("jekyll.md");
    }

    @Test
    public void testAbbreviation() throws Exception {
        run("abbreviation.md");
    }

    @Test
    public void testLocator() throws IOException, SAXException {
        final XMLReader r = getReader();
        r.setContentHandler(new ContentHandler() {
            Locator locator;

            @Override
            public void setDocumentLocator(Locator locator) {
                this.locator = locator;
            }

            @Override
            public void startDocument() throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void processingInstruction(String target, String data) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }

            @Override
            public void skippedEntity(String name) throws SAXException {
                System.out.println(locator.getLineNumber() + ":" + locator.getColumnNumber());
            }
        });
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("/" + getSrc() + "shortdesc.md")) {
            InputSource input = new InputSource(in);
            r.parse(input);
        }
    }
}