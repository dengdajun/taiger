package org.tiger.controller;

import support.core.JavaEEFrameworkBaseController;
import org.tiger.entity.Attachment;
import org.tiger.service.AttachmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 附件的控制层
 */
@Controller
@RequestMapping("/sys/attachment")
public class AttachmentController extends JavaEEFrameworkBaseController<Attachment> {

	@Resource
	private AttachmentService attachmentService;

}
