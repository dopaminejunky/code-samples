

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest.
 *
 * @author  Roger Robertson Jr.
 * @version 0.1
 */
public class SectionTest {
    /**
     * Default constructor for test class SectionTest
     */
    public SectionTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
    
    /**
     * Test the constructor
     */
    @Test
    public void testConst() {
        Section testSection = new Section();
        assertEquals(0, testSection.getParagraphCount());
    }
    
    /**
     * Test addParagraph
     */
    @Test
    public void testAddParagraph() {
        Section testSection = new Section();
        Paragraph p1 = new Paragraph("Hello World!", Paragraph.Style.LEFT);
        testSection.addParagraph(p1);
        assertEquals(1, testSection.getParagraphCount());
    }
    
    /**
     * Test addParagraph with an index
     */
    @Test
    public void testAddParaWithIdx() {
        Section testSection = new Section();
        Paragraph p1 = new Paragraph("Hello World!", Paragraph.Style.LEFT);
        Paragraph p2 = new Paragraph("I\'m fine, thanks!", Paragraph.Style.CENTER);
        testSection.addParagraph(p1);
        testSection.addParagraph(p2);
        Paragraph p3 = new Paragraph("In the middle", Paragraph.Style.RIGHT);
        testSection.addParagraph(p3, 1);
        assertEquals(3, testSection.getParagraphCount());
    }
    
    /**
     * Test moving a paragraph up
     */
    @Test
    public void testMoveParaUp() {
        Section testSection = new Section();
        Paragraph p1 = new Paragraph("a", Paragraph.Style.H1);
        Paragraph p2 = new Paragraph("b", Paragraph.Style.H2);
        Paragraph p3 = new Paragraph("c", Paragraph.Style.H3);
        testSection.addParagraph(p1);
        testSection.addParagraph(p2);
        testSection.addParagraph(p3);
        testSection.moveUp(2);
        assertEquals("b", testSection.get(2).get());
    }
    
    /**
     * Test moving a paragraph down
     */
    @Test
    public void testMoveParaDown() {
        Section testSection = new Section();
        Paragraph p1 = new Paragraph("a", Paragraph.Style.H1);
        Paragraph p2 = new Paragraph("b", Paragraph.Style.H2);
        Paragraph p3 = new Paragraph("c", Paragraph.Style.H3);
        testSection.addParagraph(p1);
        testSection.addParagraph(p2);
        testSection.addParagraph(p3);
        testSection.moveDown(1);
        assertEquals("b", testSection.get(2).get());
    }
}
