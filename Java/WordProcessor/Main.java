
/**
 * Write a description of class Main here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Main {
    
    public static void main(String[] args) {
        Document document = Document.getInstance("document");
        Section sec01 = new Section();
        document.addSection(sec01);
        Paragraph para01 = new Paragraph("Lorem Ipsum", Paragraph.Style.LEFT);
        sec01.addParagraph(para01);
        document.close();
        document.open("document.wpd");
        Paragraph para02 = new Paragraph("The quick fox jumped over the lazy brown dog", Paragraph.Style.CENTER);
        sec01.addParagraph(para02);
        document.saveToHTML();
        document.close();
    }
}
