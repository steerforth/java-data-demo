package com.steer.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.steer.demo.common.model.Result;
import com.steer.demo.dto.AttrValueDto;
import com.steer.demo.dto.GoodDto;
import com.steer.demo.dto.ProductAttrDto;
import com.steer.demo.model.Good;
import com.steer.demo.model.GoodDetail;
import com.steer.demo.service.GoodDetailService;
import com.steer.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodDetailService goodDetailService;

    @GetMapping("/hot")
    public Object hot(int page,int limit){
        Page<Good> goods = goodService.selectHotsByPage(page,limit);
        return Result.successReult(goods.getRecords());
    }

    /**
     *
     * 获取某个用户的产品分销二维码
     * @param id good_id
     * @return
     */
    @GetMapping("/code/{id}")
    public Object hot( @PathVariable long id,@RequestParam String user_type,HttpServletRequest request){
        if (request.getAttribute("userId") == null){
            return Result.errorResult(-1);
        }
        if ("routine".equals(user_type)) {
            Map<String, String> map = new HashMap<>();
            map.put("code", "http://127.0.0.1:8000/demo/static/images/qrcode.jpeg");
            return Result.successReult(map);
        }
        return Result.successReult();
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable long id){
        GoodDetail detail = goodDetailService.selectByGoodId(id);
        List<String> sliderImgs = this.getSliderImg();
        detail.getStoreInfo().setSliderImage(sliderImgs);
        this.preparePoductAttr(detail);
        this.prepareProductValue(detail);
        return Result.successReult(detail);
    }

    private void prepareProductValue(GoodDetail detail) {
//        List<String> first = null;
//        List<String> keys = new ArrayList<>();
//        for (int i=0;i<detail.getProductAttr().size();i++){
//            if (i==0){
//                first = detail.getProductAttr().get(i).getAttrValues();
//                continue;
//            }
//            for (int j = 0; j < first.size(); j++) {
//                StringBuilder builder = new StringBuilder();
//                keys.add(builder.append(first.get(j)).append(",").append());
//            }
//            productAttr.getAttrValues()
//        }
//        detail.getProductAttr().stream().forEach(productAttr->{
//            productAttr.getAttrValues()
//        });

        GoodDto goodDto = new GoodDto(100,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1000,detail.getGoodId(),10,888,"1斤装,普通","");
        GoodDto goodDto2 = new GoodDto(122,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1222,detail.getGoodId(),4,1000,"1斤装,高级","");
        GoodDto goodDto3 = new GoodDto(133,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1333,detail.getGoodId(),5,777,"5斤装,普通","");
        GoodDto goodDto4 = new GoodDto(144,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1444,detail.getGoodId(),7,567,"5斤装,高级","");
        GoodDto goodDto5 = new GoodDto(155,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1555,detail.getGoodId(),8,55,"10斤装,普通","");
        GoodDto goodDto6 = new GoodDto(166,"http://127.0.0.1:8000/demo/static/images/bast-1.jpeg",1666,detail.getGoodId(),9,78,"10斤装,高级","");

        Map<String,GoodDto> productValue = new HashMap<>();
        productValue.put("1斤装,普通",goodDto);
        productValue.put("1斤装,高级",goodDto2);
        productValue.put("5斤装,普通",goodDto3);
        productValue.put("5斤装,高级",goodDto4);
        productValue.put("10斤装,普通",goodDto5);
        productValue.put("10斤装,高级",goodDto6);
        detail.setProductValue(productValue);
    }

    private void preparePoductAttr(GoodDetail detail) {
        AttrValueDto attrValue1 = new AttrValueDto();
        attrValue1.setAttr("1斤装");
        AttrValueDto attrValue2 = new AttrValueDto();
        attrValue2.setAttr("5斤装");
        AttrValueDto attrValue3 = new AttrValueDto();
        attrValue3.setAttr("10斤装");
        List<AttrValueDto> attrValueDtoList = new ArrayList<>();
        attrValueDtoList.add(attrValue1);
        attrValueDtoList.add(attrValue2);
        attrValueDtoList.add(attrValue3);
        ProductAttrDto productAttr = new ProductAttrDto();
        productAttr.setProductId(detail.getGoodId());
        productAttr.setAttrName("打包规格");
        productAttr.setAttrValue(attrValueDtoList);


        AttrValueDto attrValue10 = new AttrValueDto();
        attrValue10.setAttr("普通");
        AttrValueDto attrValue20 = new AttrValueDto();
        attrValue20.setAttr("高级");
        List<AttrValueDto> attrValueDtoList2 = new ArrayList<>();
        attrValueDtoList2.add(attrValue10);
        attrValueDtoList2.add(attrValue20);
        ProductAttrDto productAttr2 = new ProductAttrDto();
        productAttr2.setProductId(detail.getGoodId());
        productAttr2.setAttrName("品质级别");
        productAttr2.setAttrValue(attrValueDtoList2);

        List<ProductAttrDto> productAttrList = new ArrayList<>();
        productAttrList.add(productAttr);
        productAttrList.add(productAttr2);
        detail.setProductAttr(productAttrList);
    }

    private List<String> getSliderImg() {
        List<String> imgs = new ArrayList<>();
        imgs.add("http://127.0.0.1:8000/demo/static/images/good-1.jpeg");
        imgs.add("http://127.0.0.1:8000/demo/static/images/good-2.jpeg");
        imgs.add("http://127.0.0.1:8000/demo/static/images/good-3.jpeg");
        return imgs;
    }
}
