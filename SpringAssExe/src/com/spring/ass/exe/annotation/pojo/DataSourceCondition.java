package com.spring.ass.exe.annotation.pojo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataSourceCondition implements Condition {

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		Environment environment = arg0.getEnvironment();
		return environment.containsProperty("jdbc.database.url")
				&&environment.containsProperty("jdbc.database.driver")
				&&environment.containsProperty("jdbc.database.username")
				/*&&environment.containsProperty("jdbc.database.password")*/;
	}

}
