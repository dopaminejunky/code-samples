import java.io.Serializable;
/**
 * Paragraph class
 * Adds text and style
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Paragraph implements Serializable {
    
    /** the text to be included in the paragraph */
    private String text;
    /** the style tag for the paragraph */
    private Style style;
    /**
     * Constructor for objects of class Paragraph
     * @param text the text of the paragraph
     * @param style the style tag for the paragraph
     */
    public Paragraph(String text, Style style) {
        this.text = text;
        this.style = style;
    }
    
    /**
     * Add text to the paragraph
     * @param newText the new text to be added
     */
    public void addText(String newText) {
        text += newText;
    }
    
    /**
     * Set the style tag of the paragraph
     * @param newStyle the new style
     */
    public void setStyle(Style newStyle) {
        style = newStyle;
    }
    
    /**
     * Return the style tag of the paragraph
     * @return the style tag
     */
    public Style getStyle() {
        return style;
    }
    
    /**
     * Get the paragraph text
     * @return the text
     */
    public String get() {
        return text;
    }
    
    /**
     * Enumerated type for HTML style tags
     * @author Roger Robertson Jr.
     * @version 0.1
     */
    public enum Style implements Serializable {
        
        /** left indentation */LEFT, 
        /** right indentation */RIGHT, 
        /** center indentation */CENTER,
        /** unordered (bulleted) list */UL,
        /** ordered (numbered) list */OL, 
        /** heading level 1 */H1, 
        /** heading level 2 */H2,
        /** heading level 3 */H3,
        /** heading level 4 */H4
    }
}
