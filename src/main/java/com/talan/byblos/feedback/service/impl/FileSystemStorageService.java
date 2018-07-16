package com.talan.byblos.feedback.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.talan.byblos.common.dto.FeedbackDTO;
import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.utility.exception.ByblosDataAccessException;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.dao.FeedbackDAO;
import com.talan.byblos.feedback.dao.FeedbackFileDAO;
import com.talan.byblos.feedback.exception.StorageException;
import com.talan.byblos.feedback.exception.StorageFileNotFoundException;
import com.talan.byblos.feedback.service.StorageService;
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service
public class FileSystemStorageService implements StorageService {

	private final Path rootLocation;

	@Autowired
	private FeedbackFileDAO feedbackFileDAO;

	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void store(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new StorageException(
						"Cannot store file with relative path outside current directory " + filename);
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new StorageException("Failed to store file " + filename, e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation))
					.map(path -> this.rootLocation.relativize(path));
		} catch (IOException e) {
			throw new StorageException("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new StorageFileNotFoundException("Could not read file: " + filename);

			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}

	
	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly= false, noRollbackFor = Exception.class)
	public FeedbackFileDTO addFile(FeedbackFileDTO feedbackFileDTO) throws ByblosException {
	
		FeedbackFileDTO newFile = new FeedbackFileDTO();
		feedbackFileDTO.setPath(this.rootLocation + "/" +feedbackFileDTO.getFileName());
		newFile = feedbackFileDAO.persist(feedbackFileDTO);
		return newFile;
	}
	
	
	@Override
	public List<FeedbackFileDTO> loadAllFile() {
	List<FeedbackFileDTO> feedbackFileDTO= feedbackFileDAO.loadAllFile();
		return feedbackFileDTO;
	}
	

	@Override
	public Path load(String filename, String filePath) {
		return Paths.get(filePath).resolve(filename);	}

	@Override
	public Resource loadAsResource(String filename, String filePath) throws IOException {

		//byte[] decryptedData = null;
		Path file = load(filename, filePath);

	//try {
		//byte[] encryptedData = Files.readAllBytes(file);
		
	//	} catch (IOException e) {

		//e.printStackTrace();
	//}

	Resource resource = new UrlResource(file.toUri());

	if (resource.exists() || resource.isReadable()) {

			return resource;

		} else {
			throw new StorageFileNotFoundException("Could not read file: " + filename);

		}

}

	@Override
	public List<Long> feedbackAvecfile() {
		List<Long> idFeedbackList = feedbackFileDAO.feedbackAvecfile();
		return idFeedbackList;
	}
	



	
	
}


