package cn.whu.good.controller;

import cn.whu.BaseController;
import cn.whu.bo.GoodStockBO;
import cn.whu.good.StorageControllerApi;
import cn.whu.good.service.StorageService;
import cn.whu.grace.result.GraceJsonResult;
import cn.whu.pojo.TStock;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.Binding;
import javax.validation.Valid;

/**
 * @author snow
 * @className StorageController
 * @date 2021/6/30
 **/
@RestController
public class StorageController extends BaseController implements StorageControllerApi {
    @Resource
    StorageService storageService;


    @Override
    public GraceJsonResult queryStock(String goodId) {
        TStock stock = storageService.queryStorage(goodId);
        return GraceJsonResult.ok(stock);
    }

    @Override
    public GraceJsonResult reduceStock(@Valid GoodStockBO goodStockBO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return GraceJsonResult.errorMap(getErrors(bindingResult));
        }
        storageService.reduceStorage(goodStockBO);
        return GraceJsonResult.ok();
    }
}
