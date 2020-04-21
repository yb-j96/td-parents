package com.syh.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 *  角色
 */
@Data
public class SysRole implements Serializable {

	private String id;
	private String roleName;
	private String remark;
	private Boolean enable;
	private Long createTime;
	private Long modifyTime;
	private String subordinateUnitID;
}
