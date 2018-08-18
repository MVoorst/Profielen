package com.MarjoPosse.Profielen;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.ProtectDocument;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.DocumentSettingsPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.STDocProtect;

public class test {

	public static void main(String[] args) {
		//Provider[] Providers = java.security.Security.getProviders();
//		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
//		Random random = null;
//		try {
//			random = java.security.SecureRandom.getInstance("NativePRNGNonBlocking");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		StringBuilder sbGeneratedPassword = new StringBuilder();
//	    for (int i = 0; i < 16; i++) {
//	        sbGeneratedPassword.append(characters.charAt(random.nextInt(characters.length())));
//	     }
//		System.out.println(sbGeneratedPassword.toString());
		//Random random = new Random();
		

		/*
		for (Provider p : Security.getProviders()) {
            for (Object o : p.keySet()) {
                System.out.println(o);
            }
		}*/

		
//		SpringApplication.run(ProfielenApplication.class, args);

		String VoorNaam = "Henk";
        System.err.println("Test");

//        //Blank Document
//        XWPFDocument document = new XWPFDocument();
//
//        //Write the Document in file system
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream( new File("createdocument.docx"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            document.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("createdocument.docx written successully");

//		WordprocessingMLPackage wordMLPackage = null;
//		try {
//			wordMLPackage = WordprocessingMLPackage.createPackage();
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		}
//		MainDocumentPart mainDocument = wordMLPackage.getMainDocumentPart();
//		mainDocument.addStyledParagraphOfText("Title", "Qien CV");
//		mainDocument.addParagraphOfText(
//				"Naam: " + VoorNaam);
//		;
//		File exportFile = new File(System.currentTimeMillis()+".QienCV.docx");
//		try {
//			wordMLPackage.save(exportFile);
//		} catch (Docx4JException e) {
//			e.printStackTrace();
//		}

        WordprocessingMLPackage wordMLPackage = null;
        try {
            wordMLPackage = WordprocessingMLPackage.createPackage();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();

        mdp.addParagraphOfText("hello world");

		ProtectDocument protection = new ProtectDocument(wordMLPackage);
		protection.restrictEditing(STDocProtect.READ_ONLY, "foobaa");


        String filename = System.getProperty("user.dir") + "/" + System.currentTimeMillis() + ".OUT_hello.docx";
        try {
            Docx4J.save(wordMLPackage, new java.io.File(filename), Docx4J.FLAG_SAVE_ZIP_FILE);
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
        System.out.println("Saved " + filename);


    }
}


		
		