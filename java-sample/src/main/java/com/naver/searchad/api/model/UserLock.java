package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum UserLock {
	ENABLED(0),
	PAUSED(1);

	@Getter(onMethod = @__({@JsonValue}))
	private final int value;

	private UserLock(int value) {
		this.value = value;
	}
}
