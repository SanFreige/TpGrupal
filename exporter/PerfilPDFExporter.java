package com.TP.tpversion1.export;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TP.tpversion1.entities.Perfil;
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

public class PerfilPDFExporter {
	
	private List<Perfil> listPerfil;

	public PerfilPDFExporter(List<Perfil> listPerfil) {
		super();
		this.listPerfil = listPerfil;
	}
	
	
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.RED);
		cell.setPadding(5);
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Id",fuente));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("ROl",fuente));
		table.addCell(cell);
				
	}
	
	private void writeTableData(PdfPTable table) {
		for (Perfil perfil: this.listPerfil) {
			table.addCell(String.valueOf(perfil.getId()));
			table.addCell(perfil.getRol());
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Lista de todos los usuarios"));//titulo
		
		PdfPTable table = new PdfPTable(2);//cant tablas
		table.setWidthPercentage(100);//distacia entre tablas
		table.setSpacingBefore(15);//espacio con el titulo
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}

}
