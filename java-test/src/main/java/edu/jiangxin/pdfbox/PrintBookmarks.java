package edu.jiangxin.pdfbox;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintBookmarks {

    /**
     * This will print the documents 书签 to System.out.
     *
     * @param bookmark    The 书签 to print out.
     * @param indentation A pretty printing parameter
     *
     * @throws IOException If there is an error getting the page count.
     */
    public void printBookmark(PDOutlineNode bookmark, String indentation) throws IOException {

        PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            int pages = 0;
            if (current.getDestination() instanceof PDPageDestination) {
                System.out.println("PDPageDestination");
                PDPageDestination pd = (PDPageDestination) current.getDestination();
                pages = (pd.retrievePageNumber() + 1);
            }
            if (current.getAction() instanceof PDActionGoTo) {
                System.out.println("PDActionGoTo");
                PDActionGoTo gta = (PDActionGoTo) current.getAction();
                if (gta.getDestination() instanceof PDPageDestination) {
                    System.out.println("PDActionGoTo:PDPageDestination");
                    PDPageDestination pd = (PDPageDestination) gta.getDestination();
                    System.out.println(pd.getClass().getSimpleName());
                    pages = (pd.retrievePageNumber() + 1);
                }
            }
            if (pages == 0) {
                System.out.println(indentation + current.getTitle());
            } else {
                System.out.println(indentation + current.getTitle() + "  " + pages);
            }
            printBookmark(current, indentation + "    "); // 递归调用
            current = current.getNextSibling();
        }

    }

    public static void main(String[] args) throws Exception {
        File file1 = new File("D:\\CS\\J2EE\\深入理解Java虚拟机 JVM高级特性与最佳实践 第三版-周志明.pdf");
        if (!file1.exists()) {
            System.err.println(" file is not exists ");
            return;
        }
        // 开始读取 PDF文档
        PDDocument document = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file1);
            PDFParser parser = new PDFParser(new RandomAccessBuffer(fis));
            parser.parse();
            document = parser.getPDDocument();

            PrintBookmarks the = new PrintBookmarks();
            PDDocumentOutline outline = document.getDocumentCatalog().getDocumentOutline();
            if (outline != null) {
                the.printBookmark(outline, "");
            } else {
                System.out.println("This document does not contain any bookmarks");
            }
        } finally {
            if (fis != null)
                fis.close();
            if (document != null)
                document.close();
        }

    }
}