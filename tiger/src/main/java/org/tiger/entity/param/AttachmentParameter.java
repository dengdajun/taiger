package org.tiger.entity.param;

import support.support.ExtJSBaseParameter;

/**
 * 附件的参数类
 */
public class AttachmentParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = -1946385245181503185L;
	private String description;
	private String epcId;
	private String $like_belongToId;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEpcId() {
		return epcId;
	}

	public void setEpcId(String epcId) {
		this.epcId = epcId;
	}

	public String get$like_belongToId() {
		return $like_belongToId;
	}

	public void set$like_belongToId(String $like_belongToId) {
		this.$like_belongToId = $like_belongToId;
	}
}
