/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.travel.controller;
import cn.zhuatech.travel.common.ApiResponse;import cn.zhuatech.travel.service.EnterpriseTravelService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/travel") public class EnterpriseTravelController {private final EnterpriseTravelService service;/**
                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                  */
public EnterpriseTravelController(EnterpriseTravelService service){this.service=service;}/**
                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                           */
@PostMapping("/settle") ApiResponse<EnterpriseTravelService.Settlement> settle(@Valid @RequestBody EnterpriseTravelService.SettlementRequest request){return ApiResponse.ok(service.settle(request));}}
