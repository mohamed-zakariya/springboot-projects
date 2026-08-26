package com.example.taskTracker;

import com.example.taskTracker.cli.TaskCli;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import picocli.CommandLine;
import picocli.spring.PicocliSpringFactory;

@SpringBootApplication
public class TaskTrackerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new SpringApplicationBuilder(TaskTrackerApplication.class)
						.web(WebApplicationType.NONE)
						.run(args);

		CommandLine commandLine = new CommandLine(
				context.getBean(TaskCli.class),
				new PicocliSpringFactory(context)
		);

		commandLine.setCaseInsensitiveEnumValuesAllowed(true);

		int exitCode = commandLine.execute(args);

		SpringApplication.exit(context, () -> exitCode);
		System.exit(exitCode);
	}

}