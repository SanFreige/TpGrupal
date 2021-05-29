package com.TP.tpversion1.export;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TP.tpversion1.entities.Usuario;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPDFExporter {
	private List<Usuario> listUsuarios;

	public UserPDFExporter(List<Usuario> listUsuarios) {
		super();
		this.listUsuarios = listUsuarios;
	}
	
	
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.RED);
		cell.setPadding(5);
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Nombre",fuente));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Apellido",fuente));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Nro de documento",fuente));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("User name",fuente));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("User id",fuente));
		table.addCell(cell);
	}
	
	private void writeTableData(PdfPTable table) {
		for (Usuario user: this.listUsuarios) {
			table.addCell(user.getNombre());
			table.addCell(user.getApellido());
			table.addCell(String.valueOf(user.getNroDocumento()));
			table.addCell(user.getUsername());
			table.addCell(String.valueOf(user.getId()));
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Lista de todos los usuarios"));//titulo
		
		PdfPTable table = new PdfPTable(5);//cant tablas
		table.setWidthPercentage(100);//distacia entre tablas
		table.setSpacingBefore(15);//espacio con el titulo
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}

}
