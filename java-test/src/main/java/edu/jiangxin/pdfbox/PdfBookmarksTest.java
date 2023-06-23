package edu.jiangxin.pdfbox;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfBookmarksTest {

    public void alterBookmark(PDOutlineNode pdOutlineNode, String indentation) throws IOException {

        PDOutlineItem currentPdOutlineItem = pdOutlineNode.getFirstChild();
        while (currentPdOutlineItem != null) {
            if (currentPdOutlineItem.getDestination() instanceof PDPageDestination) {
                PDPageDestination pdOutlineItemDestination = (PDPageDestination) currentPdOutlineItem.getDestination();
                pdOutlineItemDestination.setPageNumber(pdOutlineItemDestination.retrievePageNumber() + 25);
            }
            if (currentPdOutlineItem.getAction() instanceof PDActionGoTo) {
                PDActionGoTo pdActionGoTo = (PDActionGoTo) currentPdOutlineItem.getAction();
                if (pdActionGoTo.getDestination() instanceof PDPageDestination) {
                    PDPageDestination pd = (PDPageDestination) pdActionGoTo.getDestination();
                    pd.setPageNumber(pd.retrievePageNumber() + 25);
                }
            }
            alterBookmark(currentPdOutlineItem, indentation + "    ");
            currentPdOutlineItem = currentPdOutlineItem.getNextSibling();
        }
    }

    public void printBookmark(PDOutlineNode pdOutlineNode, String indentation) throws IOException {
        PDOutlineItem currentPdOutlineItem = pdOutlineNode.getFirstChild();
        while (currentPdOutlineItem != null) {
            int pages = 0;
            StringBuilder extraInfo = new StringBuilder();
            PDDestination pdDestination = currentPdOutlineItem.getDestination();
            extraInfo.append(indentation + currentPdOutlineItem.getTitle());
            if (pdDestination instanceof PDPageDestination) {
                PDPageDestination pdOutlineItemDestination = (PDPageDestination) pdDestination;
                pages = (pdOutlineItemDestination.retrievePageNumber() + 1);
                extraInfo.append(":").append(pdDestination.getClass().getSimpleName()).append(":").append(pages);
            } else {
                PDAction pdAction = currentPdOutlineItem.getAction();
                if (pdAction instanceof PDActionGoTo) {
                    PDActionGoTo pdActionGoTo = (PDActionGoTo) pdAction;
                    pdDestination = pdActionGoTo.getDestination();
                    if (pdDestination instanceof PDPageDestination) {
                        PDPageDestination pd = (PDPageDestination) pdDestination;
                        pages = (pd.retrievePageNumber() + 1);
                        extraInfo.append(":PDActionGoTo:").append(pdDestination.getClass().getSimpleName()).append(":").append(pages);
                    }
                }
            }

            System.out.println(extraInfo);
            printBookmark(currentPdOutlineItem, indentation + "    ");
            currentPdOutlineItem = currentPdOutlineItem.getNextSibling();
        }
    }

    @Test
    public void testPrintBookmarks() {
        File file = new File("D:\\CS\\J2EE\\疯狂XML讲义 第2版.pdf");
        if (!file.exists()) {
            System.err.println(" file is not exists ");
            return;
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            PDFParser parser = new PDFParser(new RandomAccessBuffer(fis));
            parser.parse();
            try (PDDocument document = parser.getPDDocument()) {
                PdfBookmarksTest pdfBookmarksTest = new PdfBookmarksTest();
                PDDocumentOutline pdDocumentOutline = document.getDocumentCatalog().getDocumentOutline();
                if (pdDocumentOutline != null) {
                    pdfBookmarksTest.printBookmark(pdDocumentOutline, "");
                } else {
                    System.out.println("This document does not contain any bookmarks");
                }
            }
        } catch (IOException ex) {
            System.err.println("IOException");
        }
    }

    public void testAlterBookmarks() {
        File file = new File("D:\\CS\\J2EE\\疯狂XML讲义 第2版.pdf");
        if (!file.exists()) {
            System.err.println(" file is not exists ");
            return;
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            PDFParser parser = new PDFParser(new RandomAccessBuffer(fis));
            parser.parse();
            try (PDDocument document = parser.getPDDocument()) {
                PdfBookmarksTest pdfBookmarksTest = new PdfBookmarksTest();
                PDDocumentOutline pdDocumentOutline = document.getDocumentCatalog().getDocumentOutline();
                if (pdDocumentOutline != null) {
                    pdfBookmarksTest.alterBookmark(pdDocumentOutline, "");
                } else {
                    System.out.println("This document does not contain any bookmarks");
                }
                document.save("D:\\CS\\J2EE\\a.pdf");
            }
        } catch (IOException ex) {
            System.err.println("IOException");
        }
    }
}