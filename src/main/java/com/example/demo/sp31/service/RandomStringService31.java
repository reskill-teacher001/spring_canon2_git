package com.example.demo.sp31.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

// ランダム文字列サービスクラス
@Service
public class RandomStringService31 {
	private final static int GENERATE_NUM = 10; // 生成文字列の個数

	// ランダムな文字列のリストを生成する処理
	public List<String> generate(int charLength, boolean withNumber) {
		// 生成した文字列を保存するList
		List<String> list = new ArrayList<>();
		
		// 生成する個数分繰り返す
		for (int i = 0; i < GENERATE_NUM; i++) {
			if (withNumber) {
				// 数字を含む文字列をListに追加
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				// 数字を含まない文字列をListに追加
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		
		return list;
	}
	
	public List<String> generate(int charLength, boolean withNumber, int createCount) {
		// 生成した文字列を保存するList
		List<String> list = new ArrayList<>();
		
		// 生成する個数分繰り返す
		for (int i = 0; i < createCount; i++) {
			if (withNumber) {
				// 数字を含む文字列をListに追加
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				// 数字を含まない文字列をListに追加
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		
		return list;
	}
	
	public List<String> generate(int charLength, boolean withNumber, boolean withAlphabet, int createCount) {
		// 生成した文字列を保存するList
		List<String> list = new ArrayList<>();
		
		// 生成する個数分繰り返す
		for (int i = 0; i < createCount; i++) {
			if (withNumber && withAlphabet) {
				// 数字を含む文字列をListに追加
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else if (!withNumber && withAlphabet) {
				// 数字を含まない文字列をListに追加
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			} else if (withNumber && !withAlphabet) {
				// 数字を含まない文字列をListに追加
				list.add(RandomStringUtils.randomNumeric(charLength));
			}
		}
		
		return list;
	}
}
