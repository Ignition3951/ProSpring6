package com.utk.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.utk.entity.AbstractEntity;
import com.utk.entity.Singer;
import com.utk.entity.SingerForm;
import com.utk.service.SingerService;
import com.utk.utils.UrlUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/singers")
public class SingersController {

	private static Comparator<AbstractEntity> COMPARATOR_ID = Comparator.comparing(AbstractEntity::getId);

	private final SingerService singerService;

	private final MessageSource messageSource;

	public SingersController(SingerService singerService, MessageSource messageSource) {
		this.singerService = singerService;
		this.messageSource = messageSource;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Singer> singers = singerService.findAll();
		singers.sort(COMPARATOR_ID);
		model.addAttribute("singers", singers);
		return "singers/list";
	}

	@GetMapping(value = "/create")
	public String showCreateForm(Model model) {
		model.addAttribute("singerForm", new SingerForm());
		return "singers/create";
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String create(@Valid SingerForm singerForm, BindingResult bindingResult,
			HttpServletRequest httpServletRequest, Model model, Locale locale) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", messageSource.getMessage("singer.save.fail", new Object[] {}, locale));
			model.addAttribute("singerForm", singerForm);
			return "singers/create";
		} else {
			model.asMap().clear();

			Singer singer = new Singer();
			singer.setFistName(singerForm.getFirstName());
			singer.setLastName(singerForm.getLastName());
			singer.setBirthDate(singerForm.getBirthDate());

			if (!(singerForm.getMultipartFile().isEmpty())) {
				setPhoto(singer, singerForm.getMultipartFile());
			}

			Singer createdSinger = singerService.save(singer);

			return "redirect:/singer/"
					+ UrlUtil.encodeUrlPathSegment(createdSinger.getId().toString(), httpServletRequest);
		}
	}

	static void setPhoto(Singer singer, MultipartFile multipartFile) throws IOException {
		InputStream inputStream = multipartFile.getInputStream();
		byte[] fileContent = IOUtils.toByteArray(inputStream);
		singer.setPhoto(fileContent);
	}

}
