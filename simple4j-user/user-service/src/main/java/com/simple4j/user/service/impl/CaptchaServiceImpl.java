package com.simple4j.user.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.simple4j.user.common.constant.CacheNames;
import com.simple4j.user.response.CaptchaResponse;
import com.simple4j.user.service.ICaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author hyc
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements ICaptchaService {

	private final RedisTemplate redisTemplate;

	@Override
	public CaptchaResponse captcha() {
		CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(130, 48);
		String verCode = circleCaptcha.getCode();
		String imageBase64 = circleCaptcha.getImageBase64();
		String key = UUID.randomUUID().toString();
		// 存入redis并设置过期时间为30分钟
		redisTemplate.opsForValue()
				.set(CacheNames.CAPTCHA_KEY + key, verCode, 30L, TimeUnit.MINUTES);
		// 将key和base64返回给前端
		CaptchaResponse captchaResponse = new CaptchaResponse();
		captchaResponse.setKey(key);
		captchaResponse.setImage("data:image/jpg;base64," + imageBase64);
		return captchaResponse;
	}
}