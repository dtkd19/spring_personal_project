package com.sh.spring.handler;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sh.spring.dao.FileDAO;
import com.sh.spring.domain.FileVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableScheduling
public class FileSweeper {
	private final FileDAO fdao;
	private final String BASE_PATH = "D:\\_myProject\\_java\\_imageBox\\";
	
	@Scheduled(cron = "0 0 12 * * *")
	public void fileSweeper() {
		log.info(">>> fileSweeper Running Start~!! : {} ", LocalDateTime.now());
		
		List<FileVO> dbList = fdao.selectListAllFile();
		
		List<String> currFiles = new  ArrayList<String>();
		for(FileVO fvo : dbList) {
			String filePath = fvo.getSaveDir()+File.separator+fvo.getUuid();
			String fileName = fvo.getFileName();
			currFiles.add(BASE_PATH+filePath+"_"+fileName);
			
			// 이미지라면 썸네일경로도 추가 이미지파일 = fileType 1 
			if(fvo.getFileType() > 0 ) {
				currFiles.add(BASE_PATH+filePath+"_th_"+fileName);
			}	
		}
		log.info(">>> currFiles >> {}", currFiles);
		
		LocalDate now = LocalDate.now();
		String today = now.toString();
		today = today.replace("-", File.separator);
		
		File dir = Paths.get(BASE_PATH+today).toFile();
		// listFiles() : 경로안에 있는 모든 파일을 배열로 리턴
		File[] allFileObject = dir.listFiles();
			
		// 실제 저장되어있는 파일목록과, DB의 존재 파일을 비교하여 없는 파일은 삭제 진행
		for(File file : allFileObject) {
			String storedFileName = file.toPath().toString();
			if(!currFiles.contains(storedFileName)) {
				file.delete(); // 파일 삭제
				log.info(">>>> delete files >> {}", storedFileName);
			}
		}
		
			
		log.info(">>> fileSweeper Running End~!! : {} ", LocalDateTime.now());
		
		
		
	}

}
