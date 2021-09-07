package com.skeqi.htd.po.entity;

import lombok.Data;

/**
 * 流程消息,流程消息推送给审核人，提醒进行流程操作(主要是审核)
 *
 * @author linkin
 */
@Data
public class FlowMessage {
	/**
	 * 消息接收人
	 */
	private String receiver;
	/**
	 * 消息接收人id
	 */
	private String receiverId;
}
