package com.utk.utils;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.HttpServletRequest;

public class UrlUtil {

	public static String encodeUrlPathSegment(String path, HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();

		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}

		path = UriUtils.encodePathSegment(path, enc);

		return path;
	}

}
