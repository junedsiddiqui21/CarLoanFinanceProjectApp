package com.bitlogicsystem.carloanfinance.app.model;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GenerateSanctionPDF {

	public ByteArrayOutputStream generatePdf(String title, String content, int sanctionid, List<SanctionLetter> stus) 
	{
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		Document document=new Document();
		
		PdfWriter.getInstance(document, outputStream);
		
		document.open();
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String formatedDate=dateFormat.format(date);
		String to="Date:-"+formatedDate;
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		titleFont.setColor(CMYKColor.red);
		Paragraph titlePara = new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);
		Font toFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		
		
		
		
		Paragraph textPara=new Paragraph(content);
		textPara.setSpacingBefore(10);
		document.add(textPara);
		
		
//	............................Table......................................................................
		
		PdfPTable table=new PdfPTable(5);
		table.setWidths(new int[] {1,3,5,3,3});
		table.setWidthPercentage(100F);
		table.setSpacingBefore(20);
		
		
		
		//...............................Cell.....................................................
		
		
		PdfPCell headcell=new PdfPCell();
		headcell.setPadding(5);
		headcell.setPaddingLeft(10);
		headcell.setBackgroundColor(CMYKColor.red);
		Font headCellFont=FontFactory.getFont(FontFactory.COURIER_BOLD);
		headCellFont.setColor(CMYKColor.white);
		
		
		
		//....................................Adding Phress......................................................
		
		
		headcell.setPhrase(new Phrase("ID",headCellFont));
		table.addCell(headcell);
		
		headcell.setPhrase(new Phrase("Loanamount",headCellFont));
		table.addCell(headcell);
		
		headcell.setPhrase(new Phrase("LoanType",headCellFont));
		table.addCell(headcell);
		
		headcell.setPhrase(new Phrase("monthaly_emisanctioned",headCellFont));
		table.addCell(headcell);
		
		headcell.setPhrase(new Phrase("tenureyearsanctioned",headCellFont));
		table.addCell(headcell);
		
		PdfPCell dataCell=new PdfPCell();
		dataCell.setPadding(3);
		dataCell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		
		stus.forEach(s->{
			dataCell.setPhrase(new Phrase(String.valueOf(s.getSanctionId())));
			table.addCell(dataCell);
			
			dataCell.setPhrase(new Phrase(String.valueOf(s.getApplicantName())));
			table.addCell(dataCell);
			
			dataCell.setPhrase(new Phrase(s.getContactDetails()));
			table.addCell(dataCell);
			
			dataCell.setPhrase(new Phrase(String.valueOf(s.getLoanAmmountSanctioned())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getInterestType())));
			table.addCell(dataCell);
			
			
			dataCell.setPhrase(new Phrase(String.valueOf(s.getRateOfInterest())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getLoanTenure())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getMonthlyEmiAmmount())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getModeOfPayment())));
			table.addCell(dataCell);
			
			dataCell.setPhrase(new Phrase(String.valueOf(s.getRemarks())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getTermCondition())));
			table.addCell(dataCell);
			dataCell.setPhrase(new Phrase(String.valueOf(s.getStatus())));
			table.addCell(dataCell);
		});
		document.add(table);
		
//		thankPara.setAlignment(Element.ALIGN_RIGHT);
	
//		document.close();
		
		
		document.close();
		
		return outputStream;
	}

}
