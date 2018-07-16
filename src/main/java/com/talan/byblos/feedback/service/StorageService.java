package com.talan.byblos.feedback.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.utility.exception.ByblosException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	void store(MultipartFile file);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();

	public FeedbackFileDTO addFile(FeedbackFileDTO feedbackFileDTO) throws ByblosException;
	

	/**
	 * Affcher tout les fichier
	 * @return
	 */
	List<FeedbackFileDTO> loadAllFile();
	
//	 Resource loadAsResource(String filename, String filePath)throws IOException;
 
	 
	 /**
		 * les feedback qui ont des file
		 */
		List<Long> feedbackAvecfile();

	Path load(String filename, String filePath);

	Resource loadAsResource(String filename, String filePath) throws IOException;



	
	
}
