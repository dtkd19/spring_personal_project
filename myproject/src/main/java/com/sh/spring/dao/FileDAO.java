package com.sh.spring.dao;

import java.util.List;

import com.sh.spring.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO fvo);

	List<FileVO> getList(int bno);

	int fileDelete(String uuid);

	FileVO getFvo(String uuid);

	List<FileVO> selectListAllFile();

}
