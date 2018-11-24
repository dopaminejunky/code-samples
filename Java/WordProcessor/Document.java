import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.PrintStream;
/**
 * Document workspace
 * Singleton
 * Manages sections
 * Opens, closes, saves, and saves to HTML
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Document implements Serializable {
    /** the document name */
    private String name;
    /** the list of sections */
    private LinkedList<Section> sections;
    /** flag for if the document is open */
    private boolean isOpen;
    /** singleton instance flag */
    private static Document instance = null;

    /**
     * Constructor for objects of class Document
     * @param name the document name
     */
    private Document(String name) {
        this.name = name;
        sections = new LinkedList<>(); 
        isOpen = true;
    }
    
    /**
     * Get a Document instance
     * @param name the name of the document
     * @return an instance of the Document class
     */
    public static Document getInstance(String name) {
        if (instance == null) {
            instance =  new Document(name);
        }
        return instance;
    }
    
    /**
     * Set the Document name
     * @param newName the new name
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
     * Get the Document name
     * @return the document name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Add a section
     * @param newSection the new section to add
     */
    public void addSection(Section newSection) {
        sections.add(newSection);
    }
    
    /**
     * Add a section at a given index
     * @param newSection the new section to add
     * @param index the location to add it
     */
    public void addSection(Section newSection, int index) {
        sections.add(newSection, index);
    }
    
    /**
     * Remove a section at an index
     * @param index the section to remove
     */
    public void removeSection(int index) {
        sections.remove(index);
    }
    
    /**
     * Move section up
     * @param index the section to move towards the front
     */
    public void moveSectionUp(int index) {
        sections.moveUp(index);
    }
    
    /**
     * Move section down
     * @param index the section to move towards the end
     */
    public void moveSectionDown(int index) {
        sections.moveDown(index);
    }
    
    /**
     * Get a section by index
     */
    public Section get(int index) {
        return sections.get(index);
    }
    
    /**
     * Close the document and save via serialization
     * Does nothing if serialization fails
     * Throws IllegalStateException if document is already closed
     */
    public void close() {
        try {
            if (isOpen) {
                FileOutputStream doc = new FileOutputStream(getName() + ".wpd");
                ObjectOutputStream out = new ObjectOutputStream(doc);
                isOpen = false;
                out.writeObject(doc);
                out.close();
                doc.close();
            } else {
                throw new IllegalStateException("Document is already closed!");
            } 
        } catch (IOException e) {
            
        }
    }
    
    /**
     * Open the document via deserialization
     * Does nothing if serialization fails
     * Throws IllegalStateException if attempting to open more than one document
     * @return the specified document
     */
    public Document open(String name) {
        try {
             if (!isOpen) {
                isOpen = true;
                FileInputStream docIn = new FileInputStream(name);
                ObjectInputStream in = new ObjectInputStream(docIn);
                Document doc = (Document)in.readObject();
                return doc;
             } else {
                throw new IllegalStateException("Cannot have more than one open document!"); 
             }
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    
    /**
     * Saves document to HTML
     */
    public void saveToHTML() {
            String html = "<!DOCTYPE html>\n \t<body>\n";
            for (int sCount = 0; sCount < sections.size(); sCount++) {
                for (int pCount = 0; pCount < sections.get(sCount).getParagraphCount(); pCount++) {
                
                    switch (sections.get(sCount).get(pCount).getStyle()) {
                        case LEFT :
                            html += "<p style=\"text-align:left\">" + sections.get(sCount).get(pCount).get() + "</p>\n";
                            break;
                        case RIGHT :
                            html += "<p style=\"text-align:right\">" + sections.get(sCount).get(pCount).get() + "</p>\n";
                            break;
                        case CENTER :
                            html += "<p style=\"text-align:center\">" + sections.get(sCount).get(pCount).get() + "</p>\n";
                            break;
                        case H1 :
                            html += "<h1>" + sections.get(sCount).get(pCount).get() + "</h1>\n";
                            break;
                        case H2 :
                            html += "<h2>" + sections.get(sCount).get(pCount).get() + "</h2>\n";
                            break;
                        case H3 :
                            html += "<h3>" + sections.get(sCount).get(pCount).get() + "</h3>\n";
                            break;
                        case H4 :
                            html += "<h4>" + sections.get(sCount).get(pCount).get() + "</h4>\n";
                            break;
                        case UL :
                            html += "<p style=\"text-align:left\">" + sections.get(sCount).get(pCount).get() + "</p>\n";
                            break;
                        case OL :
                            html += "<p style=\"text-align:left\">" + sections.get(sCount).get(pCount).get() + "</p>\n";
                            break;
                    }
                }
        }
        try {
            PrintStream out = new PrintStream(new FileOutputStream(getName() + ".html"));
            out.print(html + "\t</body>\n</html>");
        } catch (FileNotFoundException e) {
            
        }
    }
}

