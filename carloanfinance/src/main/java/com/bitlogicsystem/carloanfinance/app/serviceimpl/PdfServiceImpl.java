package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.service.PdfService;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.CMYKColor;

@Service
public class PdfServiceImpl implements PdfService {

	@Override
	public ByteArrayInputStream sanctionPdf() {
String title="Sanction Details";
		
		ByteArrayOutputStream out= new ByteArrayOutputStream();
		Document document=new Document();
		PdfWriter.getInstance(document,out);
		document.open();
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		titleFont.setColor(CMYKColor.PINK);
		Paragraph titlePara=new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);
		document.close();
		return new ByteArrayInputStream(out.toByteArray());
	}
	

}
