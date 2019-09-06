package com.steer.demo.controller;

import com.steer.demo.common.model.Result;
import com.steer.demo.dto.*;
import com.steer.demo.service.CouponService;
import com.steer.demo.service.GoodService;
import com.steer.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 14:15
 */
@RestController()
@RequestMapping("/api/index")
public class IndexController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private CouponService couponService;

    @GetMapping("")
    public Object index(){
        IndexInfo info = new IndexInfo();
        initData(info);
        return Result.successReult(info);
    }

    private void initData(IndexInfo info) {
        info.setLogoUrl("http://127.0.0.1:8000/demo/static/images/logo.jpeg");
        info.setBanner(this.initImgUrls());
        info.setMenus(menuService.selectAll());
        info.setRoll(this.initRolls());
        info.setActivity(this.initActivity());
        info.setBenefit(goodService.selectBenefits());
        info.setInfo(this.initInfo());
        info.setLikeInfo(goodService.selectHots());
        info.setLovelyBanner(this.initLovelyBanner());
        info.setCouponList(couponService.selectAll());
    }

    private List<BastBannerDto> initLovelyBanner() {
        List<BastBannerDto> lovelyBanners = new ArrayList<>();
        lovelyBanners.add(new BastBannerDto("http://127.0.0.1:8000/demo/static/images/banner-1.jpeg"));
        return lovelyBanners;
    }

    private InfoDto initInfo() {
        InfoDto infoDto = new InfoDto();
        infoDto.setFastInfo("快来挑选你的心仪商品");
        infoDto.setFastList(this.initFastList());
        infoDto.setFirstInfo("最新的商品上架了！");
        infoDto.setFirstList(goodService.selectFirsts());
        infoDto.setBastInfo("点我看更多精品商品");
        infoDto.setBastBanner(this.initBastBanner());
        infoDto.setBastList(goodService.selectBasts());
        infoDto.setSalesInfo("限时促销，优惠多多");
        return infoDto;
    }

    private List<FastDto> initFastList() {
        List<FastDto> fastDtos = new ArrayList<>();
        fastDtos.add(new FastDto(",","http://127.0.0.1:8000/demo/static/images/fast-1.jpeg","小商品1"));
        fastDtos.add(new FastDto(",","http://127.0.0.1:8000/demo/static/images/fast-1.jpeg","小商品2"));
        fastDtos.add(new FastDto(",","http://127.0.0.1:8000/demo/static/images/fast-1.jpeg","小商品3"));
        fastDtos.add(new FastDto(",","http://127.0.0.1:8000/demo/static/images/fast-1.jpeg","小商品4"));
        return fastDtos;
    }

    private List<BastBannerDto> initBastBanner() {
        List<BastBannerDto> bastBannerDtos = new ArrayList<>();
        bastBannerDtos.add(new BastBannerDto(",","http://127.0.0.1:8000/demo/static/images/navi-1.jpeg"));
        bastBannerDtos.add(new BastBannerDto(",","http://127.0.0.1:8000/demo/static/images/navi-2.jpeg"));
        return bastBannerDtos;
    }

    private List<Activity> initActivity() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(",","http://127.0.0.1:8000/demo/static/images/activity-1.jpeg","秒杀专区","快来秒杀"));
        activities.add(new Activity(",","http://127.0.0.1:8000/demo/static/images/activity-2.jpeg","活动专区","快来抢新品"));
        activities.add(new Activity(",","http://127.0.0.1:8000/demo/static/images/activity-3.jpeg","活动专区2","快来抢新品222"));
        return activities;
    }

    /**
     * id为偶数，前端显示有“最新”样式
     * @return
     */
    private List<Roll> initRolls() {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(1111,"商品1上线了",""));
        rolls.add(new Roll(22222,"商品2222上线了发的发打放大发动发动发",""));
        return rolls;
    }

    /**
     * 首页滚动图
     * @return
     */
    private List<Banner> initImgUrls() {
        List<Banner> list = new ArrayList<>();
        list.add(new Banner("","http://127.0.0.1:8000/demo/static/images/navi-1.jpeg"));
        list.add(new Banner("","http://127.0.0.1:8000/demo/static/images/navi-2.jpeg"));
        list.add(new Banner("","http://127.0.0.1:8000/demo/static/images/navi-3.jpeg"));
        return list;
    }
}
