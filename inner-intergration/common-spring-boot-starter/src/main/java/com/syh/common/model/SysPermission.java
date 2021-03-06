package com.syh.common.model;


import lombok.Data;

import java.io.Serializable;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 *  权限标识
 */
@Data
public class SysPermission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1389727646460449239L;

	private Long id;
	private String permission;
	private String name;

}
