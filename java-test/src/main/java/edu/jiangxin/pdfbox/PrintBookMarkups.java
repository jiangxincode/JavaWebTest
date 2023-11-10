package edu.jiangxin.pdfbox;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintBookMarkups {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\CS\\J2EE\\深入理解Java虚拟机 JVM高级特性与最佳实践 第三版-周志明.pdf");
        PDDocument doc = Loader.loadPDF(new RandomAccessReadBufferedFile(file));
        PDPageTree pdPageTree = doc.getDocumentCatalog().getPages();
        for (PDPage page : pdPageTree) {
            List<PDAnnotation> pdAnnotations = page.getAnnotations();
            for (PDAnnotation pdAnnotation : pdAnnotations) {
                if (pdAnnotation.getSubtype().equals("Highlight")) {
                    PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
                    COSDictionary dictionary = pdAnnotation.getCOSObject();
                    COSArray quadsArray = (COSArray) dictionary.getDictionaryObject(COSName.getPDFName("QuadPoints"));
                    String str = null;
                    for (int j = 1, k = 0; j <= (quadsArray.size() / 8); j++) {
                        COSFloat ULX = (COSFloat) quadsArray.get(0 + k);
                        COSFloat ULY = (COSFloat) quadsArray.get(1 + k);
                        COSFloat URX = (COSFloat) quadsArray.get(2 + k);
                        COSFloat URY = (COSFloat) quadsArray.get(3 + k);
                        COSFloat LLX = (COSFloat) quadsArray.get(4 + k);
                        COSFloat LLY = (COSFloat) quadsArray.get(5 + k);
                        COSFloat LRX = (COSFloat) quadsArray.get(6 + k);
                        COSFloat LRY = (COSFloat) quadsArray.get(7 + k);

                        k += 8;

                        float ulx = ULX.floatValue() - 1;                           // upper left x.
                        float uly = ULY.floatValue();                               // upper left y.
                        float width = URX.floatValue() - LLX.floatValue();          // calculated by upperRightX - lowerLeftX.
                        float height = URY.floatValue() - LLY.floatValue();         // calculated by upperRightY - lowerLeftY.

                        PDRectangle pageSize = page.getMediaBox();
                        uly = pageSize.getHeight() - uly;

                        Rectangle2D.Float rectangle_2 = new Rectangle2D.Float(ulx, uly, width, height);
                        stripperByArea.addRegion("highlightedRegion", rectangle_2);
                        stripperByArea.extractRegions(page);
                        String highlightedText = stripperByArea.getTextForRegion("highlightedRegion");

                        if (j > 1) {
                            str = str.concat(highlightedText);
                        } else {
                            str = highlightedText;
                        }
                    }
                    System.out.println(str);
                }
            }

/*            for (PDAnnotation pdAnnotation : pdAnnotations) {
                System.out.println(pdAnnotation.getClass());
                if (pdAnnotation instanceof PDAnnotationLink) {
                    PDAnnotationLink pdAnnotationLink = (PDAnnotationLink)pdAnnotation;
                    PDDestination pdDestination = pdAnnotationLink.getDestination();
                    System.out.println(pdDestination.getClass());
                    PDPageXYZDestination pdPageXYZDestination = (PDPageXYZDestination)pdDestination;
                    pdPageXYZDestination.getCOSObject();

                }
                System.out.println(pdAnnotation.getContents());
            }*/

            /*PDAnnotationTextMarkup markup = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.Su....);
            markup.setRectangle(*//*your PDRectangle*//*);
            markup.setQuads(*//*float array of size eight with all the vertices of the PDRectangle in anticlockwise order*//*);
            pdAnnotations.add(markup);*/
        }

    }
}
