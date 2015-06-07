package carismadokter.controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K-MiL Caster
 */
class ImageBackgroundEvent implements PdfPCellEvent {

    protected Image image;

    public ImageBackgroundEvent(Image image) {
        this.image = image;
    }

    @Override
    public void cellLayout(PdfPCell cell, Rectangle position,
            PdfContentByte[] canvases) {
        PdfContentByte cb = canvases[PdfPTable.BACKGROUNDCANVAS];
        image.scaleAbsolute(position);
        image.setAbsolutePosition(position.getLeft(), position.getBottom());
        try {
            cb.addImage(image);
        } catch (DocumentException ex) {
            Logger.getLogger(ImageBackgroundEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
