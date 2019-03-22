package br.cesjf.lpwsd.beans;


import br.cesjf.lpwsd.dao.AssuntoDAO;
import br.cesjf.lpwsd.model.TbAssunto;
import java.util.ArrayList;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author tassio
 */
@ManagedBean(name = "assuntoBean")
@ViewScoped
public class TbAssuntoBean {

    TbAssunto assunto = new TbAssunto();

    List assuntos = new ArrayList();

    public TbAssuntoBean() {
        assuntos = new AssuntoDAO().getAll();
        assunto = new TbAssunto();
    }

    public void record(ActionEvent actionEvent) {
        new AssuntoDAO().save(assunto);
        assuntos = new AssuntoDAO().getAll();
        assunto = new TbAssunto();

    }

    public void exclude(ActionEvent actionEvent) {
        new AssuntoDAO().deleteTbAssunto(assunto);
        assuntos = new AssuntoDAO().getAll();
        assunto = new TbAssunto();
    }

    public TbAssunto getAssunto() {
        return assunto;
    }

    public void setAssunto(TbAssunto assunto) {
        this.assunto = assunto;
    }

    public List getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List assuntos) {
        this.assuntos = assuntos;
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }

}
