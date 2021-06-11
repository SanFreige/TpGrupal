package com.unla.grupo12.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo12.service.impl.QRCodeGenerator;


@RestController
//@RequestMapping("/qr")
public class QRCodeController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
												  
	
	@GetMapping(value = "/generateAndDownloadQRCode")
	public void download2(@RequestParam(name="codeText", required=false, defaultValue="null") String codeText,
						  @RequestParam(name="width", required=false, defaultValue="null") Integer width,
						  @RequestParam(name="height", required=false, defaultValue="null") Integer height) throws Exception{
		QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
	}
	
	/*@GetMapping(value = "/generateAndDownloadQRCode/{codeText}/{width}/{height}")
	public void download(@PathVariable("codeText") String codeText,
						 @PathVariable("width") Integer width,
						 @PathVariable("height") Integer height) throws Exception{
		QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
	}*/
				
	@GetMapping(value = "/generateQRCode/{codeText}/{width}/{height}")
	public ResponseEntity<byte[]> generateQRCode(@PathVariable("codeText") String codeText,
												@PathVariable("width") Integer width,
												@PathVariable("height")Integer height) throws  Exception{
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));	                                          
	}

}
