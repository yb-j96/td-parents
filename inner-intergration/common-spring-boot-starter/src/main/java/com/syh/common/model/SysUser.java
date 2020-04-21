package com.syh.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51 
 * 用户实体
 */
@Data
public class SysUser implements Serializable {
	private String id;
	private String username;
	private String password;
	private String userType;
	private String recyclingStatus;

}
