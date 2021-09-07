package com.skeqi.htd.controller;

import com.skeqi.htd.common.Result;
import com.skeqi.htd.controller.vo.*;
import com.skeqi.htd.service.HtdServiceFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.skeqi.htd.common.Constants.API_VERSION;
import static com.skeqi.htd.common.Constants.BASE_API;

/**
 * 高驱进销存
 *
 * @author linkin
 */
@Api("高驱进销存")
@RestController
@RequestMapping(value = BASE_API + API_VERSION)
public class HtdController {

	private final HtdServiceFacade facade;

	@Autowired
	public HtdController(HtdServiceFacade facade) {
		this.facade = facade;
	}

	@ApiOperation("获取采购订单列表")
	@PostMapping(value = "/purchaser/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<List<PurchaseOrderVO.ItemVO>> queryPurchaserOrderList(@RequestBody QueryVO.QueryPurchaserOrdersVO vo) {
		return Result.succeed(facade.queryPurchaserOrderList(vo));
	}

	@ApiOperation("获取采购订单详情")
	@GetMapping(value = "/purchaser/order", consumes = MediaType.ALL_VALUE)
	public Result<PurchaseOrderVO.DetailVO> getPurchaserOrderDetail(@RequestParam String exOrderNo) {
		return Result.succeed(facade.doGetPurchaserOrderDetail(exOrderNo));
	}

	@ApiOperation("新增采购订单")
	@PostMapping(value = "/purchaser/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createPurchaserOrderDraft(@RequestBody PurchaseOrderVO.CreateVO vo) {
		facade.createPurchaserOrder(vo);
	}

	@ApiOperation("获取销售订单列表")
	@PostMapping(value = "/sale/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result<List<SaleOrderVO.ItemVO>> querySaleOrderList(@RequestBody QueryVO.QuerySaleOrdersVO vo) {
		return Result.succeed(facade.querySaleOrderList(vo));
	}

	@ApiOperation("获取销售订单详情")
	@GetMapping(value = "/sale/order", consumes = MediaType.ALL_VALUE)
	public Result<PurchaseOrderVO.DetailVO> getSaleOrderDetail(@RequestParam String exOrderNo) {
		return Result.succeed(facade.doGetSaleOrderDetail(exOrderNo));
	}

	@ApiOperation("新增销售订单")
	@PostMapping(value = "/sale/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createSaleOrder(@RequestBody SaleOrderVO.CreateVO vo) {
		facade.createSaleOrder(vo);
	}


	@ApiOperation("获取所有的客户名称")
	@GetMapping(value = "/customer/names", consumes = MediaType.ALL_VALUE)
	public Result<List<String>> getAllCustomerNames() {
		return Result.succeed(facade.getAllCustomerNames());
	}

	@ApiOperation("获取客户下的联系人信息")
	@GetMapping(value = "/customer/contacts", consumes = MediaType.ALL_VALUE)
	public Result<List<CustomerVO>> getCustomersByName(@RequestParam String customerName) {
		return Result.succeed(facade.getCustomersByName(customerName));
	}

	@ApiOperation("获取所有的供应商名称")
	@GetMapping(value = "/supplier/names", consumes = MediaType.ALL_VALUE)
	public Result<List<String>> getAllSupplierNames() {
		return Result.succeed(facade.getAllSupplierNames());
	}

	@ApiOperation("获取对应供应商的联系人信息")
	@GetMapping(value = "/supplier/contacts", consumes = MediaType.ALL_VALUE)
	public Result<List<SupplierVO>> getSuppliersByName(@RequestParam String supplierName) {
		return Result.succeed(facade.getSuppliersByName(supplierName));
	}

	@ApiOperation("订单审批")
	@PutMapping(value = "/order/audit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void auditOrder(@RequestBody AuditVO vo) {
		facade.auditOrder(vo);
	}
}
