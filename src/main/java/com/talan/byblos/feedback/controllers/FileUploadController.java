package com.talan.byblos.feedback.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.talan.byblos.common.dto.FeedbackFileDTO;
import com.talan.byblos.common.utility.exception.ByblosException;
import com.talan.byblos.feedback.controllers.uri.FeedbackControllerUriConstants;

import com.talan.byblos.feedback.exception.StorageFileNotFoundException;
import com.talan.byblos.feedback.service.FeedBackService;
import com.talan.byblos.feedback.service.StorageService;

@RestController
@RequestMapping("api")
@RefreshScope
@CrossOrigin("*")
public class FileUploadController {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	StorageService storageService;
	@Autowired
	FeedBackService feedBackService;

	@PostMapping(FeedbackControllerUriConstants.UPLOAD_FILE)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			@PathVariable("id") Long idFeed) throws ByblosException, MessagingException {
		FeedbackFileDTO feedbackFileDTO = new FeedbackFileDTO();
		storageService.store(file);
		feedbackFileDTO.setFileName(file.getOriginalFilename());
		feedbackFileDTO.setFeedbackDTO(feedBackService.loadFeedback(idFeed));
		System.out.println("idFeed " + idFeed);
		// feedbackFileDTO.setFeedbackId(idFeed);
		try {
			feedbackFileDTO = storageService.addFile(feedbackFileDTO);
		} catch (ByblosException e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		// ******************************
		MimeMessage message = sender.createMimeMessage();
		// Enable the multipart flag!
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo("asma.charrada@esprit.tn");
		helper.setText("New Feedback");
		helper.setSubject("feedback");
			helper.addAttachment(feedbackFileDTO.getPath(), file);
		sender.send(message);
		return "redirect:/";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files",
				storageService.loadAll()
						.map(path -> MvcUriComponentsBuilder
								.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
								.build().toString())
						.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	@GetMapping(FeedbackControllerUriConstants.LOAD_ALL_FEEDBACK_FILE)
	@ResponseBody
	public List<FeedbackFileDTO> loadAllFeedbackFile(){
		List<FeedbackFileDTO> feedbackFileList= new ArrayList<FeedbackFileDTO>();
		feedbackFileList= storageService.loadAllFile();
		return feedbackFileList;
	}
	
	@GetMapping(FeedbackControllerUriConstants.DOWNLOAD_FILE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws IOException, ByblosException {

		String filePath = "FeedbackFile"  ;
		FeedbackFileDTO feedbackFileDTO = new FeedbackFileDTO();
		//feedbackFileDTO= storageService.FindDocumentByFilePath(filePath,filename);
		Resource file = storageService.loadAsResource(filename, filePath);
		 return  ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +file.getFilename() + "\"")
				.body(file);
	}
	
	@GetMapping(FeedbackControllerUriConstants.FEEDBACKS_AVEC_FILE)
	@ResponseBody
	public List<Long> feedbackAvecFile(){
		List<Long> idFeedbackList;
		idFeedbackList = storageService.feedbackAvecfile();
		return idFeedbackList;

	
	}
	

}
