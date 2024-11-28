package com.h2.chuizone.template;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadTemplate {
	
	/**
	 * 파일을 물리적으로 저장하기 위한 함수
	 * @param fileName 파일 저장하기 위한 경로 + 파일명
	 * @param file MultiPart객체의 Part객체
	 * @return 성공 유무
	 * @throws IOException Input/Output Exception
	 */
	public static boolean fileUpload(String fileName, Part file) throws IOException {
        file.write(fileName);
        
        return true;
	}
	
	/**
	 * 저장할 파일명을 만들기 위한 함수
	 * @param fileName 원본 파일 이름
	 * @return 저장할 파일 이름
	 * @throws IOException Input/Output Exception
	 */
	public static String getFileName(String fileName) throws IOException {
        String name = UUID.randomUUID().toString().replace("-", "");
        return name + "_" + fileName;
	}
}
