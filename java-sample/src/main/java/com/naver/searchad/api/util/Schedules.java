package com.naver.searchad.api.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 확장 소재에서 사용하는 스케쥴에 관한 util<p>
 * 이 클래스를 이용하면 스케쥴(schedule)을 쉽게 얻을 수 있다.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Schedules {

	/**
	 * 모든 요일 및 시간의 schedule
	 *
	 * @return null
	 */
	public static Map<String, Object> everyDayAndHour() {
		return null;
	}

	/**
	 * 일부 요일 및 시간에 대한 schedule
	 *
	 * @return 요일 및 시간 설정을 위한 Builder 객체
	 * @implNote 매주 금요일과 토요일에 18시부터 20시까지 노출하고 싶은 경우 <br>
	 *
	 * <pre>
	 * {@code
	 * Schedules.builder()
	 * 	.friday(18, 19, 20)
	 * 	.saturday(18, 19, 20)
	 * 	.build();
	 * }
	 * </pre>
	 */
	public static ScheduleBuilder builder() {
		return new ScheduleBuilder();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class ScheduleBuilder {
		private Map<DayOfWeek, Set<Integer>> schedule = new EnumMap<>(DayOfWeek.class);

		public ScheduleBuilder monday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.MONDAY, hoursOfDay);
		}

		public ScheduleBuilder tuesday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.TUESDAY, hoursOfDay);
		}

		public ScheduleBuilder wednesday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.WEDNESDAY, hoursOfDay);
		}

		public ScheduleBuilder thursday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.THURSDAY, hoursOfDay);
		}

		public ScheduleBuilder friday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.FRIDAY, hoursOfDay);
		}

		public ScheduleBuilder saturday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.SATURDAY, hoursOfDay);
		}

		public ScheduleBuilder sunday(Integer... hoursOfDay) {
			return schedule(DayOfWeek.SUNDAY, hoursOfDay);
		}

		public ScheduleBuilder schedule(DayOfWeek dayOfWeek, Integer... hoursOfDay) {
			if (hoursOfDay == null) {
				throw new IllegalArgumentException("Hour of day(value) should not be null");
			}
			for (Integer hourOfDay : hoursOfDay) {
				if (hourOfDay < 0 || hourOfDay > 23) {
					throw new IllegalArgumentException("Invalid hour element of set detected: " + hourOfDay);
				}
			}
			schedule.put(dayOfWeek, new HashSet<>(Arrays.asList(hoursOfDay)));
			return this;
		}

		/**
		 *
		 * @return 특정 요일 및 시간 스케쥴이 적용된 Map
		 */
		public Map<String, Object> build() {
			return DAY_OF_WEEK_MAP.entrySet().stream()
					.collect(Collectors.toMap(
							Map.Entry::getValue,
							entry -> schedule.getOrDefault(entry.getKey(), Collections.emptySet()).stream()
									.map(hourOfDay -> 1 << hourOfDay).reduce(0, Integer::sum)
					));
		}

		private static final Map<DayOfWeek, String> DAY_OF_WEEK_MAP = new EnumMap<>(DayOfWeek.class);

		static {
			DAY_OF_WEEK_MAP.put(DayOfWeek.MONDAY, "MON");
			DAY_OF_WEEK_MAP.put(DayOfWeek.TUESDAY, "TUE");
			DAY_OF_WEEK_MAP.put(DayOfWeek.WEDNESDAY, "WED");
			DAY_OF_WEEK_MAP.put(DayOfWeek.THURSDAY, "THU");
			DAY_OF_WEEK_MAP.put(DayOfWeek.FRIDAY, "FRI");
			DAY_OF_WEEK_MAP.put(DayOfWeek.SATURDAY, "SAT");
			DAY_OF_WEEK_MAP.put(DayOfWeek.SUNDAY, "SUN");
		}
	}

}
