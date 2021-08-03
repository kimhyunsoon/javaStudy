package soo.md.service;

import java.util.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface DragdropService {
	Map<String, List<Object>> getUpdateFileName();
	
	MultipartHttpServletRequest getMultipartRequest();
	void setMultipartRequest(MultipartHttpServletRequest multipartRequest);
}
